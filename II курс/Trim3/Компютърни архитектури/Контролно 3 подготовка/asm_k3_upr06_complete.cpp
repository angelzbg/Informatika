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
    push esi
    push ecx
    push edi
      xor eax, eax
      mov esi, a
      xor ecx, ecx
      xor edi, edi
    Lab__ :   bt [esi + ecx * 4], edi
              adc eax, 0
              inc edi
              and edi, 3
            inc ecx
            cmp ecx, L
            jnae Lab__
    pop edi
    pop ecx
    pop esi
  }
}
unsigned fCpp(unsigned a[], unsigned L) {
  unsigned res=0;
  for( unsigned i=0, N=0; i<L; ++i, N=(N+1)%4 )
    res += (a[i] >> N) % 2;
  return res;
}
unsigned main() {
  system("chcp 1251");
  const unsigned Len = 22;
  unsigned ar[Len];
  srand( (unsigned) time(NULL) );
  for(unsigned i=0; i<Len; ++i)
    ar[i] = rand() % 49;
  cout << "Масив: ";
  for(unsigned i=0; i<Len; ++i) cout << ar[i] << ' ';
  cout << "\n\n";
  cout << "Резултат: " << fAsm(ar,Len) <<"\n\n";
  cout << "Резултат: " << fCpp(ar,Len) <<"\n\n";
  system("pause");
  return 0;
}
