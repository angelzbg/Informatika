/* ����: progr_10_10.cpp
   ���������� �� ������������ (C++)
   �������� ������� �� ������ 10.10
   ���������: ����� ������
   ���� 2017 ������
*/

#include <iostream> 
using namespace std;
#include <cstring>
const double distancia = 5.0;
const short broyUchstnici = 7, daljinaImena = 80;
struct TUchstnik {
  char imena[daljinaImena + 1];
  double vreme;
  int regNomer;
} uchastnici[broyUchstnici];
double SrednaSkorost( const TUchstnik & u ) { return distancia / u.vreme; }
bool GlavnaBukva( char ch ) { //����� true, ����� ������ ch � ������ ����� �� ��������
  return '�'<=ch && ch<='�';
}
bool PravilniImena( const char * s ) {
  if(    strlen(s) < 5 //���� ���������� �������
    || ! GlavnaBukva(s[0]) //�� ������� � ������ �����
    || ! GlavnaBukva(s[strlen(s)-1]) //�� �������� � ������ �����
    || ! (s = strchr(s,' ')) //���� ���� ���� �������� (� s �� ������� ������� ��)
    )
    return false;
  return       GlavnaBukva(*(s+1)) //���� 1-� �������� ��� ������ �����
            && (s = strchr(s+1,' ')) //��� ����� ��������
            && GlavnaBukva(*(s+1)) //���� 2-� �������� ��� ������ �����
            && ! strchr(s+1,' '); //���� 3-� ��������
}
void VhodUchastnik( TUchstnik & u ) {
  do {
    cout <<  "    ����� �� ���������: ";
    cin >> u.regNomer;
  } while ( u.regNomer < 0 );
  do {
    cout<<  "    ����� (������ ������ �������): ";
    double c,m,s;
    cin >> c >> m >> s;
    u.vreme = c + m/60.0 + s/3600.0;
  } while ( u.vreme <= 0.0 );
  cin.ignore(1);
  do {
    cout << "    ����� �� ���������: ";
    cin.getline(u.imena, daljinaImena + 1);
  } while( ! PravilniImena(u.imena) );
}
void VhodMasiv( TUchstnik masiv[], short broy ) {
  cout << "�������� ����� �� " << broy << " ���������:\n";
  for ( short i = 0; i < broy; ++i ) {
    cout << "  " << i + 1 << "-� ��������:\n";
    VhodUchastnik( masiv[i] );
  }
}
char * UkazatelImenaMaxSkorost( TUchstnik masiv[], short broy ) {
  double max = SrednaSkorost(masiv[0]);
  char * adr = masiv[0].imena;
  for( short i=1; i<broy; ++i )
    if( max < SrednaSkorost(masiv[i]) ) {
      max = SrednaSkorost(masiv[i]);
      adr = masiv[i].imena;
    }
    return adr;
}
int main( ) {
  system( "chcp 1251 >> nul" ); // " >> nul" ������� �� �� �� ������� ����������� �� ������
  VhodMasiv( uchastnici, broyUchstnici );
  cout << "����� �� �������� � ���-������ ������ �������:\n"
       << UkazatelImenaMaxSkorost(uchastnici,broyUchstnici);

  cout << "\n\n";
  system( "pause" );
  return 0;
}
