/* Файл: progr_4_04.cpp
   Упражнения по Програмиране (C++)
   Примерно решение на задача 4.4
   Подготвил: Кирил Иванов
   Януари 2017 година
*/

#include <iostream>
using namespace std;
void F(unsigned long long pred, unsigned long long last, int num_last, int n) {
  cout << "F(" << num_last << ") = " << last << endl;
  if (num_last < n)
    F(last, pred + last, num_last + 1, n);
}
void Fdown(unsigned long long & pred, unsigned long long & last, int n) {
  if (n == 1) { pred = 1; last = 0; }
  else {
    unsigned long long old_pred;
    Fdown(old_pred, pred, n - 1);
    last = pred + old_pred;
  }
  cout << "F(" << n << ") = " << last << endl;
}
int main() {
  int n;
  do {
    cout << "Integer n (1<=n<=94): ";
    cin >> n;
  } while (n < 1 || 94 < n);
  // 1-и начин - с цикъл
  unsigned long long pred = 1, last = 0;
  int num_last = 1;
  while (num_last <= n) {
    cout << "F(" << num_last << ") = " << last << endl;
    unsigned long long old_pred = pred;
    pred = last;
    last = old_pred + last;
    ++num_last;
  }
  cout << "-------------\n";
  // 2-и начин - с рекурсия по нарастване на номерата
  F(1, 0, 1, n);
  cout << "-------------\n";
  // 3-и начин - с рекурсия по намаляване на номерата
  Fdown(pred, last, n);
  cout << "-------------\n";

  system("pause");
  return 0;
}
