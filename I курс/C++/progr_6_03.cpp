/* Файл: progr_6_03.cpp
   Упражнения по Програмиране (C++)
   Примерно решение на задача 6.3
   Подготвил: Кирил Иванов
   Февруари 2017 година
*/

#include <iostream>
using namespace std;
#include <cstring>
int main( ) {
  const short maxStrLen = 30;
  char str[maxStrLen + 1], ch1, ch2;
  cout << "String (length<=" << maxStrLen << "): ";
  cin.getline( str, maxStrLen + 1, '#' );
  cout << "First character: ";
  cin >> ch1;
  cout << "Second character: ";
  cin >> ch2;
  cout << "String: \"" << str << "\"\n";
  cout << "First character: \'" << ch1 << "\'\n";
  cout << "Second character: \'" << ch2 << "\'\n";
  /*
  // 1-и начин (обхождане на низа чрез индекси)
  for ( short i = 0; str[i] != 0; ++i )
    if ( str[i] == ch1 ) str[i] = ch2;
  cout << "Result: \"" << str << "\"\n";
  */
  /*
  // 2-и начин (обхождане на низа чрез указател)
  for ( char *s = str; *s != 0; ++s )
    if ( *s == ch1 ) *s = ch2;
  cout << "Result: \"" << str << "\"\n";
  */
  
  // 3-и начин (с търсен на първо срещане на знак в низ)
  char * adrCh = strchr( str, ch1 );
  while ( adrCh ) {
    *adrCh = ch2;
    adrCh = strchr( adrCh + 1, ch1 );
  }
  cout << "Result: \"" << str << "\"\n";
  
  /*
  // 4-и начин (също като третия начин, но записан с for)
  for ( char * adrCh = strchr( str, ch1 );
        adrCh;
        adrCh = strchr( adrCh + 1, ch1 )
      ) *adrCh = ch2;
  cout << "Result: \"" << str << "\"\n";
  */

  cout << "\n\n";
  system( "pause" );
  return 0;
}
