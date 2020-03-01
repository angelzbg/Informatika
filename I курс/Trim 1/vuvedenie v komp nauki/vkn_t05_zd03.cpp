/* Програмата инициализира два масива и получава трети,
съдържащ точно елементите от другите два в ред:
1-и елемент от 1-и масив;
1-и ел-т от 2-и масив;
2-и ел-т от 1-и масив;
2-и ел-т от 2-и масив
и т. н.,
а накрая останалите елементи от по-дългия масив.
   Трите масива се извеждат на по един ред.
*/
#include <iostream>
using namespace std;
int main(){
  int ar1[] = { -1, -2, -3 },
      ar2[] = { 10, 20, 30, 40, 50, 60 };
  const short len1 = sizeof(ar1) / sizeof(ar1[0]),
              len2 = sizeof(ar2) / sizeof(ar2[0]);
  for each(int elm in ar1) cout << elm << " ";
    // горният цикъл работи с масиви само в MS V Studio
  cout << endl;
  for (short i = 0; i < len2; ++i) cout << ar2[i] << " ";
  cout << endl;
  int res[len1 + len2];
  short indx = 0; // брой на елементите, поставени в res
  for (short i = 0; i < len1&&i < len2; ++i) {
    res[indx++] = ar1[i];
    res[indx++] = ar2[i];
  }
  for (short i = indx / 2; i < len1; ++i) res[indx++] = ar1[i];
  for (short i = indx / 2; i < len2; ++i) res[indx++] = ar2[i];
  for (short i = 0; i < indx; ++i) cout << res[i] << " ";
  cout << endl;

  system("pause");
  return 0;
}