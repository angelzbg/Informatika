/* ����: progr_10_08.cpp
   ���������� �� ������������ (C++)
   �������� ������� �� ������ 10.8
   ���������: ����� ������
   ���� 2017 ������
*/

#include <iostream> 
using namespace std;
#include <cstring>
const short broyProdukti = 6, daljinaNazvanie = 40, daljinaVid = 9;
const char vidove[][daljinaVid+1] =
                { "������",
                  "���������",
                  "�����",
                  "������"
                };
const short broyVidove = sizeof(vidove) / sizeof(vidove[0]);
struct TProdukt {
  char nazvanie[daljinaNazvanie + 1];
  double kolichestvo;
  short indeksVid;
} produkti[broyProdukti];
void VhodProdukt( TProdukt & p ) {
  do {
    cout<<  "    ���������� �� ��������: ";
    cin >> p.kolichestvo;
    cin.ignore(1);
  } while ( p.kolichestvo <= 0.0 );
  cout << "    �������� �� �������� (�� " << daljinaNazvanie << " �����): ";
  cin.getline(p.nazvanie, daljinaNazvanie + 1);
  do {
    cout<<  "    �������� (";
    for(short i=0; i<broyVidove; ++i) cout << i << '-' << vidove[i] << "  ";
    cout << "): ";
    cin >> p.indeksVid;
  } while( p.indeksVid < 0  ||  broyVidove <= p.indeksVid );
}
void VhodMasiv( TProdukt masiv[], short broy ) {
  cout << "�������� ����� �� " << broy << " ��������:\n";
  for ( short i = 0; i < broy; ++i ) {
    cout << "  " << i + 1 << "-� �������:\n";
    VhodProdukt( masiv[i] );
  }
}
TProdukt ProduktMaxKolichestvo( TProdukt masiv[], short broy ) {
  short maxInd = 0;
  for( short i=1; i<broy; ++i ) 
    if( masiv[maxInd].kolichestvo < masiv[i].kolichestvo ) maxInd = i;
  return masiv[maxInd];
}
void IzhodProdukt( const TProdukt & p ) {
  cout << " ������� " << p.nazvanie << " � �������� �� " << vidove[p.indeksVid]
       << " (����������: " << p.kolichestvo << ").\n";
}
int main( ) {
  system( "chcp 1251 >> nul" ); // " >> nul" ������� �� �� �� ������� ����������� �� ������
  VhodMasiv( produkti, broyProdukti );
  cout << "������� � ���������� ����������:\n";
  IzhodProdukt(  ProduktMaxKolichestvo(produkti, broyProdukti)  );

  cout << "\n\n";
  system( "pause" );
  return 0;
}
