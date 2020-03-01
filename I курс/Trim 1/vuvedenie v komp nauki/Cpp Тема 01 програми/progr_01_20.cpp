                    /* Файл: progr_01_20.cpp
                     * Тема 1. Стандартни прости типове
                     * Примерно решение на Задача 1.20
                     * от файл: Основи C++ Задачи Тема 01.pdf
                     * Октомври 2016 г. Кирил Иванов
                     */
#include <iostream>
using namespace std;
int main() {
  cout << "-1 < (unsigned int)1 = "
       << (-1 < (unsigned int)1 ? "true" : "false")
       << endl;
  cout << "-1 < 1U = "
       << (-1 < 1U ? "true" : "false")
       << endl;

  system("pause");
  return 0;
}
