/* Програмата инициализира масив, извежда го,
пренарежда го в обратен ред и пак го извежда.
*/
#include <iostream>
using namespace std;
int main(){ 
  long ar[] = { 10, 20, 30, 40, 50 };
  const short len = sizeof(ar) / sizeof(ar[0]);
  for (short i = 0; i < len; ++i)
    cout << "ar[" << i << "] = " << ar[i] << endl;
  cout << "----------\n";
  for (short left = 0, right = len - 1; left < right; ++left, --right) {
    long temp = ar[left];
    ar[left] = ar[right];
    ar[right] = temp;
  }
  for (short i = 0; i < len; ++i)
    cout << "ar[" << i << "] = " << ar[i] << endl;

  system("pause");
  return 0;
}