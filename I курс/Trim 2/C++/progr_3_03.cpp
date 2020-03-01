/* ����: progr_3_03.cpp
   ���������� �� ������������ (C++)
   �������� ������� �� ������ 3.3
   ���������: ����� ������
   ������ 2017 ������
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
  // double Root( double x, long n = 2 ); // ����������, ������ ���� �������� ����������
  cout << "Root(" << x << ") = " << Root(x) << endl;
  cout << "Root(" << x << ',' << n << ") = " << Root(x, n) << endl;

  system("pause");
  return 0;
}
double Root(double x, long n) {
  return pow(x, 1.0 / n);
}
