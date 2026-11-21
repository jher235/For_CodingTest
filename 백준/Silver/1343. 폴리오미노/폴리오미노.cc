#include <stdio.h>
#include <string.h>

void word();
char a[50], in;
int i = 0, last, cnt = 0, stp, ans, estp = 0, can = 0;

int main(void) {

    while ((in = getchar()) != '\n')
    {
        a[i] = in;
        i++;
    }
    last = i;
    a[last] = '\0';

    for (i = 0; i <= last; i++) {
        if (a[i] == 'X')
            cnt++;

        else {
            stp = cnt - estp;
            word();
            cnt++;
            estp++;
        }
    }
    if (can == 0)
    {
        for (int i = 0; i < strlen(a); i++)
            printf("%c", a[i]);
    }
    else
        printf("-1");
    return 0;
}




void word() {

    if (stp % 2 != 0) {
        can = 1;
    }
    else if (stp == 2) {
        for (int i = estp; i < estp + 2; i++)
            a[i] = 'B';

        estp += 2;
        stp -= 2;
    }
    else if (stp >= 4) {
        for (int i = estp; i < estp + 4; i++)
            a[i] = 'A';

        estp += 4;
        stp -= 4;
        if (stp != 0)
            word();
    }

}