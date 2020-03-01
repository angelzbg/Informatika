                    /* Файл: progr_01_02.cpp
                     * Тема 1. Стандартни прости типове
                     * Примерно решение на Задача 1.2
                     * от файл: Основи C++ Задачи Тема 01.pdf
                     * Октомври 2016 г. Кирил Иванов
                     */
#include <iostream>
using namespace std;
int main() {
  long x = 2L, y = -4L, z = (2L + x) * (y - 1L) + 1000L * (x + y);
  cout << "x = " << x << endl
       << "y = " << y << endl
       << "z = " << z << endl << endl;
       
  system("pause");
  return 0;
}
