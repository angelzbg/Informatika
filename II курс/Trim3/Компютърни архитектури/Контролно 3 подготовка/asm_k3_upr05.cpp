/* Задание 
Да се допише блокът на функцията fCpp така, че резултатът от нейното изпълнение
да бъде същият, какъвто е от изпълнението на функцията fAsm,
когато двете функции се извикват с еднакви фактически параметри.   
*/

#include <iostream>
using namespace std;
#include <ctime>
void fAsm(unsigned a1[], unsigned a2[], unsigned L) {
  __asm {
    pushad
      mov esi, a1
      mov edi, a2
      mov ecx, L
    Lab_c1 :    xor eax, eax
                    mov edx, L
                    xchg edx, ecx
                    sub ecx, edx
                    inc ecx
                  Lab_c2 :    add eax, [esi + ecx * 4 - 4]
                            loop Lab_c2
                    mov ecx, edx
                mov [edi + ecx * 4 - 4], eax
            loop Lab_c1
    popad
  }
}
void fCpp(unsigned a1[], unsigned a2[], unsigned L) {
  
}
void write(unsigned a[], unsigned L) {
  for(unsigned i=0; i<L; ++i) cout << a[i] << ' ';
  cout << endl;
}
unsigned main() {
  system("chcp 1251");
  const unsigned Len = 19;
  unsigned ar1[Len], ar2[Len];
  srand( (unsigned) time(NULL) );
  for(unsigned i=0; i<Len; ++i)
    ar1[i] = rand() % 32;
  cout << "\nНачален масив:\n";
  write(ar1, Len);
  cout << "\n\n";
  cout << "Резултати:\n";
  fAsm(ar1, ar2, Len);
  write(ar2, Len);
  fCpp(ar1, ar2, Len);
  write(ar2, Len);
  cout << "\n\n";
  system("pause");
  return 0;
}
