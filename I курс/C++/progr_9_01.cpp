/* Файл: progr_9_01.cpp
   Упражнения по Програмиране (C++)
   Примерно решение на задача 9.1
   Подготвил: Кирил Иванов
   Март 2017 година
*/

#include <iostream>
using namespace std;
#include <cstring>
const short imeSabirachD = 50,
            vidGabaD = 18;
const char vidoveGabi[][vidGabaD + 1] =
                     { "кладница", //0
                       "печурка", //1
                       "сърнела", //2
                       "кадифена манатарка", //3
                       "челадинка", //4
                       "булка", //5
                       "бисерна гъба", //6
                       "гигантска пърхутка", //7
                       "бял трюфел", //8
                       "друг" //9
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
    cout << "   дата месец година на събирането на гъбите: ";
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
  cout << "   вид гъба: ";
  cin.getline(vid, vidGabaD + 1);
  short i = 0;
  while (i<broyVidove-1)
    if ( strcmp(vid, vidoveGabi[i]) ) ++i;
    else break;
  p.kod[6] = i + '0';
  do {
    cout << "   източник на гъбите (П-поле; Б-балкан; Д-домашни): ";
    cin >> p.kod[7];
    cin.ignore(1);
  } while (p.kod[7] != 'П' && p.kod[7] != 'Б' && p.kod[7] != 'Д' );
  bool pravilnoIme;
  do {
    cout << "   име фамилия (на събирача): ";
    cin.getline(p.ime, imeSabirachD + 1);
        pravilnoIme = 'А' <= p.ime[0] && p.ime[0] <= 'Я';
        if (pravilnoIme) {
          i = 1;
          while ('а' <= p.ime[i] && p.ime[i] <= 'я') ++i;
          pravilnoIme = p.ime[i] == ' ' &&
                        'А' <= p.ime[i+1] && p.ime[i+1] <= 'Я';
        }
        if (pravilnoIme) {
          i += 2;
          while ('а' <= p.ime[i] && p.ime[i] <= 'я') ++i;
          pravilnoIme = p.ime[i] == 0;
        }
  } while ( ! pravilnoIme );
  p.kod[8] = p.ime[0];
  p.kod[9] = *(1 + strchr(p.ime, ' '));
  p.kod[10] = 0;
  do {
    cout << "   количество: ";
    cin >> p.kolichestvo;
  } while (p.kolichestvo <= 0.0);
  do {
    cout << "   цена на 1 кг: ";
    cin >> p.cena1kg;
  } while (p.cena1kg <= 0.0);
}
void VhodMasiv(TPartida * mas, short len) {
  for (short i = len - 1; 0 <= i; --i) {
    cout << "Въведете данни за " << i + 1 << "-ата партида:\n";
    VhodPartida(mas[i]);
  }
}
void IzhodPartida(const TPartida & p) {
  cout << "     код: " << p.kod << endl;
  cout << "          дата на събиране: " << p.kod[0] << p.kod[1] << '.'
       << p.kod[2] << p.kod[3] << ".20" << p.kod[4] << p.kod[5] << endl;
  cout << "          вид на гъбите: " << vidoveGabi[p.kod[6] - '0'] << endl;
  cout << "          източник: ";
  switch (p.kod[7]) {
    case 'П': cout << "поле\n"; break;
    case 'Б': cout << "балкан\n"; break;
    default: cout << "домашни\n";
  }
  cout << "          инициали на събирача: " << p.kod[8] << p.kod[9] << endl;
  cout << "     име на събирача: " << p.ime << endl;
  cout << "     количество: " << p.kolichestvo << endl;
  cout << "     цена на 1 кг: " << p.cena1kg << endl;
  cout << "     цена на цялата партида: " << CenaPartida(p) << endl;
}
void IzhodMasiv(TPartida *m, short len) {
  cout << "  ***  Данни за всички партиди  ***\n";
  for (short i = 0; i < len; ++i) {
    cout << i + 1 << "-а партида:\n";
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
  cout << "Кодове на партиди с цена " << cenaP << ":\n";
  for (short i = 0; i < len; ++i)
    if (CenaPartida(m[i]) == cenaP) cout << m[i].kod << endl;
}
int main(){
  system("chcp 1251");
  short broyPartidi;
  do {
    cout << "Брой на партидите (>0): ";
    cin >> broyPartidi;
  } while (broyPartidi <= 0);
  TPartida *partidi = new TPartida[broyPartidi];
  VhodMasiv(partidi, broyPartidi);
  cout << "-------------\n";
  IzhodMasiv(partidi, broyPartidi);
  cout << "-------------\n";
  short broyMin1kg;
  cout << "Минимална цена на 1 килограм: "
       << MinCena1kg(partidi, broyPartidi, broyMin1kg) << endl;
  cout << "Брой на партидите с минимална цена на 1 кг: " << broyMin1kg << endl;
  IzhodKodoveCenaPartida(partidi, broyPartidi, MaxCenaPartida(partidi, broyPartidi));


  delete[] partidi;
  //partidi = NULL;

  cout << "\n\n\n";
  system("pause");
  return 0;
}
