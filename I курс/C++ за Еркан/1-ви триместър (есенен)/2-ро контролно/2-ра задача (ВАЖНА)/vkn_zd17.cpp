/* Задача
   Да се напише програма, която въвежда цели числа, чийто
брой е определен с константа в програмата, на всяко число,
което е по-малко и от двете въведени след него, присвоява
сумата на единица с двете въведени след него, а накрая
извежда така получените числа.
*/
#include <iostream>
using namespace std;
int main(){
  short const len = 6;
  long ar[len];
  cout << "Enter " << len << " integer:\n";
  for (short i = 0; i < len; ++i) {
    cout << "Integer " << i + 1 << ": ";
    cin >> ar[i];
  }
  for (short i = 2; i < len; ++i)
    if (ar[i - 2] < ar[i - 1] && ar[i - 2] < ar[i])
      ar[i - 2] = ar[i - 1] + ar[i] + 1;
  cout << "Result: ";
  for (short i = 0; i < len; ++i) cout << ar[i] << " ";
  cout << "\n\n";

  system("pause");
  return 0;
}