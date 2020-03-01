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
  __asm {
    // eax - първо max, а после резултат
    // esi - адрес на поредния елемент (обхождане отзад напред)
    // edi - min
    push esi
    push edi
      mov esi, a
      mov eax, L
      lea esi, [esi + eax * 4]
      // вместо горните три команди, може следващите три (те са в коментар)
      //mov esi, L
      //shl esi, 2
      //add esi, a
      mov eax, [esi - 4] // извлича посления елемент
      mov edi, eax
    Lab_c : sub esi, 8 // прескача един елемент
        cmp esi, a
        jna Lab_end // преход, когато esi е адрес преди 2-я елемент
          cmp eax, [esi]
          jge Lab_step
            mov eax, [esi] // нов максимум
          Lab_step :
          cmp edi, [esi]
          jng Lab_c
            mov edi, [esi] // нов минимум
        jmp Lab_c
    Lab_end :
      sub eax, edi
    pop edi
    pop esi
  }
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
