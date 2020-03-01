/* Файл: progr_9_02.cpp
   Упражнения по Програмиране (C++)
   Примерно решение на задача 9.2
   Подготвил: Кирил Иванов
   Февруари 2017 година
*/

#include <iostream>
using namespace std;
#include <cstring>

const short busLinesNumbner = 6, lenName = 30;

struct TypeBusLine {
  char startName[lenName + 1], endName[lenName + 1];
  double price, distance, time;
};

double AverageSpeed(const TypeBusLine & L) {
  return L.distance / L.time;
}

void InputBusLine(TypeBusLine & L) {
  do {
    cout << "     Време за пътуването (часове минути): ";
    short c, m;
    cin >> c >> m;
    L.time = c + m / 60.0;
  } while (L.time <= 0.0);
  cin.ignore(1);
  do {
    cout << "     Начално селище: ";
    cin.getline(L.startName, lenName + 1);
    cout << "     Крайно селище: ";
    cin.getline(L.endName, lenName + 1);
  } while (!strcmp(L.startName, L.endName));
  do {
    cout << "     Цена на билета: ";
    cin >> L.price;
  } while (L.price <= 0.0);
  do {
    cout << "     Изминавано разстояние: ";
    cin >> L.distance;
    cin.ignore(1);
  } while (L.distance <= 0.0);
}

bool Duplication(TypeBusLine part[], short last) {
  // връща true, точно когато part[last] има същите начало, край и разстояние,
  // каквито има и part[i] за някое i<last
  for (short i = 0; i < last; ++i)
    if ( part[i].distance == part[last].distance
         && !strcmp(part[i].startName, part[last].startName)
         && !strcmp(part[i].endName, part[last].endName) )
      return true;
  return false;
}

void InputBusLinesArray(TypeBusLine arr[], short len) {
  cout << "Въведете данни за " << len << " автобусни линии:\n";
  for (short i = 0; i < len; ++i) {
    cout << " Въведете данни за " << i + 1 << "-ата автобусна линия:\n";
    do {
      InputBusLine(arr[i]);
    } while (Duplication(arr, i));
  }
}

void OutputBusLine(const TypeBusLine & L) {
  cout << "   Автолиния от " << L.startName << " до " << L.endName
       << ": разстояние " << L.distance << ";\n      цена " << L.price
       << "; време " << L.time << "; средна скорост " << AverageSpeed(L)
       << ".\n";
}

void OutputBusLinesArray(TypeBusLine arr[], short len) {
  cout << "\n ---- Пълни данни за " << len << " автобусни линии ----\n";
  for (short i = 0; i < len; ++i) {
    cout << i + 1 << "-а линия:\n";
    OutputBusLine(arr[i]);
  }
  cout <<   " ------------------------------------------------------\n\n";
}

void OutputBeginAndEnd(TypeBusLine arr[], short len) {
  cout << "--- Справка: Селища, които са и начало, и край на линия:\n";
  for (short start = 0; start < len; ++start)
    for (short end = 0; end < len; ++end)
      if (!strcmp(arr[start].startName, arr[end].endName)) {
          cout << arr[start].startName << endl;
          break;
        }
  cout << "--- Край на справката.\n\n";
}

double MaxAverageSpeed(TypeBusLine arr[], short len) {
  double max = AverageSpeed(arr[0]);
  for (short i = 0; i < len; ++i)
    if (max < AverageSpeed(arr[i])) max = AverageSpeed(arr[i]);
  return max;
}

void OutputBeginEndWithAverageSpeed(TypeBusLine arr[], short len, double avSpeed) {
  cout << "--- Справка за линии със средна скорост " << avSpeed << ":\n";
  for (short i = 0; i < len; ++i)
    if (AverageSpeed(arr[i]) == avSpeed)
      cout << arr[i].startName << " - " << arr[i].endName << endl;
  cout << "--- Край на справката.\n\n";
}

void OutputBeginEndWithSubstring(TypeBusLine arr[], short len, char * sub) {
  cout << "--- Справка за линии между селища, съдържащи \"" << sub << "\":\n";
  for (short i = 0; i < len; ++i)
    if (strstr(arr[i].startName, sub) || strstr(arr[i].endName, sub))
      cout << arr[i].startName << " - " << arr[i].endName << " (разстояние "
           << arr[i].distance << ").\n";
  cout << "--- Край на справката.\n\n";
}

int main() {
  system("chcp 1251");
  TypeBusLine busLines[busLinesNumbner];
  InputBusLinesArray(busLines, busLinesNumbner);
  OutputBusLinesArray(busLines, busLinesNumbner);
  OutputBeginAndEnd(busLines, busLinesNumbner);
  OutputBeginEndWithAverageSpeed( busLines, busLinesNumbner,
                                  MaxAverageSpeed(busLines, busLinesNumbner) );
  char sub[lenName + 1];
  cout << "Въведете подниз на название на селище: ";
  cin.getline(sub, lenName + 1);
  OutputBeginEndWithSubstring(busLines, busLinesNumbner, sub);

  cout << "\n\n\n";
  system("pause");
  return 0;
}
