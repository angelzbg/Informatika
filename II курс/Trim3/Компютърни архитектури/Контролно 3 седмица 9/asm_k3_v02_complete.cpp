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
        mov eax, L
        add eax, [esi + eax * 4 - 4]
        xor ecx, ecx
      BEGIN :     bt [esi + ecx * 4], 31
                  jc NEXT
                    mov edi, [esi + ecx * 4]
                    and edi, 7
                    add eax, edi
                NEXT :
              bt [esi + ecx * 4], 0
              adc ecx, 1
              cmp ecx, L
              jnae BEGIN
    pop edi
    pop ecx
    pop esi
  }
}
int fCpp(int a[], int L) {
  int res = a[L - 1] + L;
  for (int i=0; i<L; i+=1+(a[i]%2!=0))
    if (a[i] % 2 != 0)
      res += a[i] % 8;
  return res;
}
int main() {
  system("chcp 1251");
  const int Len = 20, w = 3; // Len>1
  int ar[Len];
  srand((unsigned)time(NULL));
  for (int i = 0; i<Len; ++i)
    ar[i] = 3 + 2 * rand() % 5;
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
