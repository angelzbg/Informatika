/* Задание
Да се допише блокът на функцията fCpp така, че резултатът от нейното изпълнение
да бъде същият, какъвто е от изпълнението на функцията fAsm,
когато двете функции се извикват с еднакви фактически параметри.
*/

#include <iostream>
using namespace std;
#include <ctime>
unsigned fAsm(unsigned a[], unsigned L) {
	__asm {
		push esi
			push ecx
			push edi
			mov esi, a
			mov ecx, L
			xor eax, eax
		Lab_1 : mov edi, [esi + ecx * 4 - 4]
				and edi, 15
				add eax, edi
				loop Lab_1
				pop edi
				pop ecx
				pop esi
	}
}
unsigned fCpp(unsigned a[], unsigned L) {
	unsigned res = 0;
	for (int i = L - 1; 0 <= i; --i)
		res += a[i] % 16;
	return res;
}

unsigned fCpp2(unsigned a[], unsigned L) {
	unsigned result = 0;
	for (int i = 0; i < L; i++)
	{
		result += (a[i] % 16);
	}
	return result;
}

unsigned main() {
	system("chcp 1251");
	const unsigned Len = 17;
	unsigned ar[Len];
	srand((unsigned)time(NULL));
	for (unsigned i = 0; i<Len; ++i)
		ar[i] = rand() % 32;
	cout << "Масив: ";
	for (unsigned i = 0; i<Len; ++i) cout << ar[i] << ' ';
	cout << "\n\n";
	cout << "Резултат: " << fAsm(ar, Len) << "\n\n";
	cout << "Резултат: " << fCpp(ar, Len) << "\n\n";

	cout << "Резултат: " << fCpp2(ar, Len) << "\n\n";

	system("pause");
	return 0;
}
