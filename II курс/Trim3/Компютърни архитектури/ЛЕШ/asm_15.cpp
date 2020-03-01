// файл asm_15.cpp
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

}
int main() {
  system("chcp 1251");
  char str[33];
  int n;
  cout << "Въведете цяло число: ";
  cin >> n;
  binary(n, str);
  cout << "Двоичен запис на допълнителния код: " << str << endl;
  binary(n, str);
  cout << "Двоичен запис на допълнителния код: " << str << endl;
  system("pause");
  return 0;
}
