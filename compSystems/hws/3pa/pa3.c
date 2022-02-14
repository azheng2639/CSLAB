/*
 *	Author: Andy Zheng: Zhengno@bc.edu
 */

#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <math.h>

#define CM_PER_IN 2.54
#define MM_PER_CM 10
#define CM_PER_M 100
#define IN_PER_YD 36
#define CM_PER_KM 100000
#define IN_PER_MI 63360
#define IN_PER_FT 12
#define IN_PER_YD 36
#define MAX_UNIT_LENGTH 256
#define UNIT_STRINGS_LENGTH 8

typedef enum {MM,CM,M,KM,IN,FT,YD,MI, UNSUPPORTED} Unit;
typedef enum {INPUT, OUTPUT} Direction;
enum boolean {FALSE, TRUE};

const char * unit_strings[] = {"mm","cm","m","km","in","ft","yd","mi"};

Unit unit_string_to_unit(const char * const unit_string) {
	int i;
	for(i = 0; i < UNIT_STRINGS_LENGTH; i++) {
		if (!strcmp(unit_strings[i],unit_string)) {
			return i;
		}
	}
	return UNSUPPORTED;
}

int is_metric(const Unit unit) {
	if (unit < 4) {
		return TRUE;
	}
	return FALSE;
}

double convert_metric(const double value, const Unit unit, const Direction direction) {
	switch(unit) {
		case MM:
			return direction == INPUT ? value / MM_PER_CM : value * MM_PER_CM;
		case CM:
			return value;
		case M:
			return (direction == INPUT) ? value * CM_PER_M : value / CM_PER_M;
		case KM:
			return (direction == INPUT) ? value * CM_PER_KM : value / CM_PER_KM;
		default:
			exit(EXIT_FAILURE);
	}
}

double convert_us(const double value, const Unit unit, const Direction direction) {
	switch(unit) {
		case IN:
			return value;
		case FT:
			return (direction == INPUT) ? value * IN_PER_FT : value / IN_PER_FT;
		case YD:
			return (direction == INPUT) ? value * IN_PER_YD : value / IN_PER_YD;
		case MI:
			return (direction == INPUT) ? value * IN_PER_MI : value / IN_PER_MI;
		default:
			exit(EXIT_FAILURE);
	}
}

double convert(const double value, const char * const input_unit_string, const char * const output_unit_string) {
	Unit input = unit_string_to_unit(input_unit_string);
	Unit output = unit_string_to_unit(output_unit_string);
	double output_value;
	if(input == UNSUPPORTED || output == UNSUPPORTED) {
		return NAN;
	}
	if(is_metric(input)) {
		output_value = convert_metric(value, input, INPUT);
		if(!is_metric(output)) {
			output_value = convert_us(output_value / CM_PER_IN, output, OUTPUT);
		}
		else {
			output_value = convert_metric(output_value, output, OUTPUT);
		}
	}
	else {
		output_value = convert_us(value, input, INPUT);
		if(is_metric(output)) {
			output_value = convert_metric(output_value * CM_PER_IN, output, OUTPUT);
		}
		else {
			output_value = convert_us(output_value, output, OUTPUT);
		}
	}
	return output_value;
}

int main() {
	double input;
	char input_unit[MAX_UNIT_LENGTH];
	char output_unit[MAX_UNIT_LENGTH];
	puts("Please enter a length to convert, in the form <number> <input-unit> <output-unit>.\nEnter any letter to quit.");
	printf("> ");
	while(scanf("%lf %s %s", &input, input_unit, output_unit) != 0) {
		double output = convert(input,input_unit,output_unit);
		if(!isnan(output)) {
			printf("%f %s = %f %s\n", input, input_unit, output, output_unit);
		}
		else {
			printf("Allowable units:");
			int i;
			for(i = 0; i < UNIT_STRINGS_LENGTH; i ++) {
				printf(" %s",unit_strings[i]);
			}
			printf(".\n");

		}
		printf("> ");
	}
	return EXIT_SUCCESS;
}
