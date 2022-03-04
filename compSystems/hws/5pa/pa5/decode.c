
/*
 * Author: Andy Zheng - zhengno@bc.edu
 */

#include <stdio.h>
#include <stdlib.h>

#define BITS_SIZE 8
#define ASCII_INTEGER_SHIFT 48

char decode(const int count, const int bits[]) {
	int c = 0;
	int i;
	for (i = 0; i < count && bits[i] != '\0'; i ++) {
		c += 1 << (bits[i] - ASCII_INTEGER_SHIFT);
	}
	return c;
}

void read_and_decode_file(const char * file_name) {
	FILE * file = fopen(file_name, "r");
	int input;
	do {
		input = fgetc(file);
		if (input != EOF) {
			input -= ASCII_INTEGER_SHIFT;
			int bits[input];
			int i;
			for (i = 0; i < input; i ++) {
				bits[i] = fgetc(file);
			}
			int c = decode(input, bits);
			printf("%c", c);
		}
	} while (input != EOF);
	fclose(file);
}

int main(int argc, char * argv[]) {
	if (argc != 2) {
		fprintf(stderr,"Please enter an input file name as a command-line argument.\n");
		exit(EXIT_FAILURE);
	}
	read_and_decode_file(argv[1]);
	return EXIT_SUCCESS;
}
