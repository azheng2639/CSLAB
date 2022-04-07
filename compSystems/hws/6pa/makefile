CC = gcc
FLAGS = -Wall -Werror -std=c99

make: 
	${CC} ${FLAGS} fp_analyzer.c main.c -o fp_analyzer
	${CC} ${FLAGS} -D DOUBLE fp_analyzer.c main.c -o fp_analyzer_d

zip: fp_analyzer.c main.c fp_analyzer.h makefile 
	zip pa6.zip $^

clean:
	rm -f fp_analyzer fp_analyzer_d
	rm -f pa6.zip
	rm -f output.txt

