/* Програмата въвежда 6 реални числа и ги извежда
   в ред, обратен на този при въвеждането.
*/
#include <iostream>
using namespace std;
int main(){
  double ar[6];
  for (short i = 0; i < 6; ++i) {
    cout << "Number " << i + 1 << ": ";
    cin >> ar[i];
  }
  cout << "----------\n";
  for (short i = 5; 0 <= i; --i) cout << ar[i] << " ";
  cout << "\n\n";

  system("pause");
  return 0;
}