                    /* Файл: progr_01_21.cpp
                     * Тема 1. Стандартни прости типове
                     * Примерно решение на Задача 1.21
                     * от файл: Основи C++ Задачи Тема 01.pdf
                     * Октомври 2016 г. Кирил Иванов
                     */
#include <iostream>
using namespace std;
int main() {
  signed long long s;
  cout << "Signed integer: ";
  cin >> s;
  unsigned long long u;
  cout << "Unsigned integer: ";
  cin >> u;
  cout << s << " < " << u << " = "
       << (s < u || s < 0LL ? "true" : "false")
       << endl;

  system("pause");
  return 0;
}
