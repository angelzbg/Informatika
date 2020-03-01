                    /* Файл: progr_01_30.cpp
                     * Тема 1. Стандартни прости типове
                     * Примерно решение на Задача 1.30
                     * от файл: Основи C++ Задачи Тема 01.pdf
                     * Октомври 2016 г. Кирил Иванов
                     */
#include <iostream>
using namespace std;
#include <cmath>
int main() {
  unsigned short n;
  cout << "Integer (from 0 to 2^16-1=65535): ";
  cin >> n;
  cout << n << "=" << n / 256 << "*256+" << n % 256
       << " --> " << n % 256 << "*256+" << n / 256
       << "= " << n % 256 * 256 + n / 256 << endl;

  system("pause");
  return 0;
}
