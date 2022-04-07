/*
 * Author: Andy Zheng - zhengno@bc.edu
 */

#include "fp_analyzer.h"
#include <stdio.h>

void print_bits(unsigned long value, int length) {
	//taken from lecture
	int shift;
	for (shift = length - 1; shift >= 0; --shift) {
		printf("%i", ((value & (1lu << shift)) != 0));
	}
	printf("\n");
}

void print_fields(union Data data) {
	printf("Sign: ");
	print_bits(data.bits.sign, SIGN_LEN);
	printf("Exponent: ");
	print_bits(data.bits.exponent, EXPONENT_LEN);
	printf("Mantissa: ");
	print_bits(data.bits.mantissa, MANTISSA_LEN);
}

void print_normalized(union Data data) {
	FP_TYPE mantissa = data.bits.mantissa;
	FP_TYPE answer = 1.0;
	// divide mantissa by 2.0 to get real value
	int i;
	for (i = 0; i < MANTISSA_LEN; i++) {
		mantissa /= 2.0;
	}
	// find the value of the exponent
	unsigned int expo;
	if ((data.bits.exponent - BIAS) != 0 && data.bits.exponent != 0) {
		expo = (2 << (data.bits.exponent - BIAS - 1));
	}
	else {
		expo = 1;
	}
	//integrate the sign bit
	if (data.bits.sign) {
		answer *= -1;
	}
	//normalized case
	if (data.bits.exponent != 0 ) {
			answer *= mantissa + 1;
			answer *= expo;
			printf("Original value: (-1)^{%i} x (1 + %lf) x 2^{%i - %i} = %.45f\n", data.bits.sign, mantissa, data.bits.exponent, BIAS, answer);
	}
	//denormalized cases
	else if (mantissa == 0) {
		printf("Original value: %.1lf\n", data.input_data);
	}
	else {
		answer *= mantissa;
		int c;
		for (c = 0; c > 1 - BIAS; --c) {
			answer /= 2.0;
		}
		printf("Original value: (-1)^{%i} x %.45lf x 2^{%i - %i} = %.45lf\n", data.bits.sign, mantissa, expo, BIAS, answer);
	}
}
