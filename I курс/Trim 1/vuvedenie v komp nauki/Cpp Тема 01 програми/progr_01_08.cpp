                    /* Файл: progr_01_08.cpp
                     * Тема 1. Стандартни прости типове
                     * Примерно решение на Задача 1.8
                     * от файл: Основи C++ Задачи Тема 01.pdf
                     * Октомври 2016 г. Кирил Иванов
                     */
#include <iostream>
using namespace std;
#include <cmath>
int main() {
  int n;
  cout << "Integer: ";
  cin >> n;
  int res = (int)floor(n);
  // или int res = floor(n);
  cout << "Result: " << res - (res % 2 != 0) << endl;
  cout << "Result: " << res - abs(res % 2) << endl;

  system("pause");
  return 0;
}
