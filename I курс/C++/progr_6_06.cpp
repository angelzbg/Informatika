/* Файл: progr_6_06.cpp
   Упражнения по Програмиране (C++)
   Примерно решение на задача 6.6
   Подготвил: Кирил Иванов
   Февруари 2017 година
*/

#include <iostream>
using namespace std;
#include <cstring>
int main() {
  const short maxStrLen = 35;
  char s1[maxStrLen + 1], s2[maxStrLen + 1],
       res[maxStrLen * maxStrLen + 1] = {0};
  cout << "String 1 (length<=" << maxStrLen << "): ";
  cin.getline(s1, maxStrLen + 1);
  cout << "String 2 (length<=" << maxStrLen << "): ";
  cin.getline(s2, maxStrLen + 1);
  cout << "String 1: \"" << s1 << "\"\n";
  cout << "String 2: \"" << s2 << "\"\n";

  bool nostop=true;
  for(short len=strlen(s1); nostop && 0<len; --len)
  // цикъл по възможните дължини на търсен подниз
    for(short begin=strlen(s1)-len; nostop && 0<=begin; --begin)
    // цикъл по възможните начала на търсен подниз
    {
      short i=0;
      while(i<len) // цикъл по знакове на кандидат за търсения подниз
        if( strchr(s2,s1[begin+i]) ) break; // има знак от подниза, срещащ се в s2
        else ++i; // s1[begin+i] не се среща в s2
      if(i==len) {
        // намерен е подниз на s1, който се състои от знакове, не срещани в s2
        strncpy(res,s1+begin,len);
        nostop=false;
      }
    }
  cout<<"Substring: \""<<res<<"\"\n\n\n";

  system( "pause" );
  return 0;
}
