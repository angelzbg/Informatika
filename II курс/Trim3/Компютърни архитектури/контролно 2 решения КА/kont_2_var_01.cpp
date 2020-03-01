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
int fCpp(int a[], int L) {
  int min, max = min = a[L-1];
  for(int i = L-2; 1<=i; i-=2) {
    if( a[i] > max ) max = a[i];
    if( a[i] < min ) min = a[i];
  }
  return max - min;
}
int fAsm(int a[], int L) {
  
}
int main() {
  system("chcp 1251");
  const int Len = 6;
  int ar[Len];
  srand( (unsigned) time(NULL) );
  for(int i=0; i<Len; ++i)
    ar[i] = rand() % 20;
  cout << "Масив: ";
  for(int i=0; i<Len; ++i) cout << ar[i] << ' ';
  cout << "\n\n";
  cout << "Резултат: " << fCpp(ar,Len) <<"\n\n";
  cout << "Резултат: " << fAsm(ar,Len) <<"\n\n";
  system("pause");
  return 0;
}
