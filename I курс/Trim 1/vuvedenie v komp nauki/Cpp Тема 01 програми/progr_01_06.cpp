                    /* Файл: progr_01_06.cpp
                     * Тема 1. Стандартни прости типове
                     * Примерно решение на Задача 1.6
                     * от файл: Основи C++ Задачи Тема 01.pdf
                     * Октомври 2016 г. Кирил Иванов
                     */
#include <iostream>
using namespace std;
#include <cmath>
int main() {
  int N;
  cout << "Integer: ";
  cin >> N;
  int d0 = abs(N) % 10,
      d1 = abs(N) / 10 % 10,
      d2 = abs(N) / 100 % 10,
      d0d2 = d0 * 10 + d2,
      d1d2 = d1 * 10 + d2;
  cout << d0d2 << " + " << d1d2 << " = " << d0d2 + d1d2 << endl;

  system("pause");
  return 0;
}
