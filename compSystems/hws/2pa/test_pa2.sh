#!/bin/sh
# Author: Amittai Aviram - aviram@bc.edu

echo Building ...
gcc -Wall -Werror -std=c99 pa2.c -o pa2
echo Building complete.

echo Running ...
./pa2 < input_pa2.txt > output.txt
echo Running complete.

echo Comparing real and expected output.
DIFF=$(diff output.txt expected_pa2.txt)
if [ "$DIFF" != "" ]
then
    printf "\nXXXXXXXX UNEXPEXTED OUTPUT: XXXXXXXX\n\n"
    printf "In each pair below, your output appears above the expected output.\n"
    printf "$DIFF\n\n"
else
    printf "\n======== CORRECT ========\n\n"
fi

rm output.txt
