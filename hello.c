#include <stdio.h>

int sum(int a, int b);

int sum(int a, int b){
  int sum = a + b;
  return sum;
}

int sub(int a, int b){
  int sub = a - b;
  return sub;
}

int main(){
  printf("Hello, World!\n");
  int sum1 = 0;
  int sub1 = 0;
  int a = 3;
  int b = 5;
  sum1 = sum(a, b);
  printf("%d\n", sum1);

  sub1 = sub(a,b);
  printf("%d\n", sub1);

  return 0;
}
