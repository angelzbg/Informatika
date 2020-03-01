/* Файл: progr_3_02.cpp
   Упражнения по Програмиране (C++)
   Примерно решение на задача 3.2
   Подготвил: Кирил Иванов
   Януари 2017 година
*/

#include <iostream>
using namespace std;
void Swap1( double & par1, double & par2 ) {
  // формалните параметри псевдоними дават достъп до фактическите параметри
  double temp = par1;
  par1 = par2;
  par2 = temp;
}
void Swap2( double * par1, double * par2 ) {
  // формалните параметри указатели дават достъп до фактическите параметри
  double temp = *par1;
  *par1 = *par2;
  *par2 = temp;
}
int main( ) {
  double x, y;
  cout << "x y: ";
  cin >> x >> y;
  cout << "x = " << x << endl;
  cout << "y = " << y << "\n\n";

  Swap1( x, y ); // изпълнението на функцията може да променя x и y
  cout << "x = " << x << endl;
  cout << "y = " << y << "\n\n";

  Swap2( &y, &x ); // изпълнението на функцията може да променя x и y
  cout << "x = " << x << endl;
  cout << "y = " << y << "\n\n";

  system( "pause" );
  return 0;
}