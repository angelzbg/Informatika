/* Файл: progr_4_07.cpp
   Упражнения по Програмиране (C++)
   Примерно решение на задача 4.7
   Подготвил: Кирил Иванов
   Януари 2017 година
*/

#include <iostream>
using namespace std;
#include <cmath>
long long w(short k) {
  if (k < 20) return 3 * (k + 3);
  switch (k % 8) {
  case 0: return 3 * w(k - 8) + 2 * k*k;
  case 3: return 2 * w(k + 11) + 17;
  case 4: return w(k + 9) + k*k - 4;
  default: return w(k + 10) - 2 * k;
  }
}
int main(){
  char d;
  do {
    cout << "Decimal digit: ";
    cin >> d;
  } while (d < '0' || '9' < d);
  long long val = d - '0';
  cout << "Result -------\n";
  for (short n = 1; n <= 50; ++n)
  {
    long long elm = w(n);
    if (abs(elm % 10) == val)
      cout << "w(" << n << ") = " << elm << endl;
  }
  cout << "--------------\n";

  system("pause");
  return 0;
}
