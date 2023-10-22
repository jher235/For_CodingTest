#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>


int main(void) {
	
	int h, m;
	long tm;
	scanf("%d %d", &h, &m);
	scanf("%ld", &tm);

	if (tm + m > 59) {
		int endm = (tm + m)%60;
		int plush = (tm + m)/60;
		h = (h + plush) % 24;
		
		m = endm;
	}
	else {
		m += tm;
	}

	printf("%d %d", h, m);



	return 0;
}