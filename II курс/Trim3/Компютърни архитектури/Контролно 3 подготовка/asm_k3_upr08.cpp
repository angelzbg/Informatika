/* Задание 
Да се допише блокът на функцията fCpp така, че резултатът от нейното изпълнение
да бъде същият, какъвто е от изпълнението на функцията fAsm,
когато двете функции се извикват с еднакви фактически параметри.   
*/

#include <iostream>
using namespace std;
int fAsm(int n) {
  __asm {
    push ecx
    push esi
        xor eax, eax
        mov ecx, 31
      L_start :     mov esi, 3
                    and esi, n
                    cmp esi, 3
                    jne L_next
                      inc eax
                  L_next :
                    shr n, 1
                loop L_start
    pop esi
    pop ecx
  }
}
int fCpp(int n) {
  return -234;
}
int main() {
  system("chcp 1251");
  int num;
  cout << "Въведете цяло число: ";
  cin >> num;
  cout << "\n\n";
  cout << "Резултат: " << fAsm(num) <<"\n\n";
  cout << "Резултат: " << fCpp(num) <<"\n\n";
  system("pause");
  return 0;
}
