/* Задача
   Да се инициализрат два масива и да се изведат всички
елементи на първия масив, които се срещат във втория.
Да се направят две извеждания:
   1. Елементите да се изведат толкова пъти, колкото
      се срещат в 1-я масив.
   2. Равните елементи да се изведат само по веднъж.
*/
#include <iostream>
using namespace std;
int main(){
  short ar1[] = { 1, 2, 3, 4, 5, 6, 7, 2, 3, 20, 3, 2, 40, 6 },
        ar2[] = { 2, 4, 6, 4, 6 };
  const short len1 = sizeof(ar1) / sizeof(ar1[0]),
              len2 = sizeof(ar2) / sizeof(ar2[0]);
  for (short i = 0; i < len1; ++i) cout << ar1[i] << " ";
  cout << endl;
  for (short i = 0; i < len2; ++i) cout << ar2[i] << " ";
  cout << "\n\n";
  // извеждане на всеки елемент от ar1, който се среща в ar2
  cout << "Inside the first and outside the second: ";
  for (short i1 = 0; i1 < len1; ++i1) {
    short i2 = 0;
    while (i2 < len2)
      if(ar1[i1] != ar2[i2]) ++i2;
      else break;
    if (i2 < len2) cout << ar1[i1] << " ";
  }
  cout << "\n\n";
  // извеждане на различните елементи от ar1, който се среща в ar2
  cout << "Inside the first and outside the second: ";
  for (short i1 = 0; i1 < len1; ++i1) {
    // търсим в ar2 само елементи на ar1,
    // които не се срещат по-нататък в ar1,
    // т. е. при последното им срещане в ar1
    short i = len1 - 1;
    while (ar1[i1] != ar1[i]) --i;
    if (i1==i)
    {
      short i2 = 0;
      while (i2 < len2 && ar1[i1] != ar2[i2]) ++i2;
      if (i2 < len2) cout << ar1[i1] << " ";
    }
  }
  cout << "\n\n";

  system("pause");
  return 0;
}