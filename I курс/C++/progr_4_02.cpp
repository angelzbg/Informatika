/* Файл: progr_4_02.cpp
   Упражнения по Програмиране (C++)
   Примерно решение на задача 4.2
   Подготвил: Кирил Иванов
   Януари 2017 година
*/

#include <iostream>
using namespace std;
long long f( short k );
long long h( short k ) {
  if ( k % 2 == 0 ) return f( k - 1 ) - 3;
  if ( k < 100 ) return f( k - 6 ) + k*k - 2;
  return f( k - 5 ) - h( k - 8 ) + 5;
}
long long f( short k ) {
  if ( k < 10 ) return 2 * k - 1;
  if ( k < 50 ) return k + f( k - 1 );
  return h( k - 2 ) - f( k - 3 ) - k*k;
}
int main( ) {
  short n;
  do {
    cout << "Integer n (1<=n<=125): ";
    cin >> n;
  } while ( n < 1 || 125 < n );
  cout << "f(" << n << ") = " << f( n ) << endl;
  cout << "h(" << n << ") = " << h( n ) << "\n\n\n";

  system( "pause" );
  return 0;
}
