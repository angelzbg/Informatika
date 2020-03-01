/* Задача
   Да се напише програма, която въвежда цели числа, чийто брой
е определен от константа, и извежда на един ред всички въведени числа,
броя на нечетните от тях и, ако има нечетни, максималното нечетно.

  Примерен диалог
Enter 5 integers:
ar[0]: 2
ar[1]: 2
ar[2]: 4
ar[3]: 4
ar[4]: 4
2 2 4 4 4 
Number of odd: 0 

  Примерен диалог
Enter 5 integers:
ar[0]: 9
ar[1]: -1
ar[2]: 77
ar[3]: 3
ar[4]: -55
9 -1 77 3 -55 
Number of odd: 5
Maximum: 77 
*/
#include <iostream>
using namespace std;
#include <cmath>
int main() {
  short const len = 5;
  int ar[len];
  cout << "Enter " << len << " integers:\n";
  for (int i = 0; i < len; ++i) {
    cout << "ar[" << i << "]: ";
    cin >> ar[i];
  }
  for (int i = 0; i < len; ++i) cout << ar[i] << " ";
  cout << endl;
  short count = 0;
  int max;
  for (int i = 0; i < len; ++i)
    if (ar[i] % 2 != 0) {
      ++count;
      if (count == 1 || max < ar[i]) max = ar[i];
    }
  cout << "Number of odd: " << count << endl;
  if (0 < count) cout << "Maximum: " << max << endl;

  system("pause");
  return 0;
}
