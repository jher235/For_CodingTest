#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <math.h>
#include <string.h>
#include<stdlib.h>

int main(void) {

	char str[20];

	scanf("%s", str);
	int end= 0;
	for (int i=0; i <strlen(str); i++) {
		if (str[i] == 'x') {
			end = 1;
			if (i == 0) {
				printf("1");
			}
			else if (i == 1 && str[0] == '-') {
				printf("-1");
			}
			else {
				for (int j = 0; j < i; j++) {
					printf("%c", str[j]);
				}
			}
			
		}
	}
	if (end == 0) {
		printf("0");
	}
	
	return 0;
}