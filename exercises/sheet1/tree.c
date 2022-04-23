#include <stdio.h>

void print_char_n_times(int n, char c){
    for(int i = 0; i < n; ++i){ 
        printf("%c", c);
    }
}

void print_tree_char(int height, char symbol) {
    for(int i = 1; i <= 2*height; i+=2){
        print_char_n_times((2*height-i)/2, ' ' );
        print_char_n_times(i, symbol);
        print_char_n_times((2*height-i)/2, ' ');
        printf("\n");
    }
    print_char_n_times((2*height-1)/2, ' ' );
    print_char_n_times(1, symbol);
    print_char_n_times((2*height-1)/2, ' ');
    printf("\n");
}

void print_tree(int height) {
    print_tree_char(height, '*');

}


int main() {
    print_tree(15);
    print_tree_char(5, 'o');
}