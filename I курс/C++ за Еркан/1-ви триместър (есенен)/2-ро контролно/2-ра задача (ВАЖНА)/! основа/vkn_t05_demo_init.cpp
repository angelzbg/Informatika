/* Програма илюстрира инициализации на масиви.
*/
#include <iostream>
using namespace std;
const short len = 5;
long ar1[len];
int main(){
  cout << "ar1: ";
  for (short i = 0; i < len; ++i) cout << ar1[i] << " ";
  cout << endl;
  
  long ar2[len];
  cout << "ar2: ";
  for (short i = 0; i < len; ++i) cout << ar2[i] << " ";
  cout << endl;

  long ar3[len] = { 1, 2 };
  cout << "ar3: ";
  for (short i = 0; i < len; ++i) cout << ar3[i] << " ";
  cout << endl;

  long ar4[] = { 1, 2, 3 };
  cout << "ar4: ";
  for (short i = 0; i < sizeof(ar4)/sizeof(ar4[0]); ++i)
    cout << ar4[i] << " ";
  cout << endl;

  long *p = new long[len];
  cout << "first *p: ";
  for (short i = 0; i < len; ++i) cout << p[i] << " ";
  cout << endl;
  delete[] p;

  p = new long[len]{1, 2, 3};
  cout << "second *p: ";
  for (short i = 0; i < len; ++i) cout << p[i] << " ";
  cout << endl;
  delete[] p;

  system("pause");
  return 0;
}