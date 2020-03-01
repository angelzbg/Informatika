/* Задача
   Да се напише програма, която въвежда брой на цели числа,
а след това и самите числа, и извежда онези числа, които
делят сумата на всички въведени след тях числа
заедно със самата сума.
*/
include <iostream>
using namespace std;
int main(){
  short len;
  do {
    cout << "len (1<len<11): ";
    cin >> len;
  } while (len < 2 || 10 < len);
  long long *ar = new long long[len];

  for (short i = 0; i < len; ++i) {
    cout << "ar[" << i << "]: ";
    cin >> ar[i];
  }

  cout << "Result:\n";
  long long sum = ar[len - 1];
  for (short i = len - 2; 0 <= i; --i) {
    if (sum % ar[i] == 0)
      cout << sum << " % " << ar[i] << " = 0\n";
    sum += ar[i];
  }

  delete[] ar;
  //ar = NULL;

  system("pause");
  return 0;
}