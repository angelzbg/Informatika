/* Файл: progr_10_07.cpp
   Упражнения по Програмиране (C++)
   Примерно решение на задача 10.7
   Подготвил: Кирил Иванов
   Март 2017 година
*/

#include <iostream>
using namespace std;
const short broyZnakove = 9, daljinaNiz = 60, daljinaShTekst = 20;
struct TZnak {
  char znak, niz[daljinaNiz + 1];
};
bool PravilenNiz( const char * s ) {
  for ( ; *s != 0; ++s )
    if ( (*s < '0' || '9' < *s) && (*s < 'а' || 'я' < *s) ) // не е нито буква, нито цифра
      return false;
  return true;
}
void VhodZnak( TZnak & z ) {
  do {
    cout << "    знак (с код от 33 до 126) и съответен низ (без интервали): ";
    cin >> z.znak >> z.niz;
    cin.ignore(1);
  } while ( z.znak < 33 || 126 < z.znak || ! PravilenNiz(z.niz) );
}
void VhodMasiv( TZnak masiv[], short broy ) {
  cout << "Въведете данни за " << broy << " шифриращи знака:\n";
  for ( short i = 0; i < broy; ++i ) {
    cout << "  " << i + 1 << "-и знак:\n";
    VhodZnak( masiv[i] );
  }
}
void IzhodNiz( const TZnak masiv[], short broy, char shz ) {
  short i = 0;
  while ( i < broy && masiv[i].znak != shz )
    ++i;
  if ( i < broy ) cout << masiv[i].niz << ' ';
  else cout << shz << ' ';
}
void IzhodTekst( TZnak masiv[], short broy, char * tekst ) {
  cout << "Дешифриран текст:\n";
  for ( ; *tekst != 0; ++tekst ) IzhodNiz( masiv, broy, *tekst );
  cout << "\nКрай на текста.\n";
}
int main( ) {
  system( "chcp 1251 >> nul" ); // " >> nul" изисква да не се извежда съобщението на екрана
  TZnak rechnik[broyZnakove];
  VhodMasiv( rechnik, broyZnakove );
  cout << "Въведете шифриран низ до " << daljinaShTekst <<" знака: ";
  char shTekst[daljinaShTekst + 1];
  cin.getline( shTekst, daljinaShTekst + 1 );
  IzhodTekst( rechnik, broyZnakove, shTekst );

  cout << "\n\n";
  system( "pause" );
  return 0;
}

