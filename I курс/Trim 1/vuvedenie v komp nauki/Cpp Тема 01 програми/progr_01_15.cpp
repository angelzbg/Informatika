                    /* Файл: progr_01_15.cpp
                     * Тема 1. Стандартни прости типове
                     * Примерно решение на Задача 1.15
                     * от файл: Основи C++ Задачи Тема 01.pdf
                     * Октомври 2016 г. Кирил Иванов
                     */
#include <iostream>
using namespace std;
int main() {
  char Lt;
  cout << "Letter: ";
  cin >> Lt;
  cout << "Result: "
       << (char)(Lt + 2) << (char)(Lt + 2)
       << (char)(Lt + 1) << (char)(Lt + 1)
       << Lt << Lt << endl;
  
  system("pause");
  return 0;
}
