/* Файл: progr_10_06.cpp
   Упражнения по Програмиране (C++)
   Примерно решение на задача 10.6
   Подготвил: Кирил Иванов
   Март 2017 година
*/

#include <iostream>
using namespace std;
#include <cstring>
const short broyStoki = 8, daljinaOpis = 60;
struct TStoka {
  char USN[9], opis[daljinaOpis + 1];
  short broy;
};
bool PravilenUSN( const char * s ) {
  if ( strlen( s ) != 8 ) return false;
  for ( short i = 0; i < 4; ++i )
    if ( s[i] < '0' || '9' < s[i] )
      return false;
  for ( short i = 5; i < 8; ++i )
    if ( (s[i] < 'a' || 'z' < s[i]) && (s[i] < 'A' || 'Z' < s[i]) )
      return false;
  return ' ' == s[4];
}
void VhodStoka( TStoka & st ) {
  do {
    cout << "    брой на екземплярите: ";
    cin >> st.broy;
  } while ( st.broy <= 0 );
  cin.ignore( 1 );
  do {
    cout << "    уникален складов номер: ";
    cin.getline( st.USN, 9 );
  } while ( ! PravilenUSN(st.USN) );
  do {
    cout << "    текстово описание (от 5 до " << daljinaOpis << " знака): ";
    cin.getline( st.opis, daljinaOpis + 1 );
  } while ( strlen(st.opis) < 5 );
}
void VhodMasiv( TStoka masiv[], short broy ) {
  cout << "Въведете данни за " << broy << " стоки:\n";
  for ( short i = 0; i < broy; ++i ) {
    cout << "  " << i + 1 << "-а стока:\n";
    VhodStoka( masiv[i] );
  }
}
void IzhodStoka( const TStoka & st ) {
  cout << "  Стока с УСН \"" << st.USN << "\" (" << st.opis
    << "; брой екземпляри: " << st.broy << ").\n";
}
void IzhodPoBukva( TStoka masiv[], short broy, char ch ) {
  cout << "Данни за стоки, чийто УСН съдържа \'" << ch << "\':\n";
  for ( short i = 0; i < broy; ++i )
    if ( strchr( masiv[i].USN, ch ) )
      IzhodStoka( masiv[i] );
  cout << "Край на данните.\n";
}
int main( ) {
  system( "chcp 1251 >> nul" ); // " >> nul" изисква да не се извежда съобщението на екрана
  TStoka stoki[broyStoki];
  VhodMasiv( stoki, broyStoki );
  cout << "Въведете буква от УСН: ";
  char letter;
  cin >> letter;
  IzhodPoBukva( stoki, broyStoki, letter );

  cout << "\n\n";
  system( "pause" );
  return 0;
}

