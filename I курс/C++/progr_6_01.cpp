/* Файл: progr_6_01.cpp
   Упражнения по Програмиране (C++)
   Примерно решение на задача 6.1
   Подготвил: Кирил Иванов
   Февруари 2017 година
*/

#include <iostream>
using namespace std;
#include <cstring>
int main( ) {
  //char s[] = "abcd";
  const short maxStrLen = 40;
  char s1[maxStrLen + 1], s2[maxStrLen + 1], s3[maxStrLen + 1], * min;

  cout << "String 1 (length<=" << maxStrLen << "): ";
  // не е достатъчно cin >> s1, защото няма да се четат интервали
  // cin.getline( s1, maxStrLen + 1, '\n' );
  cin.getline( s1, maxStrLen + 1 );
  cout << "String 2 (length<=" << maxStrLen << "): ";
  cin.getline( s2, maxStrLen + 1 );
  cout << "String 3 (length<=" << maxStrLen << "): ";
  cin.getline( s3, maxStrLen + 1 );

  cout << "String 1: \"" << s1 << "\"\n";
  cout << "String 2: \"" << s2 << "\"\n";
  cout << "String 3: \"" << s3 << "\"\n";
  
  if ( -1 == strcmp( s1, s2 ) ) min = s1;
  else min = s2;
  if ( 1 == strcmp( min, s3 ) ) min = s3;
  cout << "minimum : \"" << min << "\"\n\n\n";

  system( "pause" );
  return 0;
}
