#include <iostream>
using namespace std;
int main() {
	short n;
	do {
		cout << "n (1<=n<=15): ";
		cin >> n;
	} while (n < 1 || 15 < n);
	long long w = 102LL;
	for (short k = 1; k <= n; ++k) {
		cout << w << "; ";
		w = w - k * (k + 3) / 2 + 17;
	}
	cout<<endl;
	system("pause");
	return 0;
}