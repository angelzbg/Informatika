/* Задание 
Да се допише блокът на функцията fCpp така, че резултатът от нейното изпълнение
да бъде същият, какъвто е от изпълнението на функцията fAsm,
когато двете функции се извикват с еднакви фактически параметри.   
*/

#include <iostream>
using namespace std;
#include <ctime>
int fAsm(int a[], int Len) {
  __asm {
    push esi
    push edi
    push ecx
      mov esi, a
      mov edi, Len
      lea edi, [esi + edi * 4 - 4]
      xor eax, eax
    Lab_begin :     mov ecx, [esi]
                    add ecx, [edi]
                    bt ecx, 0
                    jnc Lab_else
                      add eax, ecx
                      jmp Lab_step
                  Lab_else :
                      sub eax, ecx
              Lab_step :
                add esi, 4
                sub edi, 4
                cmp esi, edi
                jna Lab_begin
    pop ecx
    pop edi
    pop esi
  }
}
int fCpp(int a[], int Len) {
  return -12345;
}
int main() {
  system("chcp 1251");
  const int Len = 25;
  int ar[Len];
  srand( (unsigned) time(NULL) );
  for(int i=0; i<Len; ++i)
    ar[i] = rand() % 11 - 5;
  cout << "Масив: ";
  for(int i=0; i<Len; ++i) cout << ar[i] << ' ';
  cout << "\n\n";
  cout << "Резултат: " << fAsm(ar,Len) <<"\n\n";
  cout << "Резултат: " << fCpp(ar,Len) <<"\n\n";
  system("pause");
  return 0;
}
