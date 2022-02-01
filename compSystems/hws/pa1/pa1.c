/*
 * Author: Andy Zheng - zhengno@bc.edu
 */

#include <stdio.h>
#include <stdlib.h>

#define CONVERSION_FACTOR 2.54

int atoi(const char *str);

double cm_to_in(int cm){
	return cm/CONVERSION_FACTOR;
}

double in_to_cm(int in){
	return in * CONVERSION_FACTOR;
}

double convert(int value, char* unit){
	/*
	 *	'\0' used to check for null char after unit
	 *	ensuring only "cm" and "in" as unit input
	 */
	if(unit[0] == 'c' && unit[1] == 'm' && unit[2] == '\0')
		return cm_to_in(value);
	if(unit[0] == 'i' && unit[1] == 'n' && unit[2] == '\0')
		return in_to_cm(value);

	//input unit is neither cm or in
	puts("The unit must either be \"cm\" or \"in\".");
	exit(-1);
}

char* output_unit(char* unit){
	if(unit[0] == 'c' && unit[1] == 'm')
		return "in";
	else
		return "cm";
}
int main(int argc, char * argv[]){

	if(argc < 2){
		puts("Invalid number of arguments");
		return EXIT_FAILURE;
	}

	int val = atoi(argv[1]);
	char* unit = argv[2];
	double out_val = convert(val, unit);
	char* out_unit = output_unit(unit);
	printf("%i %s = %f %s\n", val, unit, out_val, out_unit);
	return EXIT_SUCCESS;
}
