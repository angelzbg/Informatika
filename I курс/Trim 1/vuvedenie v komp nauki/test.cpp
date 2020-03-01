
#include <iostream>
using namespace std;
int main() {
	short n, k;
	long long w = 102;
	
do{
	cout << "n[1;15]= "; cin >> n;
	
}while (n<1 || n>15);
for(k=1; k<=n; k++)
{
	cout << w << " ";
	w=w-(k*(k+3.00))/2.00+17.00;
}
	system("pause");
	return 0;
}
