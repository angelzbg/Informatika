                    /* Файл: progr_01_03.cpp
                     * Тема 1. Стандартни прости типове
                     * Примерно решение на Задача 1.3
                     * от файл: Основи C++ Задачи Тема 01.pdf
                     * Октомври 2016 г. Кирил Иванов
                     */
#include <iostream>
using namespace std;
int main(){
  int x, y;
  cout << "x y : ";
  cin >> x >> y;
  cout << "Average = " << (x + y) / 2.0 << endl;
  cout << "Average = " << (x + y) / (double)2 << endl;
  cout << "Average = " << (x + (double)y) / 2 << endl;
  
  system("pause");
  return 0;
}
