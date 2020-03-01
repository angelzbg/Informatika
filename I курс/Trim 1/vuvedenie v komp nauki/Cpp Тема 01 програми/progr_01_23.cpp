                    /* Файл: progr_01_23.cpp
                     * Тема 1. Стандартни прости типове
                     * Примерно решение на Задача 1.23
                     * от файл: Основи C++ Задачи Тема 01.pdf
                     * Октомври 2016 г. Кирил Иванов
                     */
#include <iostream>
using namespace std;
int main(){
  bool v1, v2, v3;
  cout << "Three boolean value: ";
  cin >> v1 >> v2 >> v3;
  cout << "Function( "
    << (v1 ? "true" : "false") << " ; "
    << (v2 ? "true" : "false") << " ; "
    << (v3 ? "true" : "false") << " ) = "
    << ( v1 || !v1 && !v2 && v3 || !v3
         ? "true" : "false" )
    << endl;

  cout << "Function( "
      << (v1 ? "true" : "false") << " ; "
      << (v2 ? "true" : "false") << " ; "
      << (v3 ? "true" : "false") << " ) = "
      << ( v1 || !v2 || !v3 // еквивалентен израз
           ? "true" : "false" )
      << endl;

  system("pause");
  return 0;
}
