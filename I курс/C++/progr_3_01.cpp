/* Файл: progr_3_01.cpp
   Упражнения по Програмиране (C++)
   Примерно решение на задача 3.1
   Подготвил: Кирил Иванов
   Януари 2017 година
*/

#include <iostream>
using namespace std;
double Sum( double v, double *p, double &r ) {
  return v + *p + r;
}
int main( ) {
  double x, y, z;
  cout << "Real numbers x y z: ";
  cin >> x >> y >> z;
  cout << "Sum: " << Sum( x, &y, z ) << endl;

  system( "pause" );
  return 0;
}