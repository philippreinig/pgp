#include <stdlib.h>
#include <stdio.h>

typedef struct
{
    char *array;
    int amt_elems;
    int size;
} Dyn_array_t;

void print_array(Dyn_array_t *array)
{
    printf("%i/%i: ", array->amt_elems, array->size);
    if (array->amt_elems == 0)
        printf("[]\n");
    else
    {
        printf("[");
        for (int i = 0; i < array->amt_elems - 1; ++i)
        {
            printf("%c, ", array->array[i]);
        }
        printf("%c]\n", array->array[array->amt_elems - 1]);
        // printf("%c]\n;", array->array[array->amt_elems - 1]);
    }
}

void init_array(Dyn_array_t *array, int desSize)
{
    array->array = (char *)calloc(sizeof(char), desSize);
    if (array->array != NULL)
    {
        printf("Dynamic array initialization successful\n");
        array->amt_elems = 0;
        array->size = desSize;
    }
    else
        printf("ERROR: Dynamic array initialization failed!\n");
    print_array(array);
}

void destroy_array(Dyn_array_t *array)
{
    free(array->array);
    array->amt_elems = 0;
    array->size = 0;
}

int squash_array(Dyn_array_t *array)
{
    printf("There are currently %i/%i elements in the array. Trying to squash it.\n", array->amt_elems, array->size);
    array->array = (char *)realloc(array->array, array->amt_elems);
    if (array->array == NULL)
    {
        printf("ERROR: Squasing the array failed!\n");
        return 0;
    }
    else
    {
        array->size = array->amt_elems;
        printf("Squashing successful. Now there are %i/%i elements in the array\n", array->amt_elems, array->size);
        return 1;
    }
}

int insert(Dyn_array_t *array, char elem)
{
    if (array->amt_elems >= array->size)
    {
        printf("There are currently %i/%i elements in the array. Trying to allocate more memory.\n", array->amt_elems, array->size);
        array->array = (char *)realloc(array->array, (array->size) * 2);
        if (array->array == NULL)
        {
            printf("ERROR: Need to insert another element, but can't grow size, because there is not enough memory available! Not going to insert element!\n");
            return 0;
        }
        else
        {
            printf("Reallocation successful. Now there are %i/%i elements in the array\n", array->amt_elems, array->size);
            array->size = (array->size) * 2;
        }
    }
    array->array[array->amt_elems] = elem;
    ++(array->amt_elems);
    return 1;
}

int main()
{
    Dyn_array_t dyn_array;
    init_array(&dyn_array, 10);
    long l;
    for (l = 0; l < 100; ++l)
    {
        insert(&dyn_array, (char)(rand() % 26 + 97));
    };
    printf("Inserting done: There are currently %i/%i elements in the array.\n", dyn_array.amt_elems, dyn_array.size);
    print_array(&dyn_array);
    int squash = squash_array(&dyn_array);
    if (squash) print_array(&dyn_array);
    destroy_array(&dyn_array);

// print_array(&dyn_array);
return EXIT_SUCCESS;
}