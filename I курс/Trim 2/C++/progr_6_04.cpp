/* Файл: progr_6_04.cpp
   Упражнения по Програмиране (C++)
   Примерно решение на задача 6.4
   Подготвил: Кирил Иванов
   Февруари 2017 година
*/

#include <iostream>
using namespace std;
#include <cstring>
int main( ) {
  const short maxStrLen = 20;
  char s1[maxStrLen + 1], s2[maxStrLen + 1];
  cout << "String 1 (length<=" << maxStrLen << "): ";
  cin.getline( s1, maxStrLen + 1 );
  cout << "String 2 (length<=" << maxStrLen << "): ";
  cin.getline( s2, maxStrLen + 1 );
  cout << "s1 == \"" << s1 << "\"\n";
  cout << "s2 == \"" << s2 << "\"\n";

  short count = 0;
  char *next = strstr( s1, s2 );
  while ( next ) {
    ++count;
    next = strstr( next+1, s2 );
  }
  cout << "Count: " << count << endl;

  system( "pause" );
  return 0;
}
