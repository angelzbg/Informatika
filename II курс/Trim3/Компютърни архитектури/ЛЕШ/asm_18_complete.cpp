// файл asm_18_complete.cpp
#include <iostream>
using namespace std;
#include <ctime>
const unsigned lenAr = 6, maxValue = 50;
int sumRemaindersWith16(unsigned a[], unsigned L) {
	int s = 0;
	for (int i = 0; i < L; ++i) s += a[i] % 16;
	return s;
}
int sumRemaindersWith16Asm(unsigned a[], unsigned L) {
	__asm {
		push esi
			push ecx
			mov esi, L
			lea esi, [0 + esi * 4 - 4]
			add esi, a // esi получава адреса на последния елемент в масива
			xor eax, eax
		Lab_c : mov ecx, [esi]
				and ecx, 15 // в ecx остава остатъкът от деленето с 16
				add eax, ecx
				sub esi, 4
				cmp esi, a
				jae Lab_c
				pop ecx
				pop esi
	}
}

int sumRemaindersWith16Asm2(unsigned a[], unsigned len) {
	__asm
	{
		push ecx //дължината
		push esi //масива
		xor eax, eax //сум
		push edi //temp

		mov ecx, len
		mov esi, a

	L1:
		mov edi, [esi]
		and edi, 15
		add eax, edi
		add esi, 4
		loop L1


		pop edi
		pop esi
		pop ecx
	}
}

int main() {
	system("chcp 1251");
	unsigned ar[lenAr];
	srand((unsigned)time(NULL));
	for (unsigned i = 0; i < lenAr; ++i)
		ar[i] = rand() % (maxValue + 1);
	cout << "Масив:  ";
	for (unsigned i = 0; i < lenAr; ++i) cout << ar[i] << ' ';
	cout << "\n\n";
	cout << "Брой на елементите кратни на 4 без да са кратни на 8: "
		<< sumRemaindersWith16(ar, lenAr) << "\n\n";
	cout << "Брой на елементите кратни на 4 без да са кратни на 8: "
		<< sumRemaindersWith16Asm(ar, lenAr) << "\n\n";

	cout << "Брой на елементите кратни на 4 без да са кратни на 8: "
		<< sumRemaindersWith16Asm2(ar, lenAr) << "\n\n";

	system("pause");
	return 0;
}
