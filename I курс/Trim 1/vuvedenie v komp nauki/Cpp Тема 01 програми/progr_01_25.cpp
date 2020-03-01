                    /* Файл: progr_01_25.cpp
                     * Тема 1. Стандартни прости типове
                     * Примерно решение на Задача 1.25
                     * от файл: Основи C++ Задачи Тема 01.pdf
                     * Октомври 2016 г. Кирил Иванов
                     */
#include <iostream>
using namespace std;
int main() {
  bool x1, x2;
  cout << "Two boolean values (0 or 1): ";
  cin >> x1 >> x2;
  // 1-и начин
  cout << "Function( "
       << (x1 ? "true" : "false") << " ; "
       << (x2 ? "true" : "false") << " ) = "
       << (x1 ? x2?7:-2 : x2?11:-25)
       << endl;
  // 2-и начин
  cout << "Function( "
       << (x1 ? "true" : "false") << " ; "
       << (x2 ? "true" : "false") << " ) = "
       << (x1 ? -2+9*x2 : -25+36*x2)
       << endl;

  system("pause");
  return 0;
}
