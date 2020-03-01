/* Задача
   Да се инициализират два възходящо сортирани масива,
да обединят в трети сортиран масив, съдържащ точно
елементите на двата, и да се изведат трите масива.
*/
#include <iostream>
using namespace std;
int main(){
  int ar1[] = { 1, 2, 2, 3, 3, 3, 4, 5, 8, 10 },
      ar2[] = { 0, 2, 3, 4, 4, 6, 9, 15, 20 };
  const short len1 = sizeof(ar1) / sizeof(ar1[0]),
              len2 = sizeof(ar2) / sizeof(ar2[0]);
  int res[len1 + len2];
  short i1 = 0, i2 = 0, ires = 0;
  while (i1<len1 && i2<len2)
    if (ar1[i1] < ar2[i2]) res[ires++] = ar1[i1++];
    else res[ires++] = ar2[i2++];
  while (i1<len1) res[ires++] = ar1[i1++];
  while (i2<len2) res[ires++] = ar2[i2++];
  for (short i = 0; i < len1; ++i) cout << ar1[i] << " ";
  cout << "\n\n";
  for (short i = 0; i < len2; ++i) cout << ar2[i] << " ";
  cout << "\n\n";
  for (short i = 0; i < ires; ++i) cout << res[i] << " ";
  cout << "\n\n";

  system("pause");
  return 0;
}