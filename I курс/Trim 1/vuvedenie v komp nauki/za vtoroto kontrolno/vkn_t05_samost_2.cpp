/* Задача
   Да се напише програма, която инициализира и извежда масив,
а след това за всеки индекс извежда стойността на елемента
с този индекс и първия и последния индекси, където се среща
елемент със същата стойност.

  Примерен диалог
Array:  9 9 9 3 4 3 5 6 6 5 
Element: 9; Indexes: 0 & 2
Element: 9; Indexes: 0 & 2
Element: 9; Indexes: 0 & 2
Element: 3; Indexes: 3 & 5
Element: 4; Indexes: 4 & 4
Element: 3; Indexes: 3 & 5
Element: 5; Indexes: 6 & 9
Element: 6; Indexes: 7 & 8
Element: 6; Indexes: 7 & 8
Element: 5; Indexes: 6 & 9  
*/
#include <iostream>
using namespace std;
#include <cmath>
int main() {
  long ar[] = { 9, 9, 9, 3, 4, 3, 5, 6, 6, 5 };
  const short len = sizeof(ar) / sizeof(ar[0]);
  cout << "Array:  ";
  for (short i = 0; i < len; ++i) cout << ar[i] << " ";
  cout << "\n";
  for (short i = 0; i < len; ++i) {
    short first = 0, last = len - 1;
    while( ar[first] != ar[i] ) ++first;
    while( ar[last] != ar[i] ) --last;
    cout << "Element: " << ar[i] << "; Indexes: "
         << first << " & " << last << endl;
  }
  cout << "\n\n";

  system("pause");
  return 0;
}
