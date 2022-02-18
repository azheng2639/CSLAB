/*
 * Author: Andy Zheng - zhengno@bc.edu
 */

#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>

#define BYTE_SIZE 8
#define MAX_INPUT_LENGTH 256

enum boolean {FALSE,TRUE};

char * fgets(char * str, int n, FILE * stream);

int get_input(int buffer_length,char * input) {
	input = fgets(input, buffer_length, stdin);
	if(input != NULL && input[0] != '\0' && input[1] != '\0') {
		return TRUE;
	}
	return FALSE;
}

void dec_to_bin_str(char input, char * output) {
	int shift = BYTE_SIZE - 1;
	unsigned int mask = 1u << shift;
	int count = 0;
	while(mask) {
		output[count] = ((input & mask) >> shift) + '0';
		--shift;
		++count;
		mask >>= 1;
	}
	output[count] = '\0';
}

void print_ascii(char * input) {
	int i = 0;
	do {
		printf("%d ", input[i]);
		i++;
	}  while(input[i - 1] != '\0');
	printf("\n");
	int c = 0;
	do {
		char output[BYTE_SIZE + 1];
		dec_to_bin_str(input[c], output);
		printf("%s ", output);
		c++;
	} while(input[c - 1] != '\0');
}

int main() {
	puts("Please enter a string of no more than 255 characters, including spaces.\nHit Enter to quit.");
	printf("> ");
	char input[MAX_INPUT_LENGTH - 1];
	while(get_input(MAX_INPUT_LENGTH, input)) {
		puts("ASCII codes:");
		print_ascii(input);
		printf("\n> ");
	}
	return EXIT_SUCCESS;
}
