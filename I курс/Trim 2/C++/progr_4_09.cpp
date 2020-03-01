/* Файл: progr_4_09.cpp
   Упражнения по Програмиране (C++)
   Примерно решение на задача 4.9
   Подготвил: Кирил Иванов
   Януари 2017 година
*/

#include <iostream>
using namespace std;

long long f(short k);
long long h(short k) {
  if (k < 15) return 8 - 2 * k;
  switch (k % 7) {
    case 5: return 2 * h(k - 2) - k * k;
    case 6: return h(k - 5) - k;
    case 0: return f(k - 7) - k;
    case 1:
    case 3: return 2 * h(k + 4) - k * (k - 2);
    default: return 2 * h(k + 2) - k * k + 5;
  }
}
long long f(short k) {
  if (k < 10) return k + 20;
  switch (k % 5) {
    case 1: return f(k + 3) - 3;
    case 3: return f(k + 2) + k - 6;
    case 0: return 2 * h(k - 8) - k * (k - 7);
    default: return 2 * f(k + 1) + k * k - 4;
  }
}
int main() {
  short n;
  do {
    cout << "Integer n (1<=n<=130): ";
    cin >> n;
  } while (n < 1 || 130 < n);
  cout << endl;
  cout << "f(" << n << ") = " << f(n) << "\n\n";
  cout << "h(" << n << ") = " << h(n) << "\n\n";

  system("pause");
  return 0;
}
