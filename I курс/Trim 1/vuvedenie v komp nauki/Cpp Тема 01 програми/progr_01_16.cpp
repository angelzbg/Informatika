                    /* Файл: progr_01_16.cpp
                     * Тема 1. Стандартни прости типове
                     * Примерно решение на Задача 1.16
                     * от файл: Основи C++ Задачи Тема 01.pdf
                     * Октомври 2016 г. Кирил Иванов
                     */
#include <iostream>
using namespace std;
int main() {
  char dig;
  cout << "Digit: ";
  cin >> dig;
  cout << dig << "*2 = " << (dig - '0') * 2 << endl;

  system("pause");
  return 0;
}
