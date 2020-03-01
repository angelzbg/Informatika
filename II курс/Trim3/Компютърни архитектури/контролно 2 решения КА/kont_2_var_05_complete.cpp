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
int fCpp(int a1[], int a2[], int L) {
  int sum = 0;
  for(int i = 0; i<L; ++i)
    if( (a1[i] + a2[i]) % 2 != 0  )
      sum += a1[i] - a2[i];
  return sum;
}
int fAsm(int a1[], int a2[], int L) {
  __asm {
	// eax == sum
	// esi == a1[i]
	// edi == a2[i]
	push edi
	push esi
	push ecx
		xor eax, eax
		mov edi, L
		mov esi, a1
		lea esi, [esi + edi*4]
		//imul edi, 4 // вместо следващия ред
		shl edi, 2
		add edi, a2
	  Lab_c : 	sub esi, 4
				sub edi, 4
				cmp esi, a1
				jnae Lab_end
					mov ecx, [esi]
					add ecx, [edi]
					bt ecx, 0
					jnc Lab_c
						add eax, [esi]
						sub eax, [edi]
				jmp Lab_c
	  Lab_end :
	pop ecx
	pop esi
	pop edi
  }
}
int main() {
  system("chcp 1251");
  const int Len = 11;
  int ar1[Len], ar2[Len];
  srand( (unsigned) time(NULL) );
  for(int i=0; i<Len; ++i) {
	ar1[i] = rand() % 30;
	ar2[i] = rand() % 30;
  }
  cout << "Първи масив: ";
  for(int i=0; i<Len; ++i) cout << setw(3) << ar1[i];
  cout << "\nВтори масив: ";
  for(int i=0; i<Len; ++i) cout << setw(3) << ar2[i];
  cout << "\n\n";
  cout << "Резултат: " << fCpp(ar1, ar2, Len) <<"\n\n";
  cout << "Резултат: " << fAsm(ar1, ar2, Len) <<"\n\n";
  system("pause");
  return 0;
}
