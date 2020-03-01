                    /* Файл: progr_01_13.cpp
                     * Тема 1. Стандартни прости типове
                     * Примерно решение на Задача 1.13
                     * от файл: Основи C++ Задачи Тема 01.pdf
                     * Октомври 2016 г. Кирил Иванов
                     */
#include <iostream>
using namespace std;
int main(){
  char ch;
  cout << "Character: ";
  cin >> ch;
  cout << "Code: " << (short)(ch) << endl;
  cout << "Code: " << (short)(unsigned char)(ch) << endl;
  unsigned char uch = ch;
  cout << "Code: " << (short)(uch) << endl;

  system("pause");
  return 0;
}
