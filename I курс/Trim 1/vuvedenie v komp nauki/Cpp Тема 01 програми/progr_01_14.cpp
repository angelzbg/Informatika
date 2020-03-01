                    /* Файл: progr_01_14.cpp
                     * Тема 1. Стандартни прости типове
                     * Примерно решение на Задача 1.14
                     * от файл: Основи C++ Задачи Тема 01.pdf
                     * Октомври 2016 г. Кирил Иванов
                     */
#include <iostream>
using namespace std;
int main(){
  char ch;
  cout << "Character: ";
  cin >> ch;
  cout << "Next character: " << (char)(ch + 1) << endl;

  system("pause");
  return 0;
}
