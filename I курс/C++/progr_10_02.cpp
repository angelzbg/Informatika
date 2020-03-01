/* Файл: progr_10_02.cpp
   Упражнения по Програмиране (C++)
   Примерно решение на задача 10.2
   Подготвил: Кирил Иванов
   Март 2017 година
*/

#include <iostream>
using namespace std;
#include <cstring>
const short broyEksponati = 6, daljinaFirma = 70, daljinaEksponat = 50;
struct TEksponat {
  char nFirma[daljinaFirma + 1], nEksponat[daljinaEksponat + 1];
  double cena;
};
bool PravilnoNazvanieEksponat( const char * n ) {
  bool cifra1 = true; // == true, докато още предстои намирането на 1-а цифра
  for ( ; *n != 0; ++n )
    if ( '0' <= *n && *n <='9' ) // ако *n е цифра:
      if ( cifra1 ) cifra1 = false; // намерена е първа цифра
      else return true; // намерена е втора цифра
  return false;
}
void VhodEksponat( TEksponat & eks ) {
  do {
    cout << "    цена: ";
    cin >> eks.cena;
  } while ( eks.cena <= 0.0 );
  cin.ignore( 1 );
  cout << "    название на фирма: ";
  cin.getline( eks.nFirma, daljinaFirma + 1 );
  do {
    cout << "    название на експонат: ";
    cin.getline( eks.nEksponat, daljinaEksponat + 1 );
  } while ( ! PravilnoNazvanieEksponat( eks.nEksponat ) );
}
void VhodMasiv( TEksponat masiv[], short broy ) {
  cout << "Въведете данни за " << broy << " експоната:\n";
  for ( short i = 0; i < broy; ++i ) {
    cout << "  Експонат " << i + 1 << ":\n";
    VhodEksponat( masiv[i] );
  }
}
void IzhodEksponat( const TEksponat & eks ) {
  cout <<   " Експонат " << eks.nEksponat << " с цена " << eks.cena
       << "\n    от фирма " << eks.nFirma << endl;
}
void IzhodPoCifra( TEksponat masiv[], short broy, char cifra ) {
  cout << "Експонати с цифра " << cifra << " в названието:\n";
  for ( short i = 0; i < broy; ++i )
    if ( strchr( masiv[i].nEksponat, cifra ) ) IzhodEksponat( masiv[i] );
}
int main( ) {
  system( "chcp 1251" );
  TEksponat eksponati[broyEksponati];
  VhodMasiv( eksponati, broyEksponati );
  char digit;
  cout << "Въведете цифра: ";
  cin >> digit;
  IzhodPoCifra( eksponati, broyEksponati, digit );

  cout << "\n\n";
  system( "pause" );
  return 0;
}
