// файл asm_16.cpp
#include <iostream>
using namespace std;
#include <ctime>
#include <iomanip>
const int len = 4, min = -30, max = 50;
int indMaxOddElm(int ar[], int L) {
  int indMax = -1;
  for (int i = 0; i < L; ++i)
    if (ar[i] % 2 != 0 && (-1 == indMax || ar[indMax] < ar[i]))
      indMax = i;
  return indMax;
}
int indMaxOddElmAsm(int ar[], int L) {
  
}
int main() {
  system("chcp 1251");
  int nums[len];
  srand((unsigned)time(NULL));
  for (int i = 0; i < len; ++i)
    nums[i] = rand() % (max - min + 1) - min;
  cout << "Масив:";
  for (int i = 0; i < len; ++i) cout << setw(4) << nums[i];
  cout << "\nМасив:";
  for (int i = 0; i < len; ++i) cout << setw(4) << i;
  cout << "\n\n";
  int iRes = indMaxOddElm(nums, len);
  if (iRes < 0) cout << "Няма нечетни елементи.\n\n";
  else cout << "Индекс на максимален нечетен елемент: "
            << iRes << "\n\n";
  iRes = indMaxOddElmAsm(nums, len);
  if (iRes < 0) cout << "Няма нечетни елементи.\n\n";
  else cout << "Индекс на максимален нечетен елемент: "
            << iRes << "\n\n";
  system("pause");
  return 0;
}
