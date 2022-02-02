/*
 *	Author: Andy Zheng - zhengno@bc.edu
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

#define MAX_UNIT_LENGTH 4
#define CM_PER_IN 2.54
#define MM_PER_CM 10
#define CM_PER_M 100
#define IN_PER_YD 36
#define CM_PER_KM 100000
#define IN_PER_MI 63360
#define IN_PER_FT 12
#define IN_PER_YD 36

double mm_to_in(const double mm) {
	return (mm/MM_PER_CM)/CM_PER_IN;
}

double cm_to_in(const double cm) {
	return cm/CM_PER_IN;
}

double m_to_yd(const double m) {
	return ((m * CM_PER_M) / CM_PER_IN)/IN_PER_YD;
}

double km_to_mi(const double km) {
	return ((km * CM_PER_KM) / CM_PER_IN)/IN_PER_MI;
}

double in_to_cm(const double in) {
	return in * CM_PER_IN;
}

double ft_to_m(const double ft) {
	return ((ft * IN_PER_FT) * CM_PER_IN) / CM_PER_M;
}

double yd_to_m(const double yd) {
	return ((yd * IN_PER_YD) * CM_PER_IN) / CM_PER_M;
}

double mi_to_km(const double mi) {
	return ((mi * IN_PER_MI) * CM_PER_IN) / CM_PER_KM;
}

double convert(const double val, const char * const unit, char ** output_unit) {
	if(!strcmp(unit,"mm")) {
		* output_unit = "in";
		return mm_to_in(val);
	}
	if(!strcmp(unit,"cm")) {
		* output_unit = "in";
		return cm_to_in(val);
	}
	if(!strcmp(unit,"m")) {
		* output_unit = "yd";
		return m_to_yd(val);
	}
	if(!strcmp(unit,"km")) {
		* output_unit = "mi";
		return km_to_mi(val);
	}
	if(!strcmp(unit,"in")) {
		* output_unit = "cm";
		return in_to_cm(val);
	}
	if(!strcmp(unit,"ft")) {
		* output_unit = "m";
		return ft_to_m(val);
	}
	if(!strcmp(unit,"yd")) {
		* output_unit = "m";
		return yd_to_m(val);
	}
	if(!strcmp(unit,"mi")) {
		* output_unit = "km";
		return mi_to_km(val);
	}
	return NAN;
}

int main() {
	double value;
	char unit[MAX_UNIT_LENGTH];
	puts("Please enter a length to convert, in the form <number> <unit>.\nEnter any letter to quit.");
	printf("> ");
	while(scanf("%lf %s", &value, unit) != 0) {
		char * output_unit;
		double output = convert(value,unit,& output_unit);
		if(isnan(output)) {
			puts("Allowable units: mm, cm, m, km, in, ft, yd, mi.");
		}
		else {
			printf("%f %s = %f %s\n", value, unit, output, output_unit);
		}
		printf("> ");
	}
	return EXIT_SUCCESS;
}
