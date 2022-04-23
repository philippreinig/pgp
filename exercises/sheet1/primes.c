#include <stdio.h>
#include <math.h>

int is_prime(int num) {
    if (num < 0) return -1;
    if (num < 2) return 0;
    for(int i = 2; i < num; ++i){ 
        if (num % i == 0) return 0;
    }
    return 1;
}

int calculate_nth_prime_number(int n) {
    int counter = 0;
    int i;
    for(i = 2; counter < n; ++i){
        if (is_prime(i)) ++counter;
    }

    return i-1;

}

int main() {
    printf("is_prime(%i)=%i\n", 1, is_prime(1)); // 0
    printf("is_prime(%i)=%i\n", 2, is_prime(2)); // 1
    printf("is_prime(%i)=%i\n", 3, is_prime(3)); // 1

    for(int i = 1; i <= 50; ++i){
        printf("calculate_nth_prime_number(%i)=%i\n", i, calculate_nth_prime_number(i)); // 11
    }
}