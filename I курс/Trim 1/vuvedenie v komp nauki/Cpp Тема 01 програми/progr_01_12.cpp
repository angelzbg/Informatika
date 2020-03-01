                    /* Файл: progr_01_12.cpp
                     * Тема 1. Стандартни прости типове
                     * Примерно решение на Задача 1.12
                     * от файл: Основи C++ Задачи Тема 01.pdf
                     * Октомври 2016 г. Кирил Иванов
                     */
#include <iostream>
using namespace std;
#include <cmath>
int main() {
  double r;
  cout << "Real number: ";
  cin >> r;
  cout << "Digit of hundredths: " << (int)(fabs(r) * 100.0) % 10 << endl;

  system("pause");
  return 0;
}
