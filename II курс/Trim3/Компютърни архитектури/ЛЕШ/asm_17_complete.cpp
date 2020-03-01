// файл asm_17_complete.cpp
#include <iostream>
using namespace std;
#include <ctime>
const int len = 6, min = -20, max = 15;
int countDivided4Not8(int ar[], int L) {
	int cn = 0;
	for (int i = 0; i < L; ++i)
	if (ar[i] % 4 == 0 && ar[i] % 8 != 0) ++cn;
	return cn;
}
int countDivided4Not8Asm(int ar[], int L) {
	__asm {
		push esi
			push ecx
			mov esi, ar
			xor eax, eax
			mov ecx, L
		Lab_c : test dword ptr[esi + ecx * 4 - 4], 3
				jnz Lab_next // преход, когато не е кратно на 4
				test dword ptr[esi + ecx * 4 - 4], 7
				jz Lab_next // преход, когато е кратно на 8
				inc eax
			Lab_next : loop Lab_c
					   pop ecx
					   pop esi
	}
}

int countDivided4Not8Asm2(int ar[], int L) {
	__asm {
		push esi
		push ecx

		xor eax, eax
		mov esi, ar
		mov ecx, L
		sub esi, 4

	Lab_c :
		add esi, 4
			test dword ptr [esi], 3
			jnz Lab_next
			test dword ptr[esi], 7
			jz Lab_next
			add eax, 1


			Lab_next : loop Lab_c
			
		pop ecx
		pop esi
	}
}


int countDivided4Not8Asm3(int ar[], int L) {
	__asm
	{
		push esi
		push ecx

		mov esi, ar
		mov ecx, L
		xor eax, eax
		sub esi, 4

	L1:
		add esi, 4
		test dword ptr [esi], 3
		jnz Next

		test dword ptr[esi], 7
		jz Next

		add eax, 1

	Next:
		loop L1

		pop ecx
		pop esi
	}
}

int main() {
	system("chcp 1251");
	int nums[len];
	srand((unsigned)time(NULL));
	for (int i = 0; i < len; ++i)
		nums[i] = rand() % (max - min + 1) + min;
	cout << "Масив:  ";
	for (int i = 0; i < len; ++i) cout << nums[i] << ' ';
	cout << "\n\n";
	int res = countDivided4Not8(nums, len);
	cout << "Брой на елементите кратни на 4 без да са кратни на 8: "
		<< res << "\n\n";
	res = countDivided4Not8Asm(nums, len);
	cout << "Брой на елементите кратни на 4 без да са кратни на 8: "
		<< res << "\n\n";

	res = countDivided4Not8Asm2(nums, len);
	cout << "Брой на елементите кратни на 4 без да са кратни на 8: "
		<< res << "\n\n";

	res = countDivided4Not8Asm3(nums, len);
	cout << "Брой на елементите кратни на 4 без да са кратни на 8: "
		<< res << "\n\n";

	system("pause");
	return 0;
}
