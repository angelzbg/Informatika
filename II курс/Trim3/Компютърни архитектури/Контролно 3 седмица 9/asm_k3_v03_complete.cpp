/* Задание
Да се допише блокът на функцията fCpp така, че резултатът от нейното изпълнение
да бъде същият, какъвто е от изпълнението на функцията fAsm,
когато двете функции се извикват с еднакви фактически параметри.
*/

#include <iostream>
using namespace std;
#include <ctime>
#include <iomanip>
int fAsm(int a[], int L) {
  __asm {
    push esi
    push ecx
    push edi
        mov esi, a
        xor eax, eax
        sub eax, [esi]
        mov ecx, 1
      BEGIN :     mov edi, [esi + ecx * 4]
                  cmp [esi + ecx * 4 - 4], edi
                  jge STEP
                    add eax, edi
                    sub eax, [esi + ecx * 4 - 4]
                    jmp NEXT
                STEP :
                    add eax, ecx
                    sub eax, edi
                NEXT :
              add ecx, 2
              cmp ecx, L
              jnae BEGIN
        sub eax, L
        shl eax, 1
    pop edi
    pop ecx
    pop esi
  }
}
int fCpp(int a[], int L) {
  int res = -a[0];
  for (int i=1; i<L; i+=2)
    if( a[i-1] < a[i] ) 
      res += a[i] - a[i-1];
    else res += i - a[i];
  return 2 * (res - L);
}
int main() {
  system("chcp 1251");
  const int Len = 20, w = 3; // Len>1
  int ar[Len];
  srand((unsigned)time(NULL));
  for (int i = 0; i<Len; ++i)
    ar[i] = rand() % 15;
  cout << "Масив:   ";
  for (int i = 0; i<Len; ++i) cout << setw(w) << ar[i];
  cout << "\nИндекси: ";
  for (int i = 0; i<Len; ++i) cout << setw(w) << i;
  cout << "\n\n";
  cout << "Резултат: " << fAsm(ar, Len) << "\n\n";
  cout << "Резултат: " << fCpp(ar, Len) << "\n\n";
  system("pause");
  return 0;
}
