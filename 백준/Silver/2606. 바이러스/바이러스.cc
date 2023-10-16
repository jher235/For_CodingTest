#include<stdio.h>

int main()

{

    int a, b, c=0, i, j, x, y,k;

    int com[101]={0,}, left[200]={0,}, right[200]={0,};
    com[1]=1;
  
    scanf("%d", &a);
    scanf("%d", &b);

    for(i=0;i<b;i++)
   { scanf("%d %d",&x, &y);
     {
      left[i]=x;
     right[i]=y;
       }
    for(j=1;j<=a;j++)
   { if(x==com[j] || y==com[j])
  { 
   com[x]=x;
   com[y]=y;
    }
    }
    }
  for(k=0; k<b; k++)
   {for(i=0;i<b;i++)
   { 
    x= left[i];
    y= right[i];
    for(j=1;j<=a;j++)
   { if(x==com[j] || y==com[j])
  { 
   com[x]=x;
   com[y]=y;
    }
    }
    }
  }
  
  for(j=2;j<=a;j++)
    if(com[j]>0)
      c=c+1;
        
    printf("%d\n", c);


 
    return 0;

}