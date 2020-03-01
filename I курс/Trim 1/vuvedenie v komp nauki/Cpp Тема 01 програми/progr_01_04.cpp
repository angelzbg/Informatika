                    /* Файл: progr_01_04.cpp
                     * Тема 1. Стандартни прости типове
                     * Примерно решение на Задача 1.4
                     * от файл: Основи C++ Задачи Тема 01.pdf
                     * Октомври 2016 г. Кирил Иванов
                     */
#include <iostream>
using namespace std;
int main() {
  int M, N;
  cout << "Integers M N: ";
  cin >> M >> N;
  cout << "Result: " << (M + N) / (N - 1.0) - (3.0 * M - 1) / (2 * N) << endl;
  cout << "Result: " << (M + N) / (N - 1.0) - (3 * M - 1) / (2.0 * N) << endl;
  cout << "Result: "
       << (M + N) / (double)(N - 1) - (3 * M - 1) / (2 * (double)N) << endl;
  cout << "Result: "
       << ((double)M + N) / (N - 1) - (3 * (double)M - 1) / (2 * N) << endl;
       
  system("pause");
  return 0;
}
