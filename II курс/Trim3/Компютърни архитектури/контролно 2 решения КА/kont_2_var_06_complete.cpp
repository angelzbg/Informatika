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
  int n = a[L-1] - a[L-2];
  for(int i = L-2; 1<=i; --i)
    if( a[i] - a[i-1] < n )
      return i;
  return -1;
}
int fAsm(int a[], int L) {
  __asm {
	// eax == i или eax == -1, след като if-ът не е сработил нито веднъж
	// esi == a
	// edi == n
		push esi
		push edi
		push ecx
			mov eax, L
			sub eax, 2 // eax <- (L-2)
			mov esi, a
			mov edi, [esi + eax * 4 + 4] // edi <- a[L-1]
			sub edi, [esi + eax * 4]     // edi <- (a[L-1] - a[L-2])
		  Label_c : mov ecx, [esi + eax * 4]     // ecx <- a[i]
					sub ecx, [esi + eax * 4 - 4] // (ecx <- a[i]-a[i-1])
					cmp ecx, edi
					jnge Label_pop
				dec eax
				cmp eax, 1
				jge Label_c
			mov eax, -1
	  Label_pop :
		pop ecx
		pop edi
		pop esi
  }
}
int main() {
  system("chcp 1251");
  const int Len = 10;
  int ar[Len];
  srand( (unsigned) time(NULL) );
  for(int i=0; i<Len; ++i)
    ar[i] = rand() % 10;
  cout << "Елементи: ";
  for(int i=0; i<Len; ++i) cout << setw(3) << ar[i];
  cout << endl;
  cout << "Индекси:  ";
  for(int i=0; i<Len; ++i) cout << setw(3) << i;
  cout << "\n\n";
  cout << "Резултат: " << fCpp(ar,Len) <<"\n\n";
  cout << "Резултат: " << fAsm(ar,Len) <<"\n\n";
  system("pause");
  return 0;
}
