/* Файл: progr_10_10.cpp
   Упражнения по Програмиране (C++)
   Примерно решение на задача 10.10
   Подготвил: Кирил Иванов
   Март 2017 година
*/

#include <iostream> 
using namespace std;
#include <cstring>
const double distancia = 5.0;
const short broyUchstnici = 7, daljinaImena = 80;
struct TUchstnik {
  char imena[daljinaImena + 1];
  double vreme;
  int regNomer;
} uchastnici[broyUchstnici];
double SrednaSkorost( const TUchstnik & u ) { return distancia / u.vreme; }
bool GlavnaBukva( char ch ) { //връща true, точно когато ch е главна буква на кирилица
  return 'А'<=ch && ch<='Я';
}
bool PravilniImena( const char * s ) {
  if(    strlen(s) < 5 //няма достатъчно знакове
    || ! GlavnaBukva(s[0]) //не започва с главна буква
    || ! GlavnaBukva(s[strlen(s)-1]) //не завършва с главна буква
    || ! (s = strchr(s,' ')) //няма нито един интервал (в s се запомня адресът му)
    )
    return false;
  return       GlavnaBukva(*(s+1)) //след 1-я интервал има главна буква
            && (s = strchr(s+1,' ')) //има втори интервал
            && GlavnaBukva(*(s+1)) //след 2-я интервал има главна буква
            && ! strchr(s+1,' '); //няма 3-и интервал
}
void VhodUchastnik( TUchstnik & u ) {
  do {
    cout <<  "    номер на участника: ";
    cin >> u.regNomer;
  } while ( u.regNomer < 0 );
  do {
    cout<<  "    време (часове минути секунди): ";
    double c,m,s;
    cin >> c >> m >> s;
    u.vreme = c + m/60.0 + s/3600.0;
  } while ( u.vreme <= 0.0 );
  cin.ignore(1);
  do {
    cout << "    имена на участника: ";
    cin.getline(u.imena, daljinaImena + 1);
  } while( ! PravilniImena(u.imena) );
}
void VhodMasiv( TUchstnik masiv[], short broy ) {
  cout << "Въведете данни за " << broy << " участници:\n";
  for ( short i = 0; i < broy; ++i ) {
    cout << "  " << i + 1 << "-и участник:\n";
    VhodUchastnik( masiv[i] );
  }
}
char * UkazatelImenaMaxSkorost( TUchstnik masiv[], short broy ) {
  double max = SrednaSkorost(masiv[0]);
  char * adr = masiv[0].imena;
  for( short i=1; i<broy; ++i )
    if( max < SrednaSkorost(masiv[i]) ) {
      max = SrednaSkorost(masiv[i]);
      adr = masiv[i].imena;
    }
    return adr;
}
int main( ) {
  system( "chcp 1251 >> nul" ); // " >> nul" изисква да не се извежда съобщението на екрана
  VhodMasiv( uchastnici, broyUchstnici );
  cout << "Имена на участник с най-висока средна скорост:\n"
       << UkazatelImenaMaxSkorost(uchastnici,broyUchstnici);

  cout << "\n\n";
  system( "pause" );
  return 0;
}
