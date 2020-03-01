                    /* Файл: progr_01_18.cpp
                     * Тема 1. Стандартни прости типове
                     * Примерно решение на Задача 1.18
                     * от файл: Основи C++ Задачи Тема 01.pdf
                     * Октомври 2016 г. Кирил Иванов
                     */
#include <iostream>
using namespace std;
int main() {
  int year;
  cout << "Year: ";
  cin >> year;
  cout << "Days in the year: "
       << (year%400==0 || year%100!=0 && year%4==0 ? 366 : 365)
       << endl;
  cout << "Days in the year: "
       << 365 + (year%400==0 || year%100!=0 && year%4==0)
       << endl;

  system("pause");
  return 0;
}
