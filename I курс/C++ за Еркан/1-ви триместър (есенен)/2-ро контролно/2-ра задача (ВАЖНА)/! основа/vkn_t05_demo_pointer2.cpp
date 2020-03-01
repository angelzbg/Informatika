/* Програмата илюстрира изчисления с указатели.
*/
#include <iostream>
using namespace std;
int main(){
  short len;
  do {
    cout << "Array length (from 1 to 10): ";
    cin >> len;
  } while (len < 1 || 10 < len);
  double *pointer = new double[len];

  for (short i = 0; i < len; ++i)
    *(pointer + i) = i * 10 + 10.5;
    // еквивалентно на pointer[i] = i * 10 + 10.5;

  double *p = pointer + len - 1;
  while (pointer <= p) cout << *p-- << endl;
  p = NULL;

  cout << "----------\n";
  for (double *Lp = pointer, *Rp = pointer + len - 1; Lp <= Rp; ++Lp, --Rp)
    cout << *Lp << " <<-->> " << *Rp << endl;

  delete[] pointer;
  pointer = NULL;

  system("pause");
  return 0;
}