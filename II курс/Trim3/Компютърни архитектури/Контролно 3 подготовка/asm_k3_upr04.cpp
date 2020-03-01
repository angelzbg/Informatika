/* Задание 
Да се допише блокът на функцията fCpp така, че резултатът от нейното изпълнение
да бъде същият, какъвто е от изпълнението на функцията fAsm,
когато двете функции се извикват с еднакви фактически параметри.   
*/

#include <iostream>
using namespace std;
#include <ctime>
unsigned fAsm(unsigned a[], unsigned L) {
  __asm {
    push ecx
    push edi
    push esi
      xor eax, eax
      mov ecx, L
      dec L
      xor edi, edi
      mov esi, a
    L_cycle :   add eax, [esi + edi * 4]
                mov edi, [esi + edi * 4]
                and edi, L
              loop L_cycle
    pop esi
    pop edi
    pop ecx
  }
}
unsigned fCpp(unsigned a[], unsigned L) {
  return 9;
}
unsigned main() {
  system("chcp 1251");
  const unsigned Len = 16;
  unsigned ar[Len];
  srand( (unsigned) time(NULL) );
  for(unsigned i=0; i<Len; ++i)
    ar[i] = rand() % 99;
  cout << "Масив: ";
  for(unsigned i=0; i<Len; ++i) cout << ar[i] << ' ';
  cout << "\n\n";
  cout << "Резултат: " << fAsm(ar,Len) <<"\n\n";
  cout << "Резултат: " << fCpp(ar,Len) <<"\n\n";
  system("pause");
  return 0;
}
