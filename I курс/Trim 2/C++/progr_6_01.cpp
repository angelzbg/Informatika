/* ����: progr_6_01.cpp
   ���������� �� ������������ (C++)
   �������� ������� �� ������ 6.1
   ���������: ����� ������
   �������� 2017 ������
*/

#include <iostream>
using namespace std;
#include <cstring>
int main( ) {
  //char s[] = "abcd";
  const short maxStrLen = 40;
  char s1[maxStrLen + 1], s2[maxStrLen + 1], s3[maxStrLen + 1], * min;

  cout << "String 1 (length<=" << maxStrLen << "): ";
  // �� � ���������� cin >> s1, ������ ���� �� �� ����� ���������
  // cin.getline( s1, maxStrLen + 1, '\n' );
  cin.getline( s1, maxStrLen + 1 );
  cout << "String 2 (length<=" << maxStrLen << "): ";
  cin.getline( s2, maxStrLen + 1 );
  cout << "String 3 (length<=" << maxStrLen << "): ";
  cin.getline( s3, maxStrLen + 1 );

  cout << "String 1: \"" << s1 << "\"\n";
  cout << "String 2: \"" << s2 << "\"\n";
  cout << "String 3: \"" << s3 << "\"\n";
  
  if ( -1 == strcmp( s1, s2 ) ) min = s1;
  else min = s2;
  if ( 1 == strcmp( min, s3 ) ) min = s3;
  cout << "minimum : \"" << min << "\"\n\n\n";

  system( "pause" );
  return 0;
}
