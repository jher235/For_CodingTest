#include <stdio.h>

int main() {
   int a,b,c,d=0,i,k;
  
 scanf("%d",&a);
 
  for(i=1;i<=a;i++){
  scanf("%d",&c);  
    b=0;
    if(c!=1)
  {for(k=2;k<=c-1;k++)
   { if(c==1 || c%k==0)
      b+=1;
      }
    if(b==0)
        d+=1;
    }}

   
  
  printf("%d",d);
  return 0;
}