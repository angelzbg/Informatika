/* Задача
   Да се напише програма, която:
   1. Инициализира масив от реални числа и го извежда.
   2. Извежда минималния елемент на масива и индекса му.
      (При няколко минимални извежада само един индекс.)
   3. Извежда максималния елемент на масива и индекса му.
      (При няколко максимални извежада само един индекс.)
   4. Извежда броя на максималните елементи и индексите им.
*/
#include <iostream>
using namespace std;
int main(){
  double ar[] = { -1.5, -.0015e+3, 2e2, 2000e-4, 200.0, 200 };
  const short len = sizeof(ar) / sizeof(ar[0]);
  for (short i = 0; i < len; ++i) cout << ar[i] << " ";
  cout << "\n\n";
  // намиране на индекса на минимален елемент
  short minI = 0;
  for (short i = 1; i < len; ++i) if (ar[i] < ar[minI]) minI = i;
  cout << "Minimum: " << ar[minI] << "; Index: " << minI << "\n\n";
  // намиране на индекса на максимален елемент
  short maxI = 0;
  for (short i = 0; i < len; ++i) if (ar[i] > ar[maxI]) maxI = i;
  cout << "Maximum: " << ar[maxI] << "; Index: " << maxI << "\n\n";
  // намиране броя на максималните елементи
  // начин, когато предварително знаем максимума
  short count = 0;
  for (short i = 0; i < len; ++i) if (ar[i] == ar[maxI]) ++count;
  cout << "Maximums count: " << count << endl;
  // начин, когато предварително НЕ знаем максимума
  double max = ar[0];
  count = 1;
  for (short i = 1; i < len; ++i)
    if (ar[i] == max) ++count;
    else if(ar[i] > max) { max = ar[i]; count = 1; }
  cout << "Maximums count: " << count << endl;
  // извеждане на индексите на максимумите
  cout << "Indexes for maximums: ";
  for (short i = 0; i < len; ++i) if (max == ar[i]) cout << i << " ";
  cout << "\n\n";


  system("pause");
  return 0;
}