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
    push edx
        mov eax, L
        mov esi, a
        lea esi, [esi + eax * 4 - 4]
        BEGIN :     mov ecx, [esi - 4]
                    mov edx, [esi]
                    and ecx, 3
                    and edx, 3
                    cmp ecx, edx
                    jne STEP
                      add eax, [esi - 4]
                      add eax, [esi]
                      jmp NEXT
                  STEP :
                      sub eax, ecx
                      sub eax, edx
                  NEXT :
                sub esi, 4
                cmp esi, a
                ja BEGIN
    pop edx
    pop ecx
    pop esi
  }
}
int fCpp(int a[], int L) {
  int res = L;
  for (int i=L-1; 1<=i; --i)
    if (  (a[i-1] & 3) == (a[i] & 3)  )
      res += a[i-1] + a[i];
    else res -= (a[i-1] & 3) + (a[i] & 3);
  return res;
}
int main() {
  system("chcp 1251");
  const int Len = 15, w = 3; // Len>1
  int ar[Len];
  srand((unsigned)time(NULL));
  for (int i = 0; i<Len; ++i)
    ar[i] = rand() % 15 - 4;
  cout << "Масив:   ";
  for (int i = 0; i<Len; ++i) cout << setw(w) << ar[i];
  cout << "\nИндекси: ";
  for (int i = 0; i<Len; ++i) cout << setw(w) << i;
  cout << "\n\n";
  cout << "Резултат: " << fAsm(ar, Len) << "\n\n";
  cout << "Резултат: " << fCpp(ar, Len) << "\n\n";
  cout << "Масив:   ";
  for (int i = 0; i<Len; ++i) cout << setw(w) << ar[i];
  cout << "\nИндекси: ";
  for (int i = 0; i<Len; ++i) cout << setw(w) << i;
  cout << "\n\n";
  system("pause");
  return 0;
}
