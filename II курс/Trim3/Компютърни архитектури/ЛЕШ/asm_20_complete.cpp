// файл asm_20_complete.cpp
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
  __asm { // първи начин
    push ecx
    push esi
      xor eax, eax
      mov ecx, 31
    Lab_c :   mov esi, n
              and esi, 3
              cmp esi, 3
              jne Lab_next
              inc eax
    Lab_next :
            shr n, 1
            loop Lab_c
    pop esi
    pop ecx
  }
}
int countPairs11Asm2(int n) {
  __asm { // втори начин
    push ecx
    push edx
      xor eax, eax
      mov ecx, 0
    Lab_c :   bt n, ecx
              setc dl
              inc ecx
              bt n, ecx
              adc dl, 0
              cmp dl, 2
              jne Lab_next
              inc eax
    Lab_next :
          cmp ecx, 32
          jnae Lab_c
    pop edx
    pop ecx
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
  cout << "Брой на двойките \"11\" в допълнителния код: "
       << countPairs11Asm2(num) << endl;
  system("pause");
  return 0;
}
