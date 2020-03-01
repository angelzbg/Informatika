/* Файл: progr_3_03.cpp
   Упражнения по Програмиране (C++)
   Примерно решение на задача 3.3
   Подготвил: Кирил Иванов
   Януари 2017 година
*/

#include <iostream>
using namespace std;
#include <cmath>
double Root(double x, long n = 2);
int main() {
  double x;
  do {
    cout << "Unsigned real number: ";
    cin >> x;
  } while (x < 0.0);
  long n;
  cout << "Integer: ";
  cin >> n;
  // double Root( double x, long n = 2 ); // необходимо, когато няма външната декларация
  cout << "Root(" << x << ") = " << Root(x) << endl;
  cout << "Root(" << x << ',' << n << ") = " << Root(x, n) << endl;

  system("pause");
  return 0;
}
double Root(double x, long n) {
  return pow(x, 1.0 / n);
}
