                    /* Файл: progr_01_27.cpp
                     * Тема 1. Стандартни прости типове
                     * Примерно решение на Задача 1.27
                     * от файл: Основи C++ Задачи Тема 01.pdf
                     * Октомври 2016 г. Кирил Иванов
                     */
#include <iostream>
using namespace std;
int main(){
  unsigned short k;
  cout << "Exponent k (0<=k<=63): ";
  cin >> k;
  cout << "2^" << k << " = " << (1ULL << k) << endl;

  system("pause");
  return 0;
}
