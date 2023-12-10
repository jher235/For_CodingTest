#include <stdio.h>

int station(int out,int in);

int main(void) {

  int k;
  int train=0,max=0;

  for(int i=0;i<4;i++){
    int in,out;
    scanf("%d %d", &out, &in);
    train+=station( out, in);
    max = max>train ? max:train;
  }

  printf("%d", max);
  

  
  return 0;
}

int station(int out,int in){
  return in-out;
}