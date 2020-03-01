/* Файл: progr_10_08.cpp
   Упражнения по Програмиране (C++)
   Примерно решение на задача 10.8
   Подготвил: Кирил Иванов
   Март 2017 година
*/

#include <iostream> 
using namespace std;
#include <cstring>
const short broyProdukti = 6, daljinaNazvanie = 40, daljinaVid = 9;
const char vidove[][daljinaVid+1] =
                { "стъкло",
                  "пластмаса",
                  "метал",
                  "картон"
                };
const short broyVidove = sizeof(vidove) / sizeof(vidove[0]);
struct TProdukt {
  char nazvanie[daljinaNazvanie + 1];
  double kolichestvo;
  short indeksVid;
} produkti[broyProdukti];
void VhodProdukt( TProdukt & p ) {
  do {
    cout<<  "    количество на продукта: ";
    cin >> p.kolichestvo;
    cin.ignore(1);
  } while ( p.kolichestvo <= 0.0 );
  cout << "    название на продукта (до " << daljinaNazvanie << " знака): ";
  cin.getline(p.nazvanie, daljinaNazvanie + 1);
  do {
    cout<<  "    материал (";
    for(short i=0; i<broyVidove; ++i) cout << i << '-' << vidove[i] << "  ";
    cout << "): ";
    cin >> p.indeksVid;
  } while( p.indeksVid < 0  ||  broyVidove <= p.indeksVid );
}
void VhodMasiv( TProdukt masiv[], short broy ) {
  cout << "Въведете данни за " << broy << " продукта:\n";
  for ( short i = 0; i < broy; ++i ) {
    cout << "  " << i + 1 << "-и продукт:\n";
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
  cout << " Продукт " << p.nazvanie << " в опаковка от " << vidove[p.indeksVid]
       << " (количество: " << p.kolichestvo << ").\n";
}
int main( ) {
  system( "chcp 1251 >> nul" ); // " >> nul" изисква да не се извежда съобщението на екрана
  VhodMasiv( produkti, broyProdukti );
  cout << "Продукт с максимално количество:\n";
  IzhodProdukt(  ProduktMaxKolichestvo(produkti, broyProdukti)  );

  cout << "\n\n";
  system( "pause" );
  return 0;
}
