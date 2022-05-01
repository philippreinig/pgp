#include <stdlib.h>
#include <stdio.h>
#include <string.h>

char* concat(char* string1, char* string2) {
   int strlen1 = strlen(string1);
   int strlen2 = strlen(string2);
   char* str = malloc(sizeof(char)*(strlen1 + strlen2 + 1));
   for(int i = 0; string1[i]; ++i){
       str[i] = string1[i];
   }
   for(int i = 0; string2[i]; ++i) {
       str[strlen1 + i] = string2[i];
   }

   str[strlen1 + strlen2] = '\0';
   return str;
}

int main() {
    char* part1 = "Hello ";
    char* part2 = "World!";

    char* concatenated = concat(part1, part2);
    printf("concat(%s, %s)= %s\n", part1, part2, concatenated);
    free(concatenated);
    

   // test your code here
   return EXIT_SUCCESS;
}