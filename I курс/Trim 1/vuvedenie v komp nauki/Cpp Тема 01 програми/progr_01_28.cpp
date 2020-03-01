                    /* Файл: progr_01_28.cpp
                     * Тема 1. Стандартни прости типове
                     * Примерно решение на Задача 1.28
                     * от файл: Основи C++ Задачи Тема 01.pdf
                     * Октомври 2016 г. Кирил Иванов
                     */
#include <iostream>
using namespace std;
#include <cmath>
int main(){
  short num;
  cout << "Integer: ";
  cin >> num;
  cout << "Left three digits: "
       << abs( (num>>15) % 2 )
       << abs( (num>>14) % 2 )
       << abs( (num>>13) % 2 )
       << endl;

  system("pause");
  return 0;
}
