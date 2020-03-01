/* ������� 
�� �� ������ ������ �� ��������� fCpp ����, �� ���������� �� ������� ����������
�� ���� ������, ������� � �� ������������ �� ��������� fAsm,
������ ����� ������� �� �������� � ������� ���������� ���������.   
*/

#include <iostream>
using namespace std;
#include <cstring>
char * fAsm(char * s, char c, int n) {
  __asm {
    push ecx
        mov eax, s
        mov ch, c
      LabelC :  cmp byte ptr [eax], 0
                jz Lstop1
                    cmp ch, [eax]
                    jnz Lnext
                      dec n
                  Lnext :
                    cmp n, 1
                    jnge Lstop2
                inc eax
                jmp LabelC
      Lstop1 :
        xor eax, eax
      Lstop2 :
    pop ecx
  }
}
char * fCpp(char * s, char c, int n) {
  while ( *s ) {
    if( *s == c ) --n;
    if( n<1 ) return s;
    ++s;
  }
  return NULL;
}
int main() {
  system("chcp 1251");
  const short maxLen = 60;
  int num;
  cout << "�������� ����: ";
  cin >> num;
  char chr, str[maxLen+1];
  cout << "�������� ����: ";
  cin >> chr;
  cin.ignore();
  cout << "�������� ��� �� " << maxLen <<" �����: ";
  cin.getline(str,maxLen+1);
  char * p = fCpp(str, chr, num);
  if( p ) cout << "��������: \"" << p <<"\"\n\n";
  else cout << "��������: \"\"\n\n";
  p = fAsm(str, chr, num);
  if (p) cout << "��������: \"" << p << "\"\n\n";
  else cout << "��������: \"\"\n\n";
  system("pause");
  return 0;
}
