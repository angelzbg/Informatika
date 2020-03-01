/* Програмата илюстрира работа с указатели
   и динамични данни.
*/#include <iostream>
using namespace std;
int main(){
  int i = -23, j = 1021;
  int *u = &i;
  cout << "*u = " << *u << endl;
  u = &j;
  cout << "*u = " << *u << endl;
  u = new int;
  cout << "Integer: ";
  cin >> *u;
  cout << "*u = " << *u << endl;
  delete u;
  //u = NULL;
  u = new int;
  *u = 123456;
  cout << "*u = " << *u << endl;
  delete u;
  u = NULL;
  if(u) cout << "*u = " << *u << endl;
  u = new int[5];
  u[0] = u[1] = u[2] = 44;
  u[3] = u[4] = 404;
  for (short i = 0; i < 5; ++i) cout << u[i] << " ";
  cout << endl;
  delete[] u;
  //u = NULL;
  
  system("pause");
  return 0;
}