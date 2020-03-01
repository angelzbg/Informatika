// файл asm_15_complete.cpp
#include <iostream>
using namespace std;
#include <cstdlib> // за функцията int abs(int)
void binary(int n, char s[]) {
  s[32] = 0;
  for (int i = 31; 0 <= i; --i) {
    s[i] = '0' + abs(n % 2);
    n >>= 1;
  }
}
void binaryAsm(int n, char s[]) {
  __asm { // първи начин
    push esi
    push ecx
    push eax
      mov esi, s
      mov byte ptr [esi + 32], 0
      mov ecx, 32
    Label_c :   mov byte ptr [esi + ecx - 1], '0'
                rcr n, 1
                adc byte ptr [esi + ecx - 1], 0
              loop Label_c
    pop eax
    pop ecx
    pop esi
  }
}
void binaryAsm2(int n, char s[]) {
  __asm { // втори начин
    pushad
      mov esi, s
      mov byte ptr[esi + 32], 0
      mov ecx, 31
      xor edi, edi
    Label_c : bt n, ecx
              setc [esi + edi]
              add byte ptr [esi + edi], '0'
              inc edi
              dec ecx
              cmp ecx, 0
              jge Label_c
    popad
  }
}
    int main() {
  system("chcp 1251");
  char str[33];
  int n;
  cout << "Въведете цяло число: ";
  cin >> n;
  binary(n, str);
  cout << "Двоичен запис на допълнителния код: " << str << endl;
  binaryAsm(n, str);
  cout << "Двоичен запис на допълнителния код: " << str << endl;
  binaryAsm2(n, str);
  cout << "Двоичен запис на допълнителния код: " << str << endl;
  system("pause");
  return 0;
}
