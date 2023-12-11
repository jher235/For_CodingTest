#include <stdio.h>



int main() {
    int n,m,k,t;
    scanf("%d %d", &n,&m);
    int arr[n+1][m+1];
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            scanf("%d", &k);
            arr[i+1][j+1]=k;
        }
    }
   
    scanf("%d" , &t);
    for(int i=0;i<t;i++){
        int x1,x2,y1,y2,sum=0;
        scanf("%d %d %d %d",&y1,&x1,&y2,&x2);
        for(int i=y1;i<=y2;i++){
            for(int j=x1;j<=x2;j++){
                sum+=arr[i][j];
            }
        }

        printf("%d\n", sum);
    }
    
}