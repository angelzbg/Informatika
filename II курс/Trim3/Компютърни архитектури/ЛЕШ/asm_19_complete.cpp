// ���� asm_19_complete.cpp
#include <iostream>
using namespace std;
#include <ctime>
#include <iomanip>
const int lenAr = 11, minValue = -60, maxValue = 30, width = 4;
void incDec(int a[], int L) {
	for (int i = 0; i < L; ++i)
	if (a[i] % 8 == 0) ++a[i];
	else --a[i];
}
void incDecAsm(int a[], int L) {
	__asm {
		push esi
			mov esi, L
			lea esi, [0 + esi * 4 - 4]
			add esi, a // esi �������� ������ �� ��������� ������� � ������      
		Lab_c : test dword ptr[esi], 7
				jz Lab_8
				// �� �� ���� �� 8
				dec dword ptr[esi]
				jmp Lab_next
			Lab_8 :
		// ���� �� �� 8
		inc dword ptr[esi]
		Lab_next :
				 sub esi, 4
				 cmp esi, a
				 jae Lab_c
				 pop esi
	}
}
void write(int a[], int L) {
	for (int i = 0; i<L; ++i) cout << setw(width) << a[i];
	cout << endl;
}
void copyArray(int s[], int d[], int L) {
	for (int i = 0; i<L; ++i) d[i] = s[i];
}

void incDecAsm2(int a[], int L) {
	__asm
	{
		push esi //�����
		push ecx //�������
		push edi //temp

		mov esi, a
		mov ecx, L
		sub esi, 4

	L1:
		add esi, 4
		mov edi, [esi]
		and edi, 7
		cmp edi, 0
		jg Part2 //��� � ��-����� �� 0, ����� �� �� ���� �� 8 � ������� �� ����� �� ����
		add [esi], 1 //��� �� �� ���� ���������� �� ���
		Part2: //��������� ������� �� Part2
		cmp edi, 0
		je GoLoop //��� � = �� 0, ����� �� ������ �� ��������� �� ���� � ������� ��������
		sub [esi], 1
		GoLoop: loop L1


		pop edi
		pop ecx
		pop esi
	}
}

int main() {
	system("chcp 1251");
	int original[lenAr], copy[lenAr];
	srand((unsigned)time(NULL));
	for (int i = 0; i < lenAr; ++i)
		original[i] = rand() % (maxValue - minValue + 1) + minValue;
	write(original, lenAr);
	cout << endl;

	copyArray(original, copy, lenAr);
	incDec(copy, lenAr);
	write(copy, lenAr);

	copyArray(original, copy, lenAr);
	incDecAsm(copy, lenAr);
	write(copy, lenAr);



	copyArray(original, copy, lenAr);
	incDecAsm2(copy, lenAr);
	write(copy, lenAr);

	system("pause");
	return 0;
}
