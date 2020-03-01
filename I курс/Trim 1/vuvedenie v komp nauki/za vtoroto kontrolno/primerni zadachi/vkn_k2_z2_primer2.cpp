/* Задача
   Да се въведе масив с елементи от тип long long,
като броят им се прочете по време на изпълнение
и се контролира да бъде между 5 и 15 включително.
   Да се изведе или последният елемент, който завършва 
с цифра, по-голяма от последната цифра на втория елемент,
или съобщение, че няма елемент, който завършва така.

   Пример за диалог при изпълнение на програмата:
len (4<len<16): 6
ar[0]: 98
ar[1]: -67
ar[2]: -234
ar[3]: -55
ar[4]: 5
ar[5]: 77
Element: 98
*/
// Примерно решение
#include <iostream>
using namespace std;
#include <cmath>
int main() {
  short len;
  do {
    cout<<"len (4<len<16): ";
    cin>>len;
  } while(len<5 || 15<len);

  long long *ar = new long long[len];
  for(short i=0;i<len;++i) {
    cout<<"ar["<<i<<"]: ";
    cin>>ar[i];
  }
  short i=len-1;
  while( 0 <= i  &&  abs(ar[i]%10) <= abs(ar[1]%10) ) --i;
  if(0<=i) cout<<"Element: "<<ar[i]<<"\n\n";
  else cout<<"No element.\n\n";
  delete[] ar;
  //ar=NULL;

  //system("pause");
  return 0;
}
