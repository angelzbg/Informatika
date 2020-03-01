/* Задача
   Да се напише програма, която инициализира масив,
подрежда го възходящо, след това - низходящо и
го извежда преди и след всяка сортировка.
*/
#include <iostream>
using namespace std;
int main(){
  long ar[] = { 12, 1, 11, 2, 10, 3, 9, 4, 8, 5, 7, 6, 3, 3, 2, 2, 2 };
  short const len = sizeof(ar) / sizeof(ar[0]);
  for (short i = 0; i < len; ++i) cout << ar[i] << " ";
  cout << "\n\n";
  // сортировка възходящо по метода на мехурчето
  for (short pos = len - 1; 0 < pos; --pos) 
    for (short i = 0; i < pos; ++i)
      if (ar[i]>ar[i + 1]) {
        long temp = ar[i];
        ar[i] = ar[i + 1];
        ar[i + 1] = temp;
      }
  for (short i = 0; i < len; ++i) cout << ar[i] << " ";
  cout << "\n\n";
  // сортировка низходящо по метода на пряката селекция
  for (short pos = len - 1; 0 < pos; --pos) {
    short minI = 0;
    for (short i = 1; i <= pos; ++i)
      if (ar[i] < ar[minI]) minI = i;
    long temp = ar[minI];
    ar[minI] = ar[pos];
    ar[pos] = temp;
  }
  for (short i = 0; i < len; ++i) cout << ar[i] << " ";
  cout << "\n\n";

  system("pause");
  return 0;
}