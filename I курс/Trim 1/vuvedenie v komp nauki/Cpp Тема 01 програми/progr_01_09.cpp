                    /* Файл: progr_01_09.cpp
                     * Тема 1. Стандартни прости типове
                     * Примерно решение на Задача 1.9
                     * от файл: Основи C++ Задачи Тема 01.pdf
                     * Октомври 2016 г. Кирил Иванов
                     */
#include <iostream>
using namespace std;
int main() {
  long long n;
  cout << "Integer: ";
  cin >> n;
  long long res = n / 5LL * 5LL;
  cout << "Result: " << res + (n < res ? -5LL : 0LL) << endl;
  cout << "Result: " << res - 5LL * (n < res) << endl;

  system("pause");
  return 0;
}

