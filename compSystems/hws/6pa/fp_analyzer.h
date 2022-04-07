/*
 *	Author: Andy Zheng - zhengno@bc.edu
 */

#ifndef FP_ANALYZER_H
#define FP_ANALYER_H
#define BIT_SIZE 8
#define SIGN_LEN 1
#ifdef DOUBLE
#define DATA_LEN DOUBLE_LEN
#define MANTISSA_LEN 52
#define EXPONENT_LEN 11
#define FP_TYPE double
#define BIAS 1023
#define INPUT_FORMAT "%lf"
#define TOTAL_LEN 64
#else
#define MANTISSA_LEN 23
#define EXPONENT_LEN 8
#define DATA_LEN FLOAT_LEN
#define FP_TYPE float
#define BIAS 127
#define INPUT_FORMAT "%f"
#define TOTAL_LEN 32
#endif

struct bit_field {
	unsigned long mantissa : MANTISSA_LEN;
	unsigned int exponent : EXPONENT_LEN;
	unsigned int sign : SIGN_LEN;
};

union Data {
	FP_TYPE input_data;
	#ifdef DOUBLE
	unsigned long uint;
	#else
	unsigned int uint;
	#endif
	struct bit_field bits;
};

void print_bits(unsigned long input, int length);

void print_fields(union Data data);

void print_normalized(union Data data);

#endif
