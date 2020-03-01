/* Файл: progr_3_05.cpp
   Упражнения по Програмиране (C++)
   Примерно решение на задача 3.5
   Подготвил: Кирил Иванов
   Януари 2017 година
*/

#include <iostream>
using namespace std;
double * CreateArray( short & len ) {
  do {
    cout << "Number of elements (>1): ";
    cin >> len;
  } while ( len < 2 );
  double * u = new double[len];
  for ( short i = 0; i < len; ++i ) {
    cout << "array[" << i << "]: ";
    cin >> u[i];
  }
  return u;
}
double Maximum( double ar[], short len ) {
  double max = ar[0];
  for ( short i = 1; i < len; ++i )
    if ( max < ar[i] ) max = ar[i];
  return max;
}
short Count( double ar[], short len, double value ) {
  short n = 0;
  for ( short i = 0; i < len; ++i )
    // if ( ar[i] == value ) ++n;
    n += ar[i] == value;
  return n;
}
void Indexes( double ar[], short len, double value ) {
  cout << "Indexes: ";
  for ( short i = 0; i < len; ++i )
    if ( ar[i] == value ) cout << i << ", ";
  cout << endl;
}
int main( ) {
  short length;
  double * array = CreateArray( length );

  double max = Maximum( array, length );
  cout << "Maximum: " << max << endl;
  cout << "Count: " << Count( array, length, max ) << endl;
  Indexes( array, length, max );

  delete[] array;
  array = NULL;

  system( "pause" );
  return 0;
}
