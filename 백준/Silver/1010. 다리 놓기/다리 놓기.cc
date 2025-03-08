#include <stdio.h>

int main() {

int t,i,j,k,n,m;
  long long answer;
  scanf("%d",&t);

  for(i=0;i<t;i++)
  {
    scanf("%d %d",&n,&m);
 
    {
      answer=1;
      for(j=1;j<=n;j++)
     {
      
     answer=answer*m/j;
 
    m--;
       }
    }
    printf("%lld\n",answer);
  }




  return 0;
}
  