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
  int sum = 0;
  for(int i = L-1; 1<=i; --i)
    if( a[i] % 2 != 0  &&  a[i-1] < a[i] )
      sum += a[i] - a[i-1];
  return sum;
}
int fAsm(int a[], int L) {
  
}
int main() {
  system("chcp 1251");
  const int Len = 12;
  int ar[Len];
  srand( (unsigned) time(NULL) );
  for(int i=0; i<Len; ++i)
    ar[i] = rand() % 40;
  cout << "�����: ";
  for(int i=0; i<Len; ++i) cout << ar[i] << ' ';
  cout << "\n\n";
  cout << "��������: " << fCpp(ar,Len) <<"\n\n";
  cout << "��������: " << fAsm(ar,Len) <<"\n\n";
  system("pause");
  return 0;
}
