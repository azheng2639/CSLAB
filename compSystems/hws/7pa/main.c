/*
 * Author: Andy Zheng - zhengno@bc.edu
 */

#include <stdio.h>
#include <stdlib.h>

int div_qr(int dividend, int divisor, int * remainder);

int main() {
	int dividend;
	int divisor;
	puts("Please enter an integer dividend and divisor, or \"q\" to quit.");
	printf("> ");
	while(scanf("%i %i", &dividend, &divisor) != 0) {
		if (!divisor) {
			puts("Division by 0 is undefined.");
		}
		else {
			int remainder;
			int quotient = div_qr(dividend, divisor, &remainder);
			printf("%i / %i = %i, r %i\n", dividend, divisor, quotient, remainder);
		}
		printf("> ");
	}
	return EXIT_SUCCESS;
}
