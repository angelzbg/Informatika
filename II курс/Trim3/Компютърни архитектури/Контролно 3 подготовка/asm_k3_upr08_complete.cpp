/* ������� 
�� �� ������ ������ �� ��������� fCpp ����, �� ���������� �� ������� ����������
�� ���� ������, ������� � �� ������������ �� ��������� fAsm,
������ ����� ������� �� �������� � ������� ���������� ���������.   
*/

#include <iostream>
using namespace std;
int fAsm(int n) {
  __asm {
    push ecx
    push esi
        xor eax, eax
        mov ecx, 31
      L_start :     mov esi, 3
                    and esi, n
                    cmp esi, 3
                    jne L_next
                      inc eax
                  L_next :
                    shr n, 1
                loop L_start
    pop esi
    pop ecx
  }
}
int fCpp(int n) {
  int res=0;
  for(int i=31; 0<i; --i) {
    res += (n&3) == 3;
    n >>= 1;
  }
  return res;
}
int main() {
  system("chcp 1251");
  int num;
  cout << "�������� ���� �����: ";
  cin >> num;
  cout << "\n\n";
  cout << "��������: " << fAsm(num) <<"\n\n";
  cout << "��������: " << fCpp(num) <<"\n\n";
  system("pause");
  return 0;
}
