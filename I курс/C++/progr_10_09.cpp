/* Файл: progr_10_09.cpp
   Упражнения по Програмиране (C++)
   Примерно решение на задача 10.9
   Подготвил: Кирил Иванов
   Март 2017 година
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
    cout <<  "    време за изминаване (над 4 минути): ";
    cin >> tp.vreme;
    cin.ignore(1);
  } while ( tp.vreme < 5 );
  do {
    cout << "    название на пътеката (от 5 до " << daljinaNazvanie << " знака): ";
    cin.getline(tp.nazvanie, daljinaNazvanie + 1);
  } while( strlen(tp.nazvanie) < 5 
           || tp.nazvanie[0] < 'А' || 'Я' < tp.nazvanie[0] );
  char zaSki;
  do {
    cout << "    подходяща ли е за ски (0-не; 1-да): ";
    cin >> zaSki;
  } while ( zaSki < '0'  ||  '1' < zaSki );
  tp.ski = '1'==zaSki;
}
void VhodMasiv( TipTurP masiv[], short broy ) {
  cout << "Въведете данни за " << broy << " туристически пътеки:\n";
  for ( short i = 0; i < broy; ++i ) {
    cout << "  " << i + 1 << "-а пътека:\n";
    VhodTurP( masiv[i] );
  }
}
TipTurP * UkazatelMaxVremeSki( TipTurP masiv[], short broy ) {
    // вариант с използване на указатели
  TipTurP * uMax = NULL;
  for( TipTurP * u = masiv + broy-1; masiv <= u; --u )
    if(  u->ski && ( ! uMax || uMax->vreme < u->vreme)  )
      uMax = u;
  return uMax;
}
TipTurP * UkazatelMaxVremeSki2( TipTurP masiv[], short broy ) {
    // вариант с използване на индекси
  short iMax = -1;
  for( short i=0; i<broy; ++i )
    if(  masiv[i].ski && ( -1==iMax || masiv[iMax].vreme < masiv[i].vreme)  )
      iMax = i;
  if( -1==iMax ) return NULL;
  return & masiv[iMax];
}
void IzhodTurP( const TipTurP & tp ) {
  cout << " Пътека " << tp.nazvanie << " за време " << tp.vreme;
  if( tp.ski ) cout << ", подходяща и за ски.\n";
  else cout << ", неподходяща за ски.\n";
}
int main( ) {
  system( "chcp 1251 >> nul" ); // " >> nul" изисква да не се извежда съобщението на екрана
  VhodMasiv( TurP, broyTurP );
  cout<<"Резултат от търсенето на пътека за ски с максимално време:\n";
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
