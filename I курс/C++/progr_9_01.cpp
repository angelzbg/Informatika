/* ����: progr_9_01.cpp
   ���������� �� ������������ (C++)
   �������� ������� �� ������ 9.1
   ���������: ����� ������
   ���� 2017 ������
*/

#include <iostream>
using namespace std;
#include <cstring>
const short imeSabirachD = 50,
            vidGabaD = 18;
const char vidoveGabi[][vidGabaD + 1] =
                     { "��������", //0
                       "�������", //1
                       "�������", //2
                       "�������� ���������", //3
                       "���������", //4
                       "�����", //5
                       "������� ����", //6
                       "��������� ��������", //7
                       "��� ������", //8
                       "����" //9
                     };
const short broyVidove = sizeof(vidoveGabi) / sizeof(vidoveGabi[0]);
struct TPartida {
  char kod[11], ime[imeSabirachD + 1];
  double cena1kg, kolichestvo;
};
double CenaPartida(const TPartida & p) { return p.cena1kg*p.kolichestvo; }
bool PravilnaData(short d, short m, short g) {
  if (g <= 2000 || 2099 < g) return false;
  if (m < 1 || 12 < m) return false;
  switch (m) {
  case 4: case 6: case 9: case 11: return 1 <= d && d <= 30;
  case 2: return 1 <= d && d <= 28 + (g%400==0 || g%100!=0 && g%4==0);
  default: return 1 <= d && d <= 31;
  }
}
void VhodPartida(TPartida & p) {
  short d, m, g;
  do {
    cout << "   ���� ����� ������ �� ���������� �� ������: ";
    cin >> d >> m >> g;
    cin.ignore(1);
  } while ( ! PravilnaData(d,m,g) );
  p.kod[0] = d / 10 + '0';
  p.kod[1] = d % 10 + '0';
  p.kod[2] = m / 10 + '0';
  p.kod[3] = m % 10 + '0';
  //p.kod[4] = g / 10 % 10 + '0';
  p.kod[4] = g % 100 / 10 + '0';
  p.kod[5] = g % 10 + '0';
  char vid[vidGabaD + 1];
  cout << "   ��� ����: ";
  cin.getline(vid, vidGabaD + 1);
  short i = 0;
  while (i<broyVidove-1)
    if ( strcmp(vid, vidoveGabi[i]) ) ++i;
    else break;
  p.kod[6] = i + '0';
  do {
    cout << "   �������� �� ������ (�-����; �-������; �-�������): ";
    cin >> p.kod[7];
    cin.ignore(1);
  } while (p.kod[7] != '�' && p.kod[7] != '�' && p.kod[7] != '�' );
  bool pravilnoIme;
  do {
    cout << "   ��� ������� (�� ��������): ";
    cin.getline(p.ime, imeSabirachD + 1);
        pravilnoIme = '�' <= p.ime[0] && p.ime[0] <= '�';
        if (pravilnoIme) {
          i = 1;
          while ('�' <= p.ime[i] && p.ime[i] <= '�') ++i;
          pravilnoIme = p.ime[i] == ' ' &&
                        '�' <= p.ime[i+1] && p.ime[i+1] <= '�';
        }
        if (pravilnoIme) {
          i += 2;
          while ('�' <= p.ime[i] && p.ime[i] <= '�') ++i;
          pravilnoIme = p.ime[i] == 0;
        }
  } while ( ! pravilnoIme );
  p.kod[8] = p.ime[0];
  p.kod[9] = *(1 + strchr(p.ime, ' '));
  p.kod[10] = 0;
  do {
    cout << "   ����������: ";
    cin >> p.kolichestvo;
  } while (p.kolichestvo <= 0.0);
  do {
    cout << "   ���� �� 1 ��: ";
    cin >> p.cena1kg;
  } while (p.cena1kg <= 0.0);
}
void VhodMasiv(TPartida * mas, short len) {
  for (short i = len - 1; 0 <= i; --i) {
    cout << "�������� ����� �� " << i + 1 << "-��� �������:\n";
    VhodPartida(mas[i]);
  }
}
void IzhodPartida(const TPartida & p) {
  cout << "     ���: " << p.kod << endl;
  cout << "          ���� �� ��������: " << p.kod[0] << p.kod[1] << '.'
       << p.kod[2] << p.kod[3] << ".20" << p.kod[4] << p.kod[5] << endl;
  cout << "          ��� �� ������: " << vidoveGabi[p.kod[6] - '0'] << endl;
  cout << "          ��������: ";
  switch (p.kod[7]) {
    case '�': cout << "����\n"; break;
    case '�': cout << "������\n"; break;
    default: cout << "�������\n";
  }
  cout << "          �������� �� ��������: " << p.kod[8] << p.kod[9] << endl;
  cout << "     ��� �� ��������: " << p.ime << endl;
  cout << "     ����������: " << p.kolichestvo << endl;
  cout << "     ���� �� 1 ��: " << p.cena1kg << endl;
  cout << "     ���� �� ������ �������: " << CenaPartida(p) << endl;
}
void IzhodMasiv(TPartida *m, short len) {
  cout << "  ***  ����� �� ������ �������  ***\n";
  for (short i = 0; i < len; ++i) {
    cout << i + 1 << "-� �������:\n";
    IzhodPartida(m[i]);
  }
}
double MinCena1kg(TPartida *m, short len, short & brM) {
  double min = m[0].cena1kg;
  brM = 1;
  for (short i = 1; i < len; ++i)
    if (m[i].cena1kg < min) { min = m[i].cena1kg; brM = 1; }
    else if (m[i].cena1kg == min) ++brM;
  return min;
}
double MaxCenaPartida(TPartida *m, short len) {
  double max = CenaPartida(m[0]);
  for (short i = 1; i < len; ++i)
    if (max < CenaPartida(m[i])) max = CenaPartida(m[i]);
  return max;
}
void IzhodKodoveCenaPartida(TPartida *m, short len, double cenaP) {
  cout << "������ �� ������� � ���� " << cenaP << ":\n";
  for (short i = 0; i < len; ++i)
    if (CenaPartida(m[i]) == cenaP) cout << m[i].kod << endl;
}
int main(){
  system("chcp 1251");
  short broyPartidi;
  do {
    cout << "���� �� ��������� (>0): ";
    cin >> broyPartidi;
  } while (broyPartidi <= 0);
  TPartida *partidi = new TPartida[broyPartidi];
  VhodMasiv(partidi, broyPartidi);
  cout << "-------------\n";
  IzhodMasiv(partidi, broyPartidi);
  cout << "-------------\n";
  short broyMin1kg;
  cout << "��������� ���� �� 1 ��������: "
       << MinCena1kg(partidi, broyPartidi, broyMin1kg) << endl;
  cout << "���� �� ��������� � ��������� ���� �� 1 ��: " << broyMin1kg << endl;
  IzhodKodoveCenaPartida(partidi, broyPartidi, MaxCenaPartida(partidi, broyPartidi));


  delete[] partidi;
  //partidi = NULL;

  cout << "\n\n\n";
  system("pause");
  return 0;
}
