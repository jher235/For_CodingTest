#define _CRT_SECURE_NO_WARNINGS

#include<stdio.h>
#include<stdlib.h>
#include<time.h>
#include<math.h>

int main() {
    int n;

    scanf("%d", &n);
    for(int j =n;j>0;j--)
    {
        for (int i =  n-j; i > 0; i--) {
            printf(" ");
        }
        for (int i = j * 2 - 1; i >0; i--) {
            printf("*");
        }
        printf("\n");
    }

    for (int j = n-2; j >=0; j--)
    {
        for (int i = j; i > 0; i--) {
            printf(" ");
        }
        for (int i = (n-j) * 2 - 1; i > 0; i--) {
            printf("*");
        }
        printf("\n");
    }
 


    return 0;


}