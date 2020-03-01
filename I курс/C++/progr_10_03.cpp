/* Файл: progr_10_03.cpp
   Упражнения по Програмиране (C++)
   Примерно решение на задача 10.3
   Подготвил: Кирил Иванов
   Март 2017 година
*/

#include <iostream>
using namespace std;
#include <cstring>
const short broyOtbori = 6, daljinaIme = 40;
struct TOtbor {
  char vodach[daljinaIme + 1], navigator[daljinaIme + 1];
  short minuti, sekundi;
};
bool PravilnoIme( const char * s ) {
  const char * sp = strchr( s, ' ' );
  return sp && ! strchr( sp + 1, ' ' ) // има точно един интервал
         && s[0] != ' ' && s[ strlen(s) - 1 ] != ' '; // преди и след интервала има други знакове
}
void VhodOtbor( TOtbor & otbor ) {
  do {
    cout << "    време за маршрута (минути секунди): ";
    cin >> otbor.minuti >> otbor.sekundi;
  } while ( otbor.minuti <= 0 || otbor.sekundi <= 0 );
  cin.ignore( 1 );
  do {
    cout << "    име и фамилия на водача (до " << daljinaIme << "): ";
    cin.getline( otbor.vodach, daljinaIme + 1 );
  } while ( ! PravilnoIme( otbor.vodach ) );
  do {
    cout << "    име и фамилия на навигатора (до " << daljinaIme << "): ";
    cin.getline( otbor.navigator, daljinaIme + 1 );
  } while ( ! PravilnoIme( otbor.navigator ) );
}
void VhodMasiv( TOtbor masiv[], short broy ) {
  cout << "Въведете данни за " << broy << " отбора:\n";
  for ( short i = 0; i < broy; ++i ) {
    cout << "  Отбор " << i + 1 << ":\n";
    VhodOtbor( masiv[i] );
  }
}
void IzhodOtbor( const TOtbor & otbor ) {
  cout << "  Отбор с водач " << otbor.vodach << endl
       << "        и навигатор " << otbor.navigator << endl
       << "        (време: " << otbor.minuti << " мин. и " << otbor.sekundi << " с.).\n";
}
void IzhodPoFamilii( TOtbor masiv[], short broy ) {
  cout << "Справка за отбори с еднакви фамилии на водач и навигатор:\n";
  for ( short i = 0; i < broy; ++i )
  if (  0 == strcmp( strchr(masiv[i].vodach,' '), strchr(masiv[i].navigator,' ') )  )
       IzhodOtbor( masiv[i] );
  cout << "Край на справката.\n";
}
int main( ) {
  system( "chcp 1251" );
  TOtbor otbori[broyOtbori];
  VhodMasiv( otbori, broyOtbori );
  IzhodPoFamilii( otbori, broyOtbori );

  cout << "\n\n";
  system( "pause" );
  return 0;
}
