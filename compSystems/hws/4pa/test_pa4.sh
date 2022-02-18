#!/bin/sh
# Author: Amittai Aviram - aviram@bc.edu

PROG=pa4

echo Building ...
gcc -Wall -Werror -std=c99 $PROG.c -o $PROG
echo Building complete.

echo Running ...
./$PROG < input_$PROG.txt > output.txt
echo Running complete.

echo Comparing real and expected output.
DIFF=$(diff output.txt expected_$PROG.txt)
if [ "$DIFF" != "" ]
then
    printf "\nXXXXXXXX UNEXPEXTED OUTPUT: XXXXXXXX\n\n"
    printf "In each pair below, your output appears above the expected output.\n"
    printf "$DIFF\n\n"
else
    printf "\n======== CORRECT ========\n\n"
fi
rm output.txt
