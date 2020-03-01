/* Файл: progr_3_06.cpp
   Упражнения по Програмиране (C++)
   Примерно решение на задача 3.6
   Подготвил: Кирил Иванов
   Януари 2017 година
*/

#include <iostream>
using namespace std;
#include <cmath>
double S( double a, double b, double c ) {
  double p = (a + b + c) / 2.0;
  return sqrt( p*(p - a)*(p - b)*(p - c) );
}
void ReadSides( double & a, double & b, double & c ) {
  // формалните параметри са псевдоними,
  //   за да може чрез тях да се променят фактическите параметри;
  // съответните фактически и формален параметри
  //   са различни имена на една и съща данна
  do {
    cout << "Triangle sides: ";
    cin >> a >> b >> c;
  } while ( a + b <= c || a + c <= b || b + c <= a );
}
int main( ) {
  double a, b, c;
  ReadSides( a, b, c );
  cout << "S = " << S( a, b, c ) << endl;

  system( "pause" );
  return 0;
}