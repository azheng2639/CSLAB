/*
 * Author: Andy Zheng - zhengno@bc.edu
 */

#include <stdio.h>
#include <stdlib.h>

#define BITS_SIZE 8

int encode(unsigned char input, int * bits) {
	int valid_bits = 0;
	int i;
	for (i = 0; i < BITS_SIZE; i++) {
		bits[i] = ((input >> i) & 1);
		if ((input >> i ) & 1) {
			valid_bits++;
		}
	}
	return valid_bits;
}

void read_and_encode_file(char * in_file, char * out_file) {
	FILE * input_file = fopen(in_file, "r");
	FILE * output_file = fopen(out_file, "w");
	char input;
	do {
		input = fgetc(input_file);
		if	(input != EOF) {
			int bits[BITS_SIZE];
			fputc(encode(input,bits) + '0', output_file);
			int i;
			for (i = 0; i < BITS_SIZE; i++) {
				if (bits[i] == 1) {
					fputc(i + '0', output_file);
				}
			}
		}
	} while (input != EOF);
	fclose(input_file);
	fclose(output_file);
}

int main(int argc, char * argv[]) {
	if (argc < 2) {
		fprintf(stderr, "Please enter input and output file names as command-line arguments.\n");
		exit(EXIT_FAILURE);
	}
	read_and_encode_file(argv[1], argv[2]);
	return EXIT_SUCCESS;
}
