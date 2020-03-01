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
        mov esi, L
        lea esi, [esi * 4 - 8]
        add esi, a // esi <- &a[L-2]
        mov eax, [esi + 4] // eax <- a[L-1]
        cmp esi, a
        jna END
      BEGIN :     bt [esi], 0 // [esi] == a[i]
                  jnc NEXT
                  bt [esi], 31
                  jc STEP
                    add eax, [esi]
                    jmp NEXT
                STEP :
                    sub eax, [esi]
                NEXT :
              sub esi, 4
              cmp esi, a
              ja BEGIN
      END :
        sub eax, [esi]
    pop esi
  }
}
int fCpp(int a[], int L) {
  int res = a[L - 1];
  for (int i=L-2; 1<=i; --i)
    if (a[i] % 2 == 1)
      //res += a[i] < 0 ? -a[i] : a[i];
      if( a[i] < 0 ) res -= a[i];
      else res += a[i];
  return res - a[0];
}
int main() {
  system("chcp 1251");
  const int Len = 15, w = 3; // Len>1
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
