/* Файл: progr_3_04.cpp
   Упражнения по Програмиране (C++)
   Примерно решение на задача 3.4
   Подготвил: Кирил Иванов
   Януари 2017 година
*/

#include <iostream>
using namespace std;
void WriteArray( long ar[], short length ) {
  // cout << "sizeof(ar) = " << sizeof(ar) << endl; // за пояснения на 2-я параметър
  for ( short i = 0; i < length; ++i ) cout << ar[i] << " ";
  cout << endl;
}
void WriteArray2( long * ar, short length ) {
  for ( short i = 0; i < length; ++i ) cout << ar[i] << " ";
  cout << endl;
}
void Invert( long ar[], short len ) {
  for ( short L = 0, R = len - 1; L < R; ++L, --R ) {
    long temp = ar[L];
    ar[L] = ar[R];
    ar[R] = temp;
  }
}
int main( ) {
  long array[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
  // cout << "sizeof(array) = " << sizeof(array) << endl; // за припомняне на sizeof
  const short len = sizeof(array) / sizeof(array[0]);
  WriteArray( array, len );
  Invert( array, len );
  WriteArray2( array, len );

  system( "pause" );
  return 0;
}
