/* Файл: progr_4_05.cpp
   Упражнения по Програмиране (C++)
   Примерно решение на задача 4.5
   Подготвил: Кирил Иванов
   Януари 2017 година
*/

#include <iostream>
using namespace std;
long long g( short k ) {
  if ( k < 9 ) return 5 * k - 2;
  switch ( k % 7 ) {
    case 0: return 3 * (g( k - 7 ) - k);
    case 6: return g( k + 8 ) + 17;
    case 3: return 2 * (g( k + 5 ) - 15 * k);
    default: return 2 * g( k + 3 ) + 25;
  }
}
int main( ) {
  short n;
  do {
    cout << "Integer n (1<=n<=240): ";
    cin >> n;
  } while ( n < 1 || 240 < n );
  cout << "g(" << n << ") = " << g( n ) << "\n\n";

  system( "pause" );
  return 0;
}
