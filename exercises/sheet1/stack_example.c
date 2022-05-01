#include <stdio.h>  
#include <stdlib.h>  
 
int addFive(int number){  
    int numberPlusFive = number+5;  
    return numberPlusFive;  
}

int multFourAndAddThree(int number){  
    int newNumber = number*4+3;  
    return newNumber;  
}

int main(){  
    int value = 17;  
    int res = addFive(multFourAndAddThree(value));  
    return 0;  
} 