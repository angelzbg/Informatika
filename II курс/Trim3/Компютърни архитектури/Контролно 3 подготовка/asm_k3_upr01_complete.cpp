/* �������
�� �� ������ ������ �� ��������� fCpp ����, �� ���������� �� ������� ����������
�� ���� ������, ������� � �� ������������ �� ��������� fAsm,
������ ����� ������� �� �������� � ������� ���������� ���������.
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
		Label_start : add eax, [ecx + 8]
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
	int res = -75;
	for (int i = L - 3; 1 <= i; i -= 2)
		res += a[i + 2] + a[i - 1] - 2 * a[i + 1];
	return res;
}

int fCpp2(int a[], int L) {

	int whatever = -75;

	for (int i = 2; i < (L - 2); i += 2)
	{
		whatever += a[i + 2] + a[i - 1] - a[i + 1] * 2;
	}

	return whatever;
}

int main() {
	system("chcp 1251");
	const int Len = 27;
	int ar[Len];
	srand((unsigned)time(NULL));
	for (int i = 0; i<Len; ++i)
		ar[i] = 1 + 2 * rand() % 5;
	cout << "�����: ";
	for (int i = 0; i<Len; ++i) cout << ar[i] << ' ';
	cout << "\n\n";
	cout << "��������: " << fAsm(ar, Len) << "\n\n";
	cout << "��������: " << fCpp(ar, Len) << "\n\n";

	cout << "��������: " << fCpp2(ar, Len) << "\n\n";

	system("pause");
	return 0;
}
