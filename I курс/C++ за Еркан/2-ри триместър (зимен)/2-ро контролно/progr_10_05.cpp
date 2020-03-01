/* Файл: progr_10_05.cpp
   Упражнения по Програмиране (C++)
   Примерно решение на задача 10.5
   Подготвил: Кирил Иванов
   Март 2017 година
*/

#include <iostream>
using namespace std;
#include <cstring>
const short broyPtici = 8, daljinaIme = 45;
struct TPtica {
  char ime[daljinaIme + 1];
  double skorost, visochina;
};
bool PravilnoIme( const char * s ) {
  if ( 0 == s[0] || ' ' == s[0] || ' ' == s[strlen(s) - 1] ) return false;
  while ( *s!=0 )
    if ( ' ' != *s ) ++s;
    else if ( ' ' == *(s - 1) || ' ' == *(s + 1) ) return false;
         else ++s;
  return true;
}
void VhodPtica( TPtica & p ) {
  do {
    cout << "    максимална скорост на полет: ";
    cin >> p.skorost;
  } while ( p.skorost <= 0.0 || 300.0 <= p.skorost );
  do {
    cout << "    максимална височина на полет: ";
    cin >> p.visochina;
  } while ( p.visochina < 0.1 || 25.0 < p.visochina );
  cin.ignore( 1 );
  do {
    cout << "    название на птицата: ";
    cin.getline( p.ime, daljinaIme + 1 );
  } while ( ! PravilnoIme(p.ime) );
}
void VhodMasiv( TPtica masiv[], short broy ) {
  cout << "Въведете данни за " << broy << " птици:\n";
  for ( short i = 0; i < broy; ++i ) {
    cout << "  " << i + 1 << "-а птица:\n";
    VhodPtica( masiv[i] );
  }
}
void IzhodPtica( const TPtica & p ) {
  cout <<   "  Птица " << p.ime << " с максимална скорост на полета " << p.skorost
       << "\n        и максимална височина на полета " << p.visochina << ".\n";
}
void IzhodPoNiz( TPtica masiv[], short broy, const char * nachalo ) {
  cout << "Данни за птици, чието название започва с \"" << nachalo << "\":\n";
  for ( short i = 0; i < broy; ++i )
    if ( strstr( masiv[i].ime, nachalo ) == masiv[i].ime )
      IzhodPtica( masiv[i] );
  cout << "Край на данните.\n";
}
int main( ) {
  system( "chcp 1251" );
  TPtica ptici[broyPtici];
  VhodMasiv( ptici, broyPtici );
  cout << "Въведете начало на название на птица: ";
  char nch[daljinaIme + 1];
  cin.getline( nch, daljinaIme + 1 );
  IzhodPoNiz( ptici, broyPtici, nch );

  cout << "\n\n";
  system( "pause" );
  return 0;
}
