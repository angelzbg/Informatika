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
int fCpp(int a1[], int a2[], int L) {
  int sum = 0;
  for(int i = 0; i<L; ++i)
    if( (a1[i] + a2[i]) % 2 != 0  )
      sum += a1[i] - a2[i];
  return sum;
}
int fAsm(int a1[], int a2[], int L) {
  
}
int main() {
  system("chcp 1251");
  const int Len = 6;
  int ar1[Len], ar2[Len];
  srand( (unsigned) time(NULL) );
  for(int i=0; i<Len; ++i) {
	ar1[i] = rand() % 30;
	ar2[i] = rand() % 30;
  }
  cout << "Първи масив: ";
  for(int i=0; i<Len; ++i) cout << setw(3) << ar1[i];
  cout << "\nВтори масив: ";
  for(int i=0; i<Len; ++i) cout << setw(3) << ar2[i];
  cout << "\n\n";
  cout << "Резултат: " << fCpp(ar1, ar2, Len) <<"\n\n";
  cout << "Резултат: " << fAsm(ar1, ar2, Len) <<"\n\n";
  system("pause");
  return 0;
}
