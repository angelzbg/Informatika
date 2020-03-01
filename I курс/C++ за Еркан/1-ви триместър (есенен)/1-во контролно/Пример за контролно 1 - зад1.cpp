#include <iostream>
using namespace std;
int main() {
	double x, y;
	cout << "x y: ";
	cin >> x >> y;
	if (    -1.0 < x && x < 21.5 && -8.0 < y && y < 4.3
	        // принадлежи на вътрешността на ABCD
			&& (x <= 1.0 || 43.5 <= x || y <= 2.0 || 58.0 <= y)
			   // не принадлежи на вътрешността на EFGH
	   ) cout << "Yes\n";
	else cout << "No\n";
	system("pause");
	return 0;
}