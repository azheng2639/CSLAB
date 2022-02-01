#include <stdio.h>
#include <stdlib.h>

int atoi(const char *str);

double f_to_c(double f){
	return (f - 32.0) * (5.0/9.0);
}


int main(int argc, char * argv[]){
	int fahr = atoi(argv[1]);
	double cels = f_to_c(fahr);
	printf("%lf\n",cels);
	return 0;
}
