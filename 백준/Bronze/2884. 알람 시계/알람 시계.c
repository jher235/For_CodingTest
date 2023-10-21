#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>


int main(void) {
	
	char x;

	int h,m;

	scanf("%d %d", &h, &m);

	if (m >= 45) {
		m -= 45;
	}
	else {
		m = 60 - (45-m);
		if (h > 0)h -= 1;
		else h = 23;

	}
	
	printf("%d %d", h, m);
	

	return 0;
}