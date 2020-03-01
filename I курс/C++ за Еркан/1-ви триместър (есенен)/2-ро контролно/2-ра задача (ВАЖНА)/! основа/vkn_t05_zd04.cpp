/* Програмата създава масив с брой на елементите, избран
чрез диалог, въвежда го и извежда всички двойки елементи,
разположени симетрично спрямо средата на масива.
*/
#include <iostream>
using namespace std;
int main(){
  short len;
  do {
    cout << "Number of the elements (from 1 to 10): ";
    cin >> len;
  } while (len < 1 || 10 < len);
  int *ar = new int[len];
  for (short i = 0; i < len; ++i) {
    cout << "Element " << i + 1 << ": ";
    cin >> ar[i];
  }
  for (int L = 0, R = len-1; L <= R; ++L, --R)
    cout << ar[L] << " <--> " << ar[R] << endl;
  delete[] ar;

  system("pause");
  return 0;
}