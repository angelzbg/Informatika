/* Файл: progr_6_07.cpp
   Упражнения по Програмиране (C++)
   Примерно решение на задача 6.7
   Подготвил: Кирил Иванов
   Февруари 2017 година
*/

#include <iostream>
using namespace std;
#include <cstring>
int main() {
  const short maxStrLen = 33;
  char str[maxStrLen + 1], sub[maxStrLen + 1];
  cout<<"String (length<="<<maxStrLen<<"): ";
  cin.getline(str,maxStrLen+1);
  cout<<"Substring (length<="<<maxStrLen<<"): ";
  cin.getline(sub,maxStrLen+1);
  short n;
  cout<<"Number: ";
  cin>>n;
  char *pos=strstr(str,sub);
  while(pos && 1<n) {
    --n;
    pos = strstr(pos+1,sub);
  }
  if( 1<n || ! pos ) cout<<"Result: -1\n\n\n";
  else cout<<"Result: "<< pos-str <<"\n\n\n";

  system( "pause" );
  return 0;
}
