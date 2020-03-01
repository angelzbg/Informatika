/* ������� 
�� �� ������ ������ �� ��������� fCpp ����, �� ���������� �� ������� ����������
�� ���� ������, ������� � �� ������������ �� ��������� fAsm,
������ ����� ������� �� �������� � ������� ���������� ���������.   
*/

#include <iostream>
using namespace std;
#include <ctime>
#include <iomanip>
int fAsm(int a[], int L) {
  __asm {
    push esi
      mov esi, L
      lea esi, [esi * 4 - 8]
      add esi, a
      mov eax, [esi + 4]
      cmp esi, a
      jna END
    BEGIN :     bt [esi], 0
                jnc NEXT
                bt [esi], 31
                jc STEP
                  add eax, [esi]
                  jmp NEXT
              STEP :
                  sub eax, [esi]
              NEXT :
            sub esi, 4
            cmp esi, a
            ja BEGIN
    END :
      sub eax, [esi]
    pop esi
  }
}
int fCpp(int a[], int L) {
  return -1;
}
int main() {
  system("chcp 1251");
  const int Len = 15, w = 3; // Len>1
  int ar[Len];
  srand( (unsigned) time(NULL) );
  for(int i=0; i<Len; ++i)
    ar[i] = 3 + 2 * rand() % 5;
  cout << "�����:   ";
  for(int i=0; i<Len; ++i) cout << setw(w) << ar[i];
  cout << "\n�������: ";
  for(int i=0; i<Len; ++i) cout << setw(w) << i;
  cout << "\n\n";
  cout << "��������: " << fAsm(ar,Len) <<"\n\n";
  cout << "��������: " << fCpp(ar,Len) <<"\n\n";
  system("pause");
  return 0;
}
