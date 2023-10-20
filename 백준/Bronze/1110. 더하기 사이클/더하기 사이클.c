#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>


int main(void) {
	
	char x;

	int n;

	scanf("%d", &n);
	
	char a = n / 10;
	char b = n % 10;
	int count = 1;
	int num[2] = {a,b};
	
	int n1 = b;
	int n2 = (a + b) % 10;
	
	while (!(num[0] == n1 && num[1] == n2)) {
		int temp = n2;
		n2 = (n1 + n2) % 10;
		n1 = temp;
		count++;
		
	}
	printf("%d", count);


	return 0;
}
