/* Файл: progr_4_06.cpp
   Упражнения по Програмиране (C++)
   Примерно решение на задача 4.6
   Подготвил: Кирил Иванов
   Януари 2017 година
*/

#include <iostream>
using namespace std;
long long u(short k) {
  if (k < 15) return 4 * (k - 3);
  switch (k % 8) {
    case 0: return 5 * (u(k - 8) - k*k*k*k);
    case 3: return 2 * u(k + 21) - 45;
    case 5: return u(k + 9) - 4 * k;
    default: return u(k + 1011) + k*k + 70;
  }
}
int main(){
  short n;
  do {
    cout << "Integer n (1<=n<=125): ";
    cin >> n;
  } while (n < 1 || 125 < n);
  cout << "u(" << n << ") = " << u(n) << "\n\n\n";

  system("pause");
  return 0;
}
