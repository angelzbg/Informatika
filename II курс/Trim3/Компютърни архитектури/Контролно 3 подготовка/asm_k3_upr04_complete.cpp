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
    push ecx
    push edi
    push esi
      xor eax, eax
      mov ecx, L
      dec L
      xor edi, edi
      mov esi, a
    L_cycle :   add eax, [esi + edi * 4]
                mov edi, [esi + edi * 4]
                and edi, L
              loop L_cycle
    pop esi
    pop edi
    pop ecx
  }
}
unsigned fCpp(unsigned a[], unsigned L) {
  unsigned res=0;
  for(int i=L-1, n=0; 0<=i; --i,  n = a[n] & (L-1))
    res += a[n];
  return res;
}
unsigned main() {
  system("chcp 1251");
  const unsigned Len = 16;
  unsigned ar[Len];
  srand( (unsigned) time(NULL) );
  for(unsigned i=0; i<Len; ++i)
    ar[i] = rand() % 99;
  cout << "�����: ";
  for(unsigned i=0; i<Len; ++i) cout << ar[i] << ' ';
  cout << "\n\n";
  cout << "��������: " << fAsm(ar,Len) <<"\n\n";
  cout << "��������: " << fCpp(ar,Len) <<"\n\n";
  system("pause");
  return 0;
}
