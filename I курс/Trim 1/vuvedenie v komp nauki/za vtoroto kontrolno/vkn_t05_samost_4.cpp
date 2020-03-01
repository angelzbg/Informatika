/* Задача
   Да се напише програма, която инициализира и извежда 
масив от реални числа, а след това въвежда число и
извежда всички интервали, съдържащи числото, които
имат краища два съседни елемента от масива.
*/
#include <iostream>
using namespace std;
#include <cmath>
int main(){
  double ar[] = { -15.5, -2.5, -3, -6, 1.9, 100.1, 25, 35, 24 };
  const short len = sizeof(ar) / sizeof(ar[0]);
  for (short i = 0; i < len; ++i) cout << ar[i] << " ";
  cout << "\n\n";
  double R;
  cout << "Real number (for example -4 or 30.1): ";
  cin >> R;
  for (short i = 1; i < len; ++i)
	  if (fmin(ar[i - 1], ar[i]) <= R && R <= fmax(ar[i - 1], ar[i]))
      cout << "[ " << fmin(ar[i - 1], ar[i]) << " ; "
           << fmax(ar[i - 1], ar[i]) << " ] contains " << R << endl;
  cout << "\n\n";

  system("pause");
  return 0;
}
