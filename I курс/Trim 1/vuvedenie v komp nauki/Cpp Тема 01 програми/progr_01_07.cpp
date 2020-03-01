                    /* Файл: progr_01_07.cpp
                     * Тема 1. Стандартни прости типове
                     * Примерно решение на Задача 1.7
                     * от файл: Основи C++ Задачи Тема 01.pdf
                     * Октомври 2016 г. Кирил Иванов
                     */
#include <iostream>
using namespace std;
#include <cmath>
int main() {
  long long d, N;
  cout << "Integers N d: ";
  cin >> N >> d;
  long long r = N % d;
  cout << "Remainder: " << r + (r < 0 ? abs(d) : 0LL) << endl;
  cout << "Remainder: " << (r < 0 ? r + abs(d) : r) << endl;

  system("pause");
  return 0;
}
