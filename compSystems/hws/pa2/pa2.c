
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
#define IN_PER_MILE 63360
#define IN_PER_FT 12
#define IN_PER_YD 36

double mm_to_in(const double mm){
	return (mm/MM_PER_CM)/CM_PER_IN;
}

double cm_to_in(const double cm){
	return cm/CM_PER_IN;
}

double m_to_yd(const double m){
	return ((m * CM_PER_M) / CM_PER_IN)/CM_PER_YD;
}

double km_to_mi(const double km){
	return ((km * CM_PER_KM) / CM_PER_IN)/IN_PER_MILE;
}

double in_to_cm(const double in){
	return in * CM_PER_IN;
}

double ft_to_m(const double ft){
	return ((ft * IN_PER_FT) * CM_PER_IN) / CM_PER_M;
}

double yd_to_m(const double yd){
	return ((yd * IN_PER_YD) * CM_PER_IN) / CM_PER_M;
}

double mi_to_km(const double mi){
	return ((mi * IN_PER_MI) * CM_PER_IN) / CM_PER_KM;
}

char * output_unit(const char * const input_unit){
	if(!strcmp(input_unit,"mm")){
		return "in";
	}
	if(!strcmp(input_unit,"cm")){
		return "in";
	}
	if(!strcmp(input_unit,"m")){
		return "yd";
	}
	if(!strcmp(input_unit,"km")){
		return "mi";
	}
	if(!strcmp(input_unit,"in")){
		return "cm";
	}
	if(!strcmp(input_unit,"ft")){
		return "m";
	}
	if(!strcmp(input_unit,"yd")){
		return "m";
	}
	if(!strcmp(input_unit,"mi")){
		return "km";
	}
	return "";
}


double convert(const double val, const char * const unit, char ** unit_out){

	*unit_out = output_unit(unit);
	if(!strcmp(unit,"mm")){
		return mm_to_in(val);
	}
	if(!strcmp(unit,"cm")){
		return cm_to_in(val);
	}
	if(!strcmp(unit,"m")){
		return m_to_yd(val);
	}
	if(!strcmp(unit,"km")){
		return km_to_mi(val);
	}
	if(!strcmp(unit,"in")){
		return in_to_cm(val);
	}
	if(!strcmp(unit,"ft")){
		return ft_to_m(val);
	}
	if(!strcmp(unit,"yd")){
		return yd_to_m(val);
	}
	if(!strcmp(unit,"mi")){
		return mi_to_km(val);
	}
	return NAN;
}

int main(){
	double value;
	char unit[MAX_UNIT_LENGTH];
	puts("Please enter a length to convert, in the form <number> <unit>.\nEnter any letter to quit.");
	printf("> ");
	while(scanf("%lf %s", &value, unit) != 0){
		char* unit_out;
		double output = convert(value,unit,&unit_out);
		if(isnan(output)){
			puts("Allowable units: mm, cm, m, km, in, ft, yd, mi.");
		}
		else{
			printf("%f %s = %f %s\n", value, unit, output, unit_out);
		}
		printf("> ");
	}
	return EXIT_SUCCESS;
}
