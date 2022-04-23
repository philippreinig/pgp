#include <stdio.h>
#include <stdlib.h>

struct smartphone_t{
    const char* brand;
    const char* model;
    const char* color;
    unsigned int memory;

} ;

void print_smartphone_configuration(struct smartphone_t phone) {
    printf("Your configuration:\n");
    printf("\tBrand: %s\n", phone.brand);
    printf("\tModel: %s\n", phone.model);
    printf("\tColor: %s\n", phone.color);
    printf("Total Memory: %uGB\n", phone.memory);
}

void add_additional_sd_card(struct smartphone_t* phone) {
    phone->memory += 128;
}

int main() {
    struct smartphone_t phone = {"Sumsang", "Milkyway S3", "black", 16};
    print_smartphone_configuration(phone);

    add_additional_sd_card(&phone);
    print_smartphone_configuration(phone);
}