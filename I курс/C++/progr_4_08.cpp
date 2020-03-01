/* Файл: progr_4_08.cpp
   Упражнения по Програмиране (C++)
   Примерно решение на задача 4.8
   Подготвил: Кирил Иванов
   Януари 2017 година
*/

#include <iostream>
using namespace std;
#include <iomanip>
#include <cmath>
long long h(short k) {
  if (k < 17) return 2 * k - 140;
  switch (k % 7) {
  case 0: return h(k + 4) - 75;
  case 1: return h(k + 3) - 3 * (k - 10);
  case 4: return 2 * h(k - 11) + k * (k + 3);
  default: return 3 * h(k + 4) + k * k * k;
  }
}
int main() {
  cout << "1 ----------\n";
  for (short i = 0; i < 100; ++i) cout << setw(10) << h(i);
  cout << endl;
  cout << "2 ----------\n";
  short counts[10] = { 0 };
  for (short i = 0; i < 100; ++i) ++counts[abs(h(i)) % 10];
  //for ( short i=0; i<10; ++i ) cout<<"counts["<<i<<"]="<<counts[i]<<endl;
  short maxD = 0;
  for (short d = 1; d < 10; ++d) if (counts[maxD] < counts[d]) maxD = d;
  cout << "Digit: " << maxD << endl;
  cout << "Count: " << counts[maxD] << endl;
  cout << "3 ----------\n";
  cout << "Elements:\n";
  for (short i = 0; i < 100; ++i)
    if (abs(h(i)) % 10 == maxD)
      cout << "h(" << i << ") = " << h(i) << endl;

  system("pause");
  return 0;
}
