#include <stdio.h>

int main() {
    int n,a,b;
    int cup[4]={0};
    cup[1]=1;

    scanf("%d",&n);

    for(int i=0;i<n;i++){
        scanf("%d %d",&a,&b);
        int temp = cup[a];
        cup[a] = cup[b];
        cup[b] = temp;
    }

    for(int i=1;i<4;i++){
        if(cup[i]==1) printf("%d",i);
    }
    
    
    return 0;
}