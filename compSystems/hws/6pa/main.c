/*
 * Author: Andy Zheng - zhengno@bc.edu
 */

#include "fp_analyzer.h"
#include <stdlib.h>
#include <stdio.h>

int main() {
	union Data data;
	printf("Please enter a floating-point number or q to quit.\n> ");
	while (scanf(INPUT_FORMAT, &data.input_data) != 0) {
		printf("%lf\n", data.input_data);
		printf("All bits: ");
		print_bits(data.uint, sizeof(data.uint) * BIT_SIZE);
		print_fields(data);
		print_normalized(data);
		printf("> ");
	}
	return EXIT_SUCCESS;
}
