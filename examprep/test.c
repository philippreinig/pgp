#include <stdio.h>

int main(int argc, char** argv){
    unsigned short myShort = 42;
    double myDouble = *(double*)(&myShort);
    printf("myDouble=%d\n", myDouble);
}