/* Файл: progr_10_01.cpp
   Упражнения по Програмиране (C++)
   Примерно решение на задача 10.1
   Подготвил: Кирил Иванов
   Март 2017 година
*/

#include <iostream>
using namespace std;
const short broySastezateli = 7, daljinaIme = 50;
struct TSastezatel {
  char ime[daljinaIme + 1];
  short vreme[4];
};
short SumarnoVreme( const TSastezatel & st ) {
  return st.vreme[0] + st.vreme[1] + st.vreme[2] + st.vreme[3];
}
bool NepravilnoIme( const char * u ) { // връща true, точно когато името е неправилно
  while ( *u!=0 )
    if ( *u != ' ' && (*u < 'а' || 'я' < *u) && (*u < 'А' || 'Я' < *u) )
      return true;
    else ++u;
  return false;
}
void VhodSastezatel(TSastezatel & st) {
  for ( short etap = 1; etap <= 4; ++etap )
    do {
      cout << "     време за " << etap << "-я етап (минути): ";
      cin >> st.vreme[etap - 1];
    } while ( st.vreme[etap - 1] <= 0 );
  cin.ignore( 1 );
  do {
    cout << "     име на състезатела: ";
    cin.getline( st.ime, daljinaIme + 1 );
  } while ( NepravilnoIme( st.ime ) );
}
void VhodMasiv( TSastezatel masiv[], short broy ) {
  cout << "Въведете данни за " << broy << " състезатели:\n";
  for ( short i = 0; i < broy; ++i ) {
    cout << "  Състезател " << i + 1 << ":\n";
    VhodSastezatel( masiv[i] );
  }
}
short MinSumarnoVreme( TSastezatel masiv[], short broy ) {
  short min = SumarnoVreme( masiv[0] );
  for ( short i = 1; i < broy; ++i )
    if ( SumarnoVreme( masiv[i] ) < min ) min = SumarnoVreme( masiv[i] );
  return min;
}
int main( ) {
  system( "chcp 1251" );
  TSastezatel sastezeteli[broySastezateli];
  VhodMasiv( sastezeteli, broySastezateli );
  cout << "\nМинимално сумарно време: " << MinSumarnoVreme( sastezeteli, broySastezateli );
  
  cout << "\n\n";
  system( "pause" );
  return 0;
}