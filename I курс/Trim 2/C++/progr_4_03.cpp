/* Файл: progr_4_03.cpp
   Упражнения по Програмиране (C++)
   Примерно решение на задача 4.3
   Подготвил: Кирил Иванов
   Януари 2017 година
*/

#include <iostream>
using namespace std;
unsigned long long F(
    unsigned long long pred, 
    unsigned long long last,
    int num_last,
    int n
  )
{
  if ( num_last == n ) return last;
  return F( last, pred + last, num_last + 1, n );
}
void Fdown( unsigned long long & pred, unsigned long long & last, int num_last ) 
{
  if ( num_last == 1 ) { pred = 1; last = 0; return; }
  unsigned long long old_pred;
  Fdown( old_pred, pred, num_last - 1 );
  last = pred + old_pred;
}
unsigned long long Fdown2( unsigned long long & pred, int num_last ) {
  if ( num_last == 1 ) { pred = 1; return 0; }
  unsigned long long old_pred;
  pred = Fdown2( old_pred, num_last - 1 );
  return pred + old_pred;
}
int main( ) {
  int n;
  do {
    cout << "Integer n (1<=n<=94): ";
    cin >> n;
  } while ( n < 1 || 94 < n );
  cout << endl;
  // 1-и начин - с масив
  unsigned long long * Fibonacci = new unsigned long long[n+1] { 0, 1 };
  for ( int i = 2; i < n; ++i )
    Fibonacci[i] = Fibonacci[i - 1] + Fibonacci[i - 2];
  cout << "F(" << n << ") = " << Fibonacci[n-1] << "\n\n";
  delete[] Fibonacci;
  Fibonacci = NULL;
  // 2-и начин - без масив, без рекурсия
  unsigned long long pred = 1, last = 0;
  int num_last = 1;
  while ( num_last < n ) {
    unsigned long long old_pred = pred;
    pred = last;
    last = old_pred + last;
    ++num_last;
  }
  cout << "F(" << n << ") = " << last << "\n\n";
  // 3-и начин - с рекурсия по нарастване на номерата
  cout << "F(" << n << ") = " << F( 1, 0, 1, n ) << "\n\n";
  // 4-и начин - с рекурсия по намаляване на номерата,
  //             с тип void на функцията
  Fdown( pred, last, n );
  cout << "F(" << n << ") = " << last << "\n\n";
  // 5-и начин - с рекурсия по намаляване на номерата,
  //             с тип unsigned long long на функцията
  cout << "F(" << n << ") = " << Fdown2( pred, n ) << "\n\n";

  system( "pause" );
  return 0;
}
