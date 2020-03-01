                    /* Файл: progr_01_10.cpp
                     * Тема 1. Стандартни прости типове
                     * Примерно решение на Задача 1.10
                     * от файл: Основи C++ Задачи Тема 01.pdf
                     * Октомври 2016 г. Кирил Иванов
                     */
#include <iostream>
using namespace std;
#include <cmath>
int main() {
  double a, b;
  cout << "a b: ";
  cin >> a >> b;
  cout << "c = " << sqrt(a*a+b*b) << endl;

  system("pause");
  return 0;
}

