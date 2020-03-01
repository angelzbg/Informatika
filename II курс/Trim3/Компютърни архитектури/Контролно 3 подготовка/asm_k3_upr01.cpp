/* Задание 
Да се допише блокът на функцията fCpp така, че резултатът от нейното изпълнение
да бъде същият, какъвто е от изпълнението на функцията fAsm,
когато двете функции се извикват с еднакви фактически параметри.   
*/

#include <iostream>
using namespace std;
#include <ctime>
int fAsm(int a[], int L) {
  __asm {
    push ecx
      mov eax, -75
      mov ecx, L
      lea ecx, [0 + ecx * 4 - 12]
      add ecx, a
    Label_start :   add eax, [ecx + 8]
                    add eax, [ecx - 4]
                    sub eax, [ecx + 4]
                    sub eax, [ecx + 4]
                  sub ecx, 8
                  cmp ecx, a
                  ja Label_start
    pop ecx
  }
}
int fCpp(int a[], int L) {
  return -1009;
}
int main() {
  system("chcp 1251");
  const int Len = 27;
  int ar[Len];
  srand( (unsigned) time(NULL) );
  for(int i=0; i<Len; ++i)
    ar[i] = 1 + 2 * rand() % 5;
  cout << "Масив: ";
  for(int i=0; i<Len; ++i) cout << ar[i] << ' ';
  cout << "\n\n";
  cout << "Резултат: " << fAsm(ar,Len) <<"\n\n";
  cout << "Резултат: " << fCpp(ar,Len) <<"\n\n";
  system("pause");
  return 0;
}
