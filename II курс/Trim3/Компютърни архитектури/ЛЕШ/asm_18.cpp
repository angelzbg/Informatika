// файл asm_18.cpp
#include <iostream>
using namespace std;
#include <ctime>
const unsigned lenAr = 6, maxValue = 50;
int sumRemaindersWith16(unsigned a[], unsigned L) {
  int s = 0;
  for (int i = 0; i < L; ++i) s += a[i] % 16;
  return s;
}
int sumRemaindersWith16Asm(unsigned a[], unsigned L) {
  
}
int main() {
  system("chcp 1251");
  unsigned ar[lenAr];
  srand((unsigned)time(NULL));
  for (unsigned i = 0; i < lenAr; ++i)
    ar[i] = rand() % (maxValue + 1);
  cout << "Масив:  ";
  for (unsigned i = 0; i < lenAr; ++i) cout << ar[i] << ' ';
  cout << "\n\n";
  cout << "Брой на елементите кратни на 4 без да са кратни на 8: "
       << sumRemaindersWith16(ar, lenAr) << "\n\n";
  cout << "Брой на елементите кратни на 4 без да са кратни на 8: "
       << sumRemaindersWith16Asm(ar, lenAr) << "\n\n";
  system("pause");
  return 0;
}
