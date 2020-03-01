                    /* Файл: progr_01_05.cpp
                     * Тема 1. Стандартни прости типове
                     * Примерно решение на Задача 1.5
                     * от файл: Основи C++ Задачи Тема 01.pdf
                     * Октомври 2016 г. Кирил Иванов
                     */
#include <iostream>
using namespace std;
#include <cmath>
int main() {
  int L;
  cout << "Integer: ";
  cin >> L;
  cout << "Digit of the hundreds: " << abs(L) / 10 % 10 << endl;
  
  system("pause");
  return 0;
}
