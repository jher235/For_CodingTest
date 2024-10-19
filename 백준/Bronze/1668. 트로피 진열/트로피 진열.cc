#include <iostream>
#include <string>

using namespace std;


int viewInLeft(int* tropi, int size) {
	int count = 0;
	int max = 0;
	for (int i = 0; i < size; i++) {
		if (max < tropi[i]) {
			count++;
			max = tropi[i];
		}
	}
	return count;
}


int viewInRight(int* tropi, int size) {
	int count = 0;
	int max = 0;

	for (int i = size - 1; i >= 0; i--) {
		if (max < tropi[i]) {
			max = tropi[i];
			count++;
		}
	}
	return count;
}

int main() {

	int n;

	cin >> n;

	int* tropi = new int[n];

	for (int i = 0; i < n; i++) {
		cin >> tropi[i];
	}
	
	cout << viewInLeft(tropi, n) << endl;
	cout << viewInRight(tropi, n) << endl;

	return 0;
}


