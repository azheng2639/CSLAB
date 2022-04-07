CC = gcc
FLAGS = -Wall -Werror -std=c99

make: div1.s div2.s main.c
	${CC} ${FLAGS} div1.s main.c -o div1
	${CC} ${FLAGS} div2.s main.c -o div2

zip: div1.s div2.s main.c makefile 
	zip pa7.zip $^

clean:
	rm -f div1 div2
	rm -f pa7.zip

