#include <iostream>
#include <string>
#include <cmath>

using namespace std;


void decode(string s) {
	
	int size = s.length();

	int k = (int )sqrt(size);
	int count = 0;

	char c[105][105];

	for (int i = 0; i < k; i++) {
		for (int j = 0; j < k; j++) {
			c[k - j - 1][i] = s[count];
			count++;
		}
	}

	for (int i = 0; i < k; i++) {
		for (int j = 0; j < k; j++) {
			cout << c[i][j];
		}
	}
	cout << endl;

}


int main() {

	int n;
	string s;

	char *ch = new char[10000];

	cin >> n;

	for (int i = 0; i < n; i++) {
		cin >> s;
		decode(s);
	}
	

	return 0;
}


