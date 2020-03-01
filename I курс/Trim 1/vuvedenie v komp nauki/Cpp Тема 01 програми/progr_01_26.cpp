                    /* Файл: progr_01_26.cpp
                     * Тема 1. Стандартни прости типове
                     * Примерно решение на Задача 1.26
                     * от файл: Основи C++ Задачи Тема 01.pdf
                     * Октомври 2016 г. Кирил Иванов
                     */
#include <iostream>
using namespace std;
int main() {
  unsigned short m;
  cout << "Month (from 1 to 12): ";
  cin >> m;
  cout << (m == 2 || m == 4 || m == 6 || m == 9 || m == 11
           ? "false" : "true")
       << endl;

  system("pause");
  return 0;
}
