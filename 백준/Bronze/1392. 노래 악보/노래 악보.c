#include <stdio.h>

int main(void) {
  int t,q;
  scanf("%d %d",&q,&t);
  int song[q];
  for(int i=0;i<q;i++){
    int time;
    scanf("%d", &time);
    if(i!=0)
      song[i] = song[i-1]+time;
    else song[i] = time-1;
  }
  
  for(int i=0;i<t;i++){
    int now;
    scanf("%d", &now);
    int k=0;
    while(now>song[k]){
      k++;
    }
    printf("%d\n",k+1);
  }
  
  
  return 0;
}