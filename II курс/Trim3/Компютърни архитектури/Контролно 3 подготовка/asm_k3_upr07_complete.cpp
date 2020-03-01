/* Задание 
Да се допише блокът на функцията fCpp така, че резултатът от нейното изпълнение
да бъде същият, какъвто е от изпълнението на функцията fAsm,
когато двете функции се извикват с еднакви фактически параметри.   
*/

#include <iostream>
using namespace std;
#include <ctime>
#include <iomanip>
int fAsm(int a1[], int a2[], int a3[], int L) {
  __asm {
    push ecx
    push esi
    push edi
    push edx
      mov ecx, L
      mov esi, a2
      lea esi, [esi + ecx*4 - 8]
      mov edi, a3
      lea edi, [edi + ecx*4 - 4]
      lea ecx, [ecx*4 - 12]
      add ecx, a1
      xor eax, eax
    L_c :     mov edx, [ecx]
              cmp edx, [esi]
              jge L_step1
                mov edx, [esi]
            L_step1 :
              cmp [edi], edx
              jge L_step2
                add eax, edx
                jmp L_step3
            L_step2 :
                add eax, [edi]
            L_step3 :
          sub ecx, 4
          sub esi, 4
          sub edi, 4
          cmp ecx, a1
          jae L_c
    pop edx
    pop edi
    pop esi
    pop ecx
  }
}
int fCpp(int a1[], int a2[], int a3[], int L) {
  int res=0;
  for(int i=L-2, max; 1<=i; --i) {
    max = a1[i-1] < a2[i] ? a2[i] : a1[i-1];
    res += max < a3[i+1] ? a3[i+1] : max;
  }
  return res;
}
int main() {
  system("chcp 1251");
  const int Len = 8; // Len>2
  int ar1[Len], ar2[Len], ar3[Len];
  srand( (unsigned) time(NULL) );
  for(int i=0; i<Len; ++i) {
    ar1[i] = 10 + rand() % 100;
    ar2[i] = 20 + rand() % 100;
    ar3[i] = 30 + rand() % 100;
  }
  cout << "Масиви:\n";
  for(int i=0; i<Len; ++i)
    cout << setw(5) << ar1[i] << setw(5) << ar2[i] << setw(5) << ar3[i] << endl;
  cout << endl;
  cout << "Резултат: " << fAsm(ar1,ar2,ar3,Len) <<"\n\n";
  cout << "Резултат: " << fCpp(ar1,ar2,ar3,Len) <<"\n\n";
  system("pause");
  return 0;
}
