// פאיכ asm_19.cpp
#include <iostream>
using namespace std;
#include <ctime>
#include <iomanip>
const int lenAr = 11, minValue = -60, maxValue = 30, width = 4;
void incDec(int a[], int L) {
  for (int i = 0; i < L; ++i) 
    if( a[i] % 8 == 0 ) ++a[i];
    else --a[i];
}
void incDecAsm(int a[], int L) {
  
}
void write(int a[], int L) {
  for(int i=0; i<L; ++i) cout << setw(width) << a[i];
  cout<<endl;
}
void copyArray(int s[], int d[], int L) {
  for(int i=0; i<L; ++i) d[i]=s[i];
}
int main() {
  system("chcp 1251");
  int original[lenAr], copy[lenAr];
  srand((unsigned)time(NULL));
  for (int i = 0; i < lenAr; ++i)
    original[i] = rand() % (maxValue - minValue + 1) + minValue;
  write(original, lenAr);
  cout<<endl;

  copyArray(original, copy, lenAr);
  incDec(copy, lenAr);
  write(copy, lenAr);

  copyArray(original, copy, lenAr);
  incDecAsm(copy, lenAr);
  write(copy, lenAr);

  system("pause");
  return 0;
}
