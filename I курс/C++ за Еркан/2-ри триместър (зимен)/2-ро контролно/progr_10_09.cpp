/* ����: progr_10_09.cpp
   ���������� �� ������������ (C++)
   �������� ������� �� ������ 10.9
   ���������: ����� ������
   ���� 2017 ������
*/

#include <iostream> 
using namespace std;
#include <cstring>
const short broyTurP = 4, daljinaNazvanie = 48;
struct TipTurP {
  char nazvanie[daljinaNazvanie + 1];
  short vreme;
  bool ski;
} TurP[broyTurP];
void VhodTurP( TipTurP & tp ) {
  do {
    cout <<  "    ����� �� ���������� (��� 4 ������): ";
    cin >> tp.vreme;
    cin.ignore(1);
  } while ( tp.vreme < 5 );
  do {
    cout << "    �������� �� �������� (�� 5 �� " << daljinaNazvanie << " �����): ";
    cin.getline(tp.nazvanie, daljinaNazvanie + 1);
  } while( strlen(tp.nazvanie) < 5 
           || tp.nazvanie[0] < '�' || '�' < tp.nazvanie[0] );
  char zaSki;
  do {
    cout << "    ��������� �� � �� ��� (0-��; 1-��): ";
    cin >> zaSki;
  } while ( zaSki < '0'  ||  '1' < zaSki );
  tp.ski = '1'==zaSki;
}
void VhodMasiv( TipTurP masiv[], short broy ) {
  cout << "�������� ����� �� " << broy << " ������������ ������:\n";
  for ( short i = 0; i < broy; ++i ) {
    cout << "  " << i + 1 << "-� ������:\n";
    VhodTurP( masiv[i] );
  }
}
TipTurP * UkazatelMaxVremeSki( TipTurP masiv[], short broy ) {
    // ������� � ���������� �� ���������
  TipTurP * uMax = NULL;
  for( TipTurP * u = masiv + broy-1; masiv <= u; --u )
    if(  u->ski && ( ! uMax || uMax->vreme < u->vreme)  )
      uMax = u;
  return uMax;
}
TipTurP * UkazatelMaxVremeSki2( TipTurP masiv[], short broy ) {
    // ������� � ���������� �� �������
  short iMax = -1;
  for( short i=0; i<broy; ++i )
    if(  masiv[i].ski && ( -1==iMax || masiv[iMax].vreme < masiv[i].vreme)  )
      iMax = i;
  if( -1==iMax ) return NULL;
  return & masiv[iMax];
}
void IzhodTurP( const TipTurP & tp ) {
  cout << " ������ " << tp.nazvanie << " �� ����� " << tp.vreme;
  if( tp.ski ) cout << ", ��������� � �� ���.\n";
  else cout << ", ����������� �� ���.\n";
}
int main( ) {
  system( "chcp 1251 >> nul" ); // " >> nul" ������� �� �� �� ������� ����������� �� ������
  VhodMasiv( TurP, broyTurP );
  cout<<"�������� �� ��������� �� ������ �� ��� � ���������� �����:\n";
  TipTurP * rezultat = UkazatelMaxVremeSki( TurP, broyTurP );
  if( rezultat ) IzhodTurP( *rezultat );
  else cout<<"NULL\n";
  rezultat = UkazatelMaxVremeSki2( TurP, broyTurP );
  if( rezultat ) IzhodTurP( *rezultat );
  else cout<<"NULL\n";

  cout << "\n\n";
  system( "pause" );
  return 0;
}
