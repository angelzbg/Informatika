/* Задание 
Да се допише блокът на функцията fCpp така, че резултатът от нейното изпълнение
да бъде същият, какъвто е от изпълнението на функцията fAsm,
когато двете функции се извикват с еднакви фактически параметри.   
*/

#include <iostream>
using namespace std;
void fAsm(char * s) {
  __asm {
    push esi
    push edi
    push eax
        mov esi, s
      LC1 : cmp byte ptr [esi], 0
            je Lstop1
                mov ah, [esi]
                lea edi, [esi+1]
              LC2 : cmp byte ptr [edi], 0
                    je Lstop2
                        cmp ah, [edi]
                        jne Lnext
                          mov byte ptr [edi], '#'
                      Lnext :
                    inc edi
                    jmp LC2
              Lstop2 :
            inc esi
            jmp LC1
      Lstop1 :
    pop eax
    pop edi
    pop esi
  }
}
void fCpp(char * s) {
  
}
int main() {
  system("chcp 1251");
  const short maxLen = 60;
  char str[maxLen+1], source[maxLen+1];
  cout << "Въведете низ до " << maxLen <<" знака: ";
  cin.getline(source,maxLen+1);
  str[0] = source[0];  for (char *t = str, *s = source; *t; ++t, ++s) *(t + 1) = *(s + 1);
  fAsm(str);
  cout << "\nРезултат: \"" << str <<"\"\n\n";
  str[0] = source[0];  for (char *t = str, *s = source; *t; ++t, ++s) *(t + 1) = *(s + 1);
  fCpp(str);
  cout <<   "Резултат: \"" << str <<"\'\n\n";
  system("pause");
  return 0;
}
