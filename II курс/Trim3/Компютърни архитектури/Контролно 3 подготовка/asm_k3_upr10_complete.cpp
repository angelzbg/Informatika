/* Задание 
Да се допише блокът на функцията fCpp така, че резултатът от нейното изпълнение
да бъде същият, какъвто е от изпълнението на функцията fAsm,
когато двете функции се извикват с еднакви фактически параметри.   
*/

#include <iostream>
using namespace std;
#include <cstring>
char * fAsm(char * s, char c, int n) {
  __asm {
    push ecx
        mov eax, s
        mov ch, c
      LabelC :  cmp byte ptr [eax], 0
                jz Lstop1
                    cmp ch, [eax]
                    jnz Lnext
                      dec n
                  Lnext :
                    cmp n, 1
                    jnge Lstop2
                inc eax
                jmp LabelC
      Lstop1 :
        xor eax, eax
      Lstop2 :
    pop ecx
  }
}
char * fCpp(char * s, char c, int n) {
  while ( *s ) {
    if( *s == c ) --n;
    if( n<1 ) return s;
    ++s;
  }
  return NULL;
}
int main() {
  system("chcp 1251");
  const short maxLen = 60;
  int num;
  cout << "Въведете брой: ";
  cin >> num;
  char chr, str[maxLen+1];
  cout << "Въведете знак: ";
  cin >> chr;
  cin.ignore();
  cout << "Въведете низ до " << maxLen <<" знака: ";
  cin.getline(str,maxLen+1);
  char * p = fCpp(str, chr, num);
  if( p ) cout << "Резултат: \"" << p <<"\"\n\n";
  else cout << "Резултат: \"\"\n\n";
  p = fAsm(str, chr, num);
  if (p) cout << "Резултат: \"" << p << "\"\n\n";
  else cout << "Резултат: \"\"\n\n";
  system("pause");
  return 0;
}
