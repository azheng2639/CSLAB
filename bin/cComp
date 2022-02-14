#!/bin/bash

echo "INPUT: $1"
echo "OUTPUT: $2"
if [ $# -eq 2 ]; then
	gcc -Wall -Werror -std=c99 "$1" -o "$2"
	echo "Done"
	exit 1
else
	echo "IO missing"
fi
