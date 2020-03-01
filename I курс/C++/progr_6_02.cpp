/* Файл: progr_6_02.cpp
   Упражнения по Програмиране (C++)
   Примерно решение на задача 6.2
   Подготвил: Кирил Иванов
   Февруари 2017 година
*/

#include <iostream>
using namespace std;
#include <iomanip>
void Write( char * s ) {
  for ( short i = 0; s[i] != 0; ++i ) cout << setw( 3 ) << s[i];
  cout << endl;
  for ( short i = 0; s[i] != 0; ++i ) cout << setw( 3 ) << i;
  cout << endl;
}
int main( ) {
  const short maxStrLen = 25;
  char str[maxStrLen + 1];
  cout << "String (length<=" << maxStrLen << "): ";
  cin.getline( str, maxStrLen + 1 );
  Write( str );

  short counters[256] = { 0 };
  for ( short ich = 0; str[ich] != 0; ++ich )
    ++counters[ (unsigned char)str[ich] ];
  short max = counters[0];
  for ( short icounter = 1; icounter < 256; ++icounter )
    if ( max < counters[icounter] ) max = counters[icounter];
  for ( short i = 0; i < 256; ++i )
    if ( max == counters[i] ) {
      cout << '\'' << (char)i << "\': ";
      for ( short pos = 0; str[pos] != 0; ++pos )
        if ( str[pos] == i ) cout << pos << ", ";
      cout << endl;
    }
  cout << "\n\n";

  system( "pause" );
  return 0;
}
