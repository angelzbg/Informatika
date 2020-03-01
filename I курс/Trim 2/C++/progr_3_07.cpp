/* Файл: progr_3_07.cpp
   Упражнения по Програмиране (C++)
   Примерно решение на задача 3.7
   Подготвил: Кирил Иванов
   Януари 2017 година
*/

#include <iostream>
using namespace std;
void Write( double v1, double v2, double v3 ) {
  cout << "v1 = " << v1 << "; v2 = " << v2
       << "; v3 = " << v3 << ".\n";
}
void OrderUp( double & r1, double & r2, double & r3 ) {
  double t;
  if ( r1 > r2 ) { t = r1; r1 = r2; r2 = t; }
  if ( r1 > r3 ) { t = r1; r1 = r3; r3 = t; }
  if ( r2 > r3 ) { t = r2; r2 = r3; r3 = t; }
}
int main( ) {
  double x, y, z;
  cout << "x y z: ";
  cin >> x >> y >> z;
  Write( x, y, z );
  OrderUp( x, y, z );
  Write( x, y, z );

  system( "pause" );
  return 0;
}