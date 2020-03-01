/* ���������� ������� ���������� ����� n �� 10 �� 1000 �:
1. ������� ������� n ������ �����.
2. ��������� ��������� �� �������� �� ������� ��� ������ �����, 
   ����� �� ������� �������.
3. ������� n-�� ������ ����� ������ ���������� ��� ������� �������.
4. ������ ������ ������, ����� �� ����� �� j^k+2 �� ��������� j.
5. ������ ������ ������, ����� �� ����� �� f^k+h �� ��������� f � h,
   ���� h ���� �� ���� �����������.
   (������ �������� 5 ������ �� �� �������� unsigned.)
*/
#include <iostream>
using namespace std;
#include <iomanip>
int main(){
  short n;
  do {
    cout << "n (10<=n<=1000): ";
    cin >> n;
  } while (n < 10 || 1000 < n);

  // 1-� ����� �� �������� �� ������ �����, ��� sqrt(next)
  long *simp = new long[n]
                        { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 };
  short indx = 10; // ���� �� ���� ���������� � simp ������ �����
  long next = 31;
  while (indx < n) {
    // ������ ������� �� next �� simp[0] �� simp[indx-1]
    // ! �� ����� ���� ��� ���������
    short i = 0;
    while (i<indx) 
      if (next % simp[i]) ++i;
      else break;
    if (i == indx) simp[indx++] = next;
    next += 2;
  }
  for (short i = 0; i < n; ++i) cout << setw(5) << simp[i];
  cout << "\n\n--------\n\n";
  delete[] simp;
  //simp = NULL;

  // 2-� ����� �� �������� �� ������ �����, � ���������� �� sqrt(next)
  simp = new long[n]
         { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 };
  indx = 10; // ���� �� ���� ���������� � simp ������ �����
  next = 31;
  while (indx < n) {
    // ������ ������� �� next �� simp[0] �� simp[indx-1]
    // ! �� ����� ���� ��� ���������
    short i = 0;
    long sq = (long)(sqrt(next));
    while ( simp[i] <= sq )
      if (next % simp[i]) ++i;
      else break;
    if ( next % simp[i] ) simp[indx++] = next;
    //if ( simp[i] > sq ) simp[indx++] = next;
    next += 2;
  }
  for (short i = 0; i < n; ++i) cout << setw(5) << simp[i];
  cout << "\n\n--------\n\n";

  // �������� �� ������� ������ ������� ������� ������ �����
  // ! �����, �� ��� ��������� ������
  short pos = 1;
  while (simp[pos] + 2 != simp[pos + 1]) ++pos;
  cout << "First two simples: " << simp[pos] << " <-> "
    << simp[pos + 1] << "; Numbyr by order: "
    << pos + 1 << " <-> " << pos + 2 << endl;
  cout << "\n\n--------\n\n";

  // �������� �� �������� ������ ������� ������� ������ �����
  // ! �����, �� ��� ��������� ������
  pos = n-1;
  while (simp[pos - 1] + 2 != simp[pos]) --pos;
  cout << "First two simples: " << simp[pos - 1] << " <-> "
    << simp[pos] << "; Numbyr by order: "
    << pos << " <-> " << pos + 1 << endl;
  cout << "\n\n--------\n\n";

  // �������� �� ������ ������ �����, ����� �� j^k+2
  const short j = 3;
  short k = 0;
  long power = 1;
  indx = 0;
  while (power + 2 <= simp[n - 1]) {
    while (simp[indx] < power + 2) ++indx;
    if (power+2 == simp[indx])
      cout << j << "^" << k << "+2 = " << power << "+2 = "
           << power + 2 << " = simp[" << indx << "] = "
           << simp[indx] << endl;
    power *= j;
    ++k;
  }
  cout << "\n\n--------\n\n";

  // �������� �� ������ ������ �����, ����� �� f^k+h
  const short f = 2, h = -15;
  k = 0;
  power = 1;
  indx = 0;
  while (power + h <= simp[n - 1]) {
    while (simp[indx] < power + h) ++indx;
    if (power + h == simp[indx])
      cout << f << "^" << k << "+" 
           << h << " = " << power << "+2 = " 
           << power + 2 << " = simp[" << indx << "] = "
           << simp[indx] << endl;
    power *= f;
    ++k;
  }
  cout << "\n\n--------\n\n";

  delete[] simp;
  //simp = NULL;

  system("pause");
  return 0;
}