#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <math.h>
#include <string.h>
#include<stdlib.h>

int main(void) {

	int a, b, c, max=0, ans=0;
	int sum[100] = { 0, };
	scanf("%d %d %d", &a, &b, &c);

	for (int i = 1; i <= a; i++) {
		for (int j = 1; j <= b; j++) {
			for (int k = 1; k <= c; k++) {
				sum[i + j + k]++ ;
				if  (sum[i + j + k]> max) {
					max = sum[i + j + k];
					ans = i + j + k;
				}
			}
		}
	}
	
	printf("%d", ans);
	
	
	return 0;
}