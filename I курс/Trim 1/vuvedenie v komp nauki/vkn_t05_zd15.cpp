#include <iostream>
using namespace std;
int main(){
  double const N[] = { -5.0, 15.0, -25.0, 1.5, 35.0 };
  const double * const w1 = N, * const w2 = &N[3];
  const double (* const w4)[5] = &N;
  const double * const AP1[] = { &N[2], &N[4] };
  const double * const * const w3 = &w2;
  const double * const * const AP2[] = { &w1, &w2, &AP1[1] };

  cout << "N[1]" << " = " << N[1] << endl;
  cout << "*(N + 1)" << " = " << *(N + 1) << endl;
  cout << "*&N[1]" << " = " << *&N[1] << endl;

  cout << "*(w1 + 1)" << " = " << *(w1 + 1) << endl;
  cout << "w1[1]" << " = " << w1[1] << endl;

  cout << "*(w2 - 2)" << " = " << *(w2 - 2) << endl;
  cout << "w2[-2]" << " = " << w2[-2] << endl;

  cout << "*(*w3 - 2)" << " = " << *(*w3 - 2) << endl;
  cout << "(*w3)[-2]" << " = " << (*w3)[-2] << endl;
  cout << "*(w3[0] - 2)" << " = " << *(w3[0] - 2) << endl;
  cout << "w3[0][-2]" << " = " << w3[0][-2] << endl;

  cout << "(*w4)[1]" << " = " << (*w4)[1] << endl;
  cout << "*(*w4 + 1)" << " = " << *(*w4 + 1) << endl;
  cout << "w4[0][1]" << " = " << w4[0][1] << endl;
  cout << "*(w4[0] + 1)" << " = " << *(w4[0] + 1) << endl;

  cout << "*(AP1[0] - 1)" << " = " << *(AP1[0] - 1) << endl;
  cout << "AP1[0][-1]" << " = " << AP1[0][-1] << endl;
  cout << "*(*AP1 - 1)" << " = " << *(*AP1 - 1) << endl;
  cout << "(*AP1)[-1]" << " = " << (*AP1)[-1] << endl;
  
  cout << "*(AP1[1] - 3)" << " = " << *(AP1[1] - 3) << endl;
  cout << "AP1[1][-3]" << " = " << AP1[1][-3] << endl;
  cout << "*(*(AP1 + 1) - 3)" << " = " << *(*(AP1 + 1) - 3) << endl;
  cout << "(*(AP1 + 1))[-3]" << " = " << (*(AP1 + 1))[-3] << endl;

  cout << "*(*AP2[2] - 3)" << " = " << *(*AP2[2] - 3) << endl;
  cout << "(*AP2[2])[-3]" << " = " << (*AP2[2])[-3] << endl;
  cout << "*(**(AP2 + 2) - 3)" << " = " << *(**(AP2 + 2) - 3) << endl;
  cout << "(**(AP2 + 2))[-3]" << " = " << (**(AP2 + 2))[-3] << endl;

  cout << "*(*AP2[1] - 2)" << " = " << *(*AP2[1] - 2) << endl;
  cout << "(*AP2[1])[-2]" << " = " << (*AP2[1])[-2] << endl;
  cout << "*(**(AP2 + 1) - 2)" << " = " << *(**(AP2 + 1) - 2) << endl;
  cout << "(**(AP2 + 1))[-2]" << " = " << (**(AP2 + 1))[-2] << endl;

  cout << "*(*AP2[0] + 1)" << " = " << *(*AP2[0] + 1) << endl;
  cout << "(*AP2[0])[1]" << " = " << (*AP2[0])[1] << endl;
  cout << "*(**AP2 + 1)" << " = " << *(**AP2 + 1) << endl;
  cout << "(**AP2)[1]" << " = " << (**AP2)[1] << endl;


  system("pause");
  return 0;
}