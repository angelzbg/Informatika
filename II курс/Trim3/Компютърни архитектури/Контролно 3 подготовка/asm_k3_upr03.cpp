/* ������� 
�� �� ������ ������ �� ��������� fCpp ����, �� ���������� �� ������� ����������
�� ���� ������, ������� � �� ������������ �� ��������� fAsm,
������ ����� ������� �� �������� � ������� ���������� ���������.   
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
    Lab_1 :   mov edi, [esi + ecx * 4 - 4]
              and edi, 15
              add eax, edi
            loop Lab_1
    pop edi
    pop ecx
    pop esi
  }
}
unsigned fCpp(unsigned a[], unsigned L) {
  return 1111;
}
unsigned main() {
  system("chcp 1251");
  const unsigned Len = 17;
  unsigned ar[Len];
  srand( (unsigned) time(NULL) );
  for(unsigned i=0; i<Len; ++i)
    ar[i] = rand() % 32;
  cout << "�����: ";
  for(unsigned i=0; i<Len; ++i) cout << ar[i] << ' ';
  cout << "\n\n";
  cout << "��������: " << fAsm(ar,Len) <<"\n\n";
  cout << "��������: " << fCpp(ar,Len) <<"\n\n";
  system("pause");
  return 0;
}
