/* ����: progr_6_03.cpp
   ���������� �� ������������ (C++)
   �������� ������� �� ������ 6.3
   ���������: ����� ������
   �������� 2017 ������
*/

#include <iostream>
using namespace std;
#include <cstring>
int main( ) {
  const short maxStrLen = 30;
  char str[maxStrLen + 1], ch1, ch2;
  cout << "String (length<=" << maxStrLen << "): ";
  cin.getline( str, maxStrLen + 1, '#' );
  cout << "First character: ";
  cin >> ch1;
  cout << "Second character: ";
  cin >> ch2;
  cout << "String: \"" << str << "\"\n";
  cout << "First character: \'" << ch1 << "\'\n";
  cout << "Second character: \'" << ch2 << "\'\n";
  /*
  // 1-� ����� (��������� �� ���� ���� �������)
  for ( short i = 0; str[i] != 0; ++i )
    if ( str[i] == ch1 ) str[i] = ch2;
  cout << "Result: \"" << str << "\"\n";
  */
  /*
  // 2-� ����� (��������� �� ���� ���� ��������)
  for ( char *s = str; *s != 0; ++s )
    if ( *s == ch1 ) *s = ch2;
  cout << "Result: \"" << str << "\"\n";
  */
  
  // 3-� ����� (� ������ �� ����� ������� �� ���� � ���)
  char * adrCh = strchr( str, ch1 );
  while ( adrCh ) {
    *adrCh = ch2;
    adrCh = strchr( adrCh + 1, ch1 );
  }
  cout << "Result: \"" << str << "\"\n";
  
  /*
  // 4-� ����� (���� ���� ������ �����, �� ������� � for)
  for ( char * adrCh = strchr( str, ch1 );
        adrCh;
        adrCh = strchr( adrCh + 1, ch1 )
      ) *adrCh = ch2;
  cout << "Result: \"" << str << "\"\n";
  */

  cout << "\n\n";
  system( "pause" );
  return 0;
}
