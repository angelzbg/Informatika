/* Задание за второ контроно
   по Компютърни архитектури със специалност Информатика, редовно, II курс
   през 2017-2018 учебна година
   
Да се допише блокът на функцията fAsm, така че резултатът от нейното изпълнение
да бъде същият, какъвто е от изпълнението на функцията fCpp,
когато двете функции се извикват с еднакви фактически параметри.   
*/

#include <iostream>
using namespace std;
#include <ctime>
#include <iomanip>
int fCpp(int a[], int L) {
  int res = 0;
  for(int i = 0; i<L; ++i)
    if( a[i] % 2 == i % 2 )
      res += a[i] + i;    
  return res;
}
int fAsm(int a[], int L) {
  __asm {
    // eax == res
    // ecx == i
    // esi == a
    push ecx
    push esi
    push edx
        xor eax, eax
        xor ecx, ecx
        mov esi, a
     Lab_c :    
				  bt [esi + ecx * 4], 0
				  setc DL
				  bt ecx, 0
				  setc DH
				  cmp DL, DH
				  jne Lab_step
					  add eax, [esi + ecx * 4]
					  add eax, ecx
   Lab_step :
            inc ecx
            cmp ecx, L
            jnae Lab_c
    pop edx
    pop esi
    pop ecx
  }
}
int fAsm2(int a[], int L) {
  __asm {
    // eax == res
    // ecx == i+1
    // esi == a
    push ecx
    push esi
    push edi
        xor eax, eax
        mov ecx, L
        mov esi, a
    Lab_c :     mov edi, [esi + ecx * 4 - 4]
                add edi, ecx
                dec edi
                bt edi, 0
                jc Lab_step
                    add eax, edi
    Lab_step : loop Lab_c
    pop edi
    pop esi
    pop ecx
  }
}
int main() {
  system("chcp 1251");
  const int Len = 12;
  int ar[Len];
  srand( (unsigned) time(NULL) );
  for(int i=0; i<Len; ++i)
    ar[i] = rand() % 40;
  cout << "Елементи: ";
  for(int i=0; i<Len; ++i) cout << setw(3) << ar[i];
  cout << endl;
  cout << "Индекси:  ";
  for(int i=0; i<Len; ++i) cout << setw(3) << i;
  cout << "\n\n";
  cout << "Резултат: " << fCpp(ar,Len) <<"\n\n";
  cout << "Резултат: " << fAsm(ar,Len) <<"\n\n";
  cout << "Резултат: " << fAsm2(ar, Len) << "\n\n";
  system("pause");
  return 0;
}
