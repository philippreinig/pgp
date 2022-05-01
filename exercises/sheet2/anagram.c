#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <ctype.h>

int is_letter(char c)
{
    return !(!(c >= 65 && c <= 90) && !(c >= 97 && c <= 122));
}

int is_letter_verbose(char c)
{
    if (!is_letter(c))
    {
        printf("ERROR: %c is not a letter!\n", c);
        return 0;
    }
    return 1;
}

int compare(const void *c1_p, const void *c2_p)
{
    int c1 = (int)*((char *)c1_p);
    int c2 = (int)*((char *)c2_p);
    return c1 - c2;
}

int is_anagram(char *word, char *compared)
{
    if (strlen(word) != strlen(compared))
    {
        printf("%s (%li) and %s (%li) are not of equal length! Can't be anagrams.\n", word, strlen(word), compared, strlen(compared));
        return 0;
    }
    char word_lower[strlen(word) + 1];
    char compared_lower[strlen(compared) + 1];
    for (int i = 0; word[i]; ++i)
    {
        if (!is_letter_verbose(word[i]))
            return 0;
        if (!is_letter_verbose(compared[i]))
            return 0;
        compared_lower[i] = (char)tolower(compared[i]);
        word_lower[i] = (char)tolower(word[i]);
    }
    word_lower[strlen(word)] = '\0';
    compared_lower[strlen(compared)] = '\0';

    qsort(&word_lower, sizeof(word_lower) / sizeof(*word_lower), sizeof(*word_lower), compare);
    qsort(&compared_lower, sizeof(compared_lower) / sizeof(*compared_lower), sizeof(*compared_lower), compare);

    for (size_t i = 0; i < strlen(word); ++i)
    {
        if (word_lower[i] != compared_lower[i])
            return 0;
    }
    return 1;

    return 0;
}

int main()
{

    printf("the following inputs should all return true:\n");
    printf("is_anagram('%s', '%s')\t= %d\n", "mehl", "helm", is_anagram("mehl", "helm"));
    printf("is_anagram('%s', '%s')\t= %d\n", "aide", "idea", is_anagram("aide", "idea"));
    printf("is_anagram('%s', '%s')\t= %d\n", "are", "ear", is_anagram("are", "ear"));
    
    printf("the following inputs including upper- and lowercase letters should all return true:\n");
    printf("is_anagram('%s', '%s')\t= %d\n", "cAre", "RaCe", is_anagram("cAre", "RaCe"));
    printf("is_anagram('%s', '%s')\t= %d\n", "tonE", "nOte", is_anagram("tonE", "nOte"));
    printf("is_anagram('%s', '%s')\t= %d\n", "oURs", "sOuRt", is_anagram("oURs", "sOuR"));
    
    printf("the following inputs should all return false:\n");
    printf("is_anagram('%s', '%s') = %d\n", "boeing", "airbus", is_anagram("boeing", "airbus"));
    printf("is_anagram('%s', '%s') = %d\n", "test", "etda", is_anagram("test", "etda"));
    printf("is_anagram('%s', '%s') = %d\n", "redsa", "sartz", is_anagram("redsa", "sartz"));

    printf("the following inputs should all return false and throw an error, because the inputs differ in length:\n");
    printf("is_anagram('%s', '%s') = %d\n", "redsa", "sart", is_anagram("redsa", "sart"));
    printf("is_anagram('%s', '%s') = %d\n", "testar", "rets", is_anagram("testar", "rets"));
    printf("is_anagram('%s', '%s') = %d\n", "fdsad", "fds", is_anagram("fdsad", "fds"));

    printf("the following inputs should all return false and throw an error, because they contain non letter charcters:\n");
    printf("is_anagram('%s', '%s') = %d\n", "fdsa", "fds1", is_anagram("fdsa", "fds1"));
    printf("is_anagram('%s', '%s') = %d\n", "greatr", "great#", is_anagram("greatr", "great#"));
    printf("is_anagram('%s', '%s') = %d\n", "they", "why?", is_anagram("they", "why?"));






    return EXIT_SUCCESS;
}