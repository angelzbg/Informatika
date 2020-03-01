// файл asm_17.cpp
#include <iostream>
using namespace std;
#include <ctime>
const int len = 6, min = -20, max = 15;
int countDivided4Not8(int ar[], int L) {
  int cn = 0;
  for (int i = 0; i < L; ++i)
    if (ar[i] % 4 == 0  &&  ar[i] % 8 != 0) ++cn;
  return cn;
}
int countDivided4Not8Asm(int ar[], int L) {
  
}
int main() {
  system("chcp 1251");
  int nums[len];
  srand((unsigned)time(NULL));
  for (int i = 0; i < len; ++i)
    nums[i] = rand() % (max - min + 1) + min;
  cout << "Масив:  ";
  for (int i = 0; i < len; ++i) cout << nums[i] << ' ';
  cout << "\n\n";
  int res = countDivided4Not8(nums, len);
  cout << "Брой на елементите кратни на 4 без да са кратни на 8: "
       << res << "\n\n";
  res = countDivided4Not8Asm(nums, len);
  cout << "Брой на елементите кратни на 4 без да са кратни на 8: "
       << res << "\n\n";
  system("pause");
  return 0;
}
