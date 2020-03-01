/* ����: progr_10_07.cpp
   ���������� �� ������������ (C++)
   �������� ������� �� ������ 10.7
   ���������: ����� ������
   ���� 2017 ������
*/

#include <iostream>
using namespace std;
const short broyZnakove = 9, daljinaNiz = 60, daljinaShTekst = 20;
struct TZnak {
  char znak, niz[daljinaNiz + 1];
};
bool PravilenNiz( const char * s ) {
  for ( ; *s != 0; ++s )
    if ( (*s < '0' || '9' < *s) && (*s < '�' || '�' < *s) ) // �� � ���� �����, ���� �����
      return false;
  return true;
}
void VhodZnak( TZnak & z ) {
  do {
    cout << "    ���� (� ��� �� 33 �� 126) � ��������� ��� (��� ���������): ";
    cin >> z.znak >> z.niz;
    cin.ignore(1);
  } while ( z.znak < 33 || 126 < z.znak || ! PravilenNiz(z.niz) );
}
void VhodMasiv( TZnak masiv[], short broy ) {
  cout << "�������� ����� �� " << broy << " ��������� �����:\n";
  for ( short i = 0; i < broy; ++i ) {
    cout << "  " << i + 1 << "-� ����:\n";
    VhodZnak( masiv[i] );
  }
}
void IzhodNiz( const TZnak masiv[], short broy, char shz ) {
  short i = 0;
  while ( i < broy && masiv[i].znak != shz )
    ++i;
  if ( i < broy ) cout << masiv[i].niz << ' ';
  else cout << shz << ' ';
}
void IzhodTekst( TZnak masiv[], short broy, char * tekst ) {
  cout << "���������� �����:\n";
  for ( ; *tekst != 0; ++tekst ) IzhodNiz( masiv, broy, *tekst );
  cout << "\n���� �� ������.\n";
}
int main( ) {
  system( "chcp 1251 >> nul" ); // " >> nul" ������� �� �� �� ������� ����������� �� ������
  TZnak rechnik[broyZnakove];
  VhodMasiv( rechnik, broyZnakove );
  cout << "�������� �������� ��� �� " << daljinaShTekst <<" �����: ";
  char shTekst[daljinaShTekst + 1];
  cin.getline( shTekst, daljinaShTekst + 1 );
  IzhodTekst( rechnik, broyZnakove, shTekst );

  cout << "\n\n";
  system( "pause" );
  return 0;
}

