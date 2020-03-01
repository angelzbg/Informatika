// файл asm_16_complete.cpp
#include <iostream>
using namespace std;
#include <ctime>
#include <iomanip>
const int len = 4, min = -30, max = 50;
int indMaxOddElm(int ar[], int L) {
	int indMax = -1;
	for (int i = 0; i < L; ++i)
	if (ar[i] % 2 != 0 && (-1 == indMax || ar[indMax] < ar[i]))
		indMax = i;
	return indMax;
}
int indMaxOddElmAsm(int ar[], int L) { // К. Иванов
	__asm {
		push ecx
			push esi
			push edx
			mov esi, ar
			mov ecx, L
			mov eax, -1
		Lab_c : test dword ptr[esi + ecx * 4 - 4], 1
				jz Lab_next // преход при четен елемент
				cmp eax, -1
				je Lab_newMax // преход при срешане на първия нечетен елемент
				cmp edx, [esi + ecx * 4 - 4]
				jge Lab_next // преход, когато поредният нечетен не е нов максимум
			Lab_newMax : // има нов максимален нечетен елемент
		mov eax, ecx
			dec eax // eax получава индекса на новия максимален
			mov edx, [esi + eax * 4] // edx получава самия максимален
		Lab_next :
				 loop Lab_c
				 pop edx
				 pop esi
				 pop ecx
	}
}

int indMaxOddElmAsm2(int a[], int len) { //Мой №1
	__asm
	{
			mov eax, -1 //индекс на максимален нечетен елемент
			push esi //масива
			push ecx //дължината
			push ebx //index counter
			push edi //максималния

			mov edi, -2147483647 //ако първия елемент в масива е -2147483647 <=> кода не става

			mov ebx, -1
			mov esi, a
			mov ecx, len
			sub esi, 4


			L1:
				add ebx, 1
				add esi, 4

				test dword ptr[esi], 1
				jz Next

				cmp edi, [esi]
				jg Next

				mov eax, ebx
				mov edi, [esi]

				Next: loop L1

			pop edi
			pop ebx
			pop ecx
			pop esi
	}
}

int indMaxOddElmAsm3(int a[], int len) { //Мой №2
	__asm
	{
			mov eax, -1 //индекс на максимален нечетен елемент
			push esi //масива
			push ecx //дължината
			push ebx //index counter
			push edi //максималния
			push edx //temp

			mov edi, -2147483647 //ако първия елемент в масива е -2147483647 <=> кода не става

			mov ebx, -1
			mov esi, a
			mov ecx, len
			sub esi, 4


			L1:
				add ebx, 1
				add esi, 4

				mov edx, [esi]
				and edx, 1
				cmp edx, 0
				je Next //ако edx е 0, значи не е четен елемент

				cmp edi, [esi]
				jg Next //ако максималния намерен до момента е по-голям от текущия нечетен, нова врътка
				/*надолу до Next следва кода, който се извършва ако имаме нечетен елемент,
				който е по-голям от максималния намерен*/
				mov eax, ebx
				mov edi, [esi]

				Next: loop L1

			pop edx
			pop edi
			pop ebx
			pop ecx
			pop esi
	}
}

int main() {
	system("chcp 1251");
	int nums[len];
	srand((unsigned)time(NULL));
	for (int i = 0; i < len; ++i)
		nums[i] = rand() % (max - min + 1) - min;
	cout << "Масив:";
	for (int i = 0; i < len; ++i) cout << setw(4) << nums[i];
	cout << "\nМасив:";
	for (int i = 0; i < len; ++i) cout << setw(4) << i;
	cout << "\n\n";
	int iRes = indMaxOddElm(nums, len);
	if (iRes < 0) cout << "Няма нечетни елементи.\n\n";
	else cout << "Индекс на максимален нечетен елемент: "
		<< iRes << "\n\n";
	iRes = indMaxOddElmAsm(nums, len);
	if (iRes < 0) cout << "Няма нечетни елементи.\n\n";
	else cout << "Индекс на максимален нечетен елемент: "
		<< iRes << "\n\n";

	iRes = indMaxOddElmAsm2(nums, len);
	if (iRes < 0) cout << "Няма нечетни елементи.\n\n";
	else cout << "Индекс на максимален нечетен елемент: "
		<< iRes << "\n\n";


	iRes = indMaxOddElmAsm3(nums, len);
	if (iRes < 0) cout << "Няма нечетни елементи.\n\n";
	else cout << "Индекс на максимален нечетен елемент: "
		<< iRes << "\n\n";

	system("pause");
	return 0;
}