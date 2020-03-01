// файл asm_20.cpp
#include <iostream>
using namespace std;
const int lenAr = 6, minValue = -60, maxValue = 30, width = 4;
int countPairs11(int n) {
  int cn = 0;
  for (int i = 1; i <= 31; ++i) {
    cn  +=  3 == (unsigned)n % 4;
    n >>= 1;
  }
  return cn;
}
int countPairs11Asm(int n) {
  
}
}
int main() {
  system("chcp 1251");
  int num;
  cout << "Въведете цяло число: ";
  cin >> num;
  cout << "Брой на двойките \"11\" в допълнителния код: "
       << countPairs11(num) << endl;
  cout << "Брой на двойките \"11\" в допълнителния код: "
       << countPairs11Asm(num) << endl;
  system("pause");
  return 0;
}
