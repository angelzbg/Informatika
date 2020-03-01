                    /* Файл: progr_01_29.cpp
                     * Тема 1. Стандартни прости типове
                     * Примерно решение на Задача 1.29
                     * от файл: Основи C++ Задачи Тема 01.pdf
                     * Октомври 2016 г. Кирил Иванов
                     */
#include <iostream>
using namespace std;
#include <cmath>
int main() {
  short n;
  char k1, k2, k;
  cout << "Two integer (from -126 to 126): ";
  cin >> n;
  k1 = n;
  cin >> n;
  k2 = n;
  k = k1 | k2;
  cout << (k == k1 || k == k2 ? "true" : "false") << endl;

  system("pause");
  return 0;
}
