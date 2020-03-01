/* Задача
   Да се напише програма, която въвежда брой на цели числа
от тип long long, а после и самите числа, и извежда най-голямата
сума на два елемента с различни индекси, които са разположени
симетрично, спрямо средата на масива от въведени числа.
Програмата да извежда и индексите на елементите, чиято сума
е максимална.

  Примерен диалог
len (2<len<11): 5
ar[0]: 1
ar[1]: 1
ar[2]: 529
ar[3]: 7
ar[4]: 6
Maximum Sum: ar[1] + ar[3] = 8
*/
#include <iostream>
using namespace std;
#include <cmath>
int main() {
  short len;
  do {
    cout << "len (2<len<11): ";
    cin >> len;
  } while (len < 3 || 10 < len);
  long long *ar = new long long[len];
  for (int i = 0; i < len; ++i) {
    cout << "ar[" << i << "]: ";
    cin >> ar[i];
  }
  long long maxSum = ar[0] + ar[len - 1];
  int maxL = 0, maxR = len - 1;
  for (int L = 1, R = len - 2; L < R; ++L, --R)
    if (maxSum < ar[L] + ar[R]) {
      maxSum = ar[L] + ar[R];
      maxL = L;
      maxR = R;
    }
  cout << "Maximum Sum: ar[" << maxL << "] + ar["
       << maxR << "] = " << maxSum << "\n\n";
  delete[] ar;
  //ar = NULL;

  system("pause");
  return 0;
}
