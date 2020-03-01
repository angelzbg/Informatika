/* Файл: progr_4_01.cpp
   Упражнения по Програмиране (C++)
   Примерно решение на задача 4.1
   Подготвил: Кирил Иванов
   Януари 2017 година
*/

#include <iostream>
using namespace std;
#include <cmath>
double f( double x ) {
  if ( fabs( x ) < 20.0 ) return x*x;
  if ( -30.0 < x && x <= -20.0 ) return f( x + 10.0 ) + 1.5;
  return f( x / 2.0 ) - f( x / 3.0 ) + 6.1;
}
int main( ) {
  double x;
  do {
    cout << "Real number x (|x|<10^10): ";
    cin >> x;
  } while ( 1e20 <= fabs( x ) );
  cout << "f(" << x << "): " << f( x ) << endl;

  system( "pause" );
  return 0;
}
