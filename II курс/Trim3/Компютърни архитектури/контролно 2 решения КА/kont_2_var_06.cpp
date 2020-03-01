/* Задание за второ контроно
   по Компютърни архитектури със специалност Информатика, редовно, II курс
   през 2017-2018 учебна година
   
Да се допише блокът на функцията fAsm, така че резултатът от нейното изпълнение
да бъде същият, какъвто е от изпълнението на функцията fCpp,
когато двете функции се извикват с еднакви фактически параметри.   
*/

#include <iostream>
using namespace std;
#include <ctime>
#include <iomanip>
int fCpp(int a[], int L) {
  int n = a[L-1] - a[L-2];
  for(int i = L-2; 1<=i; --i)
    if( a[i] - a[i-1] < n )
      return i;
  return -1;
}
int fAsm(int a[], int L) {
  
}
int main() {
  system("chcp 1251");
  const int Len = 11;
  int ar[Len];
  srand( (unsigned) time(NULL) );
  for(int i=0; i<Len; ++i)
    ar[i] = rand() % 10;
  cout << "Елементи: ";
  for(int i=0; i<Len; ++i) cout << setw(3) << ar[i];
  cout << endl;
  cout << "Индекси:  ";
  for(int i=0; i<Len; ++i) cout << setw(3) << i;
  cout << "\n\n";
  cout << "Резултат: " << fCpp(ar,Len) <<"\n\n";
  cout << "Резултат: " << fAsm(ar,Len) <<"\n\n";
  system("pause");
  return 0;
}
