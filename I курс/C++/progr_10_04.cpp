/* Файл: progr_10_04.cpp
   Упражнения по Програмиране (C++)
   Примерно решение на задача 10.4
   Подготвил: Кирил Иванов
   Март 2017 година
*/

#include <iostream>
using namespace std;
const short broyFermi = 8, daljinaFerma = 65, daljinaVid = 25;
struct TFerma {
  char ferma[daljinaFerma + 1], vid[daljinaVid + 1];
  short broy;
};
void VhodFerma( TFerma & f ) {
  do {
    cout << "    брой птици, излюпени за месец: ";
    cin >> f.broy;
  } while ( f.broy <= 0 );
  cin.ignore( 1 );
  do {
    cout << "    название на фермата: ";
    cin.getline( f.ferma, daljinaFerma + 1 );
  } while ( f.ferma[0] < 'А' || 'Я' < f.ferma[0] );
  short i;
  do {
    cout << "    вид на птиците: ";
    cin.getline( f.vid, daljinaVid + 1 );
      i = 0;
      while (    'a' <= f.vid[i] && f.vid[i] <= 'z'
              || 'а' <= f.vid[i] && f.vid[i] <= 'я' )
        ++i; // прескача се знака, докато е малка буква на латиница или кирилица
  } while ( f.vid[i] != 0 );
}
void VhodMasiv( TFerma masiv[], short broy ) {
  cout << "Въведете данни за " << broy << " ферми:\n";
  for ( short i = 0; i < broy; ++i ) {
    cout << "  " << i + 1 << "-а ферма:\n";
    VhodFerma( masiv[i] );
  }
}
short MaxBroy( TFerma masiv[], short broy ) {
  short max = masiv[0].broy;
  for ( short i = 1; i < broy; ++i)
    if ( max < masiv[i].broy ) max = masiv[i].broy;
  return max;
}
void IzhodVidoveMaxBroy( TFerma masiv[], short broy ) {
  cout << "Видове на птиците с максимален брой излюпвани:\n";
  short max = MaxBroy( masiv, broy );
  for ( short i = 0; i < broy; ++i ) 
  if ( max == masiv[i].broy )
    cout << masiv[i].vid << endl;
}
int main( ) {
  system( "chcp 1251" );
  TFerma fermi[broyFermi];
  VhodMasiv( fermi, broyFermi );
  IzhodVidoveMaxBroy( fermi, broyFermi );

  cout << "\n\n";
  system( "pause" );
  return 0;
}

