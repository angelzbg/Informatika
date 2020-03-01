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
      push edi
      mov esi, L
      lea esi, [esi * 4 - 12]
      add esi, a
      xor eax, eax
      cmp esi, a
      jnae L_end
    L_begin : mov edi, [esi]
              cmp edi, [esi + 8]
              jng L_else
              BT[ESI + 4], 0
              jc L_else
              mov edi, [esi + 4]
              saL edi, 3
              add eax, edi
              jmp L_next
            L_else :
    add eax, [esi]
      add eax, [esi + 8]
    L_next :
           sub esi, 4
           cmp esi, a
           jae L_begin
         L_end :
    pop edi
      pop esi
  }
}
int fCpp(int a[], int L) {
  return -1000222;
}
int main() {
  system("chcp 1251");
  const int Len = 20, w = 3; // Len>2
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
