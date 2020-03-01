/* ������� �� ����� ��������
�� ���������� ����������� ��� ����������� �����������, �������, II ����
���� 2017-2018 ������ ������

�� �� ������ ������ �� ��������� fAsm, ���� �� ���������� �� ������� ����������
�� ���� ������, ������� � �� ������������ �� ��������� fCpp,
������ ����� ������� �� �������� � ������� ���������� ���������.
*/

#include <iostream>
using namespace std;
#include <ctime>
int fCpp(int a[], int L) {
  int n = 0;
  for (int i1 = 0, i2 = 2; i2<L; ++i1, ++i2)
  if (a[i1] % 2 == 0 && a[i2] < a[i1])
    ++n;
  return n;
}
int fAsm(int a[], int L) {
  __asm {
    // eax == n
    // ecx == i2
    // esi == a
    // edi == a[i1]
    push ecx
    push esi
    push edi
      xor eax, eax
      mov ecx, 1
      mov esi, a
    Lab_c : inc ecx
            cmp ecx, L
            jae Lab_end
              mov edi, [esi + ecx * 4 - 8]
              bt edi, 0
              jc Lab_c
                cmp edi, [esi + ecx * 4]
                jng Lab_c
                  inc eax
            jmp Lab_c
  Lab_end :
    pop edi
    pop esi
    pop ecx
  }
}
int main() {
  system("chcp 1251");
  const int Len = 19;
  int ar[Len];
  srand((unsigned)time(NULL));
  for (int i = 0; i<Len; ++i)
    ar[i] = rand() % 40;
  cout << "�����: ";
  for (int i = 0; i<Len; ++i) cout << ar[i] << ' ';
  cout << "\n\n";
  cout << "��������: " << fCpp(ar, Len) << "\n\n";
  cout << "��������: " << fAsm(ar, Len) << "\n\n";
  system("pause");
  return 0;
}
