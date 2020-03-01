/* Задача
   Да се напише програма, която инициализира и извежда 
масив, а след това за всеки индекс извежда самия индекс,
елемента с този индекс и броя на елементите на масива,
които са равни на елемента с този индекс.

  Примерен диалог
Array:  9 9 9 3 4 3 5 6 6 5 
Index: 0; Element: 9; Count: 3
Index: 1; Element: 9; Count: 3
Index: 2; Element: 9; Count: 3
Index: 3; Element: 3; Count: 2
Index: 4; Element: 4; Count: 1
Index: 5; Element: 3; Count: 2
Index: 6; Element: 5; Count: 2
Index: 7; Element: 6; Count: 2
Index: 8; Element: 6; Count: 2
Index: 9; Element: 5; Count: 2  
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
    short count = 0;
    for (short h = 0; h < len; ++h)
      if (ar[i] == ar[h]) ++count;
    cout << "Index: " << i << "; Element: " << ar[i]
         << "; Count: " << count << endl;
  }
  cout << "\n\n";

  system("pause");
  return 0;
}
