                    /* Файл: progr_01_11.cpp
                     * Тема 1. Стандартни прости типове
                     * Примерно решение на Задача 1.11
                     * от файл: Основи C++ Задачи Тема 01.pdf
                     * Октомври 2016 г. Кирил Иванов
                     */
#include <iostream>
using namespace std;
int main() {
  double r;
  cout << "Real number: ";
  cin >> r;
  cout << "Fractional part of the number: " << r - (int)(r) << endl;

  system("pause");
  return 0;
}
