/* Файл: progr_6_05.cpp
   Упражнения по Програмиране (C++)
   Примерно решение на задача 6.5
   Подготвил: Кирил Иванов
   Февруари 2017 година
*/

#include <iostream>
using namespace std;
#include <cstring>
int main( ) {
  const short maxStrLen = 15;
  char s1[maxStrLen + 1], s2[maxStrLen + 1], s3[maxStrLen + 1],
       res[maxStrLen*maxStrLen + 1];
  cout << "String 1 (length<=" << maxStrLen << "): ";
  cin.getline( s1, maxStrLen + 1 );
  cout << "String 2 (length<=" << maxStrLen << "): ";
  cin.getline( s2, maxStrLen + 1 );
  cout << "String 3 (length<=" << maxStrLen << "): ";
  cin.getline( s3, maxStrLen + 1 );
  cout << "String 1: \"" << s1 << "\"\n";
  cout << "String 2: \"" << s2 << "\"\n";
  cout << "String 3: \"" << s3 << "\"\n";

  char *start = s1, *nexts2 = strstr( s1, s2 ), *to = res;
  while ( nexts2 ) {
    strncpy_s( to, nexts2 - start + 1, start, nexts2 - start );
    to += nexts2 - start;
    strcpy_s( to, strlen( s3 ) + 1, s3 );
    to += strlen( s3 );
    start = nexts2 + strlen( s2 );
    nexts2 = strstr( start, s2 );
  }
  strcpy_s( to, strlen( start ) + 1, start );
  cout << "Result:   \"" << res << "\"\n\n\n";

  system( "pause" );
  return 0;
}
