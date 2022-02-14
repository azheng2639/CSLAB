#!/bin/sh
# Author: Amittai Aviram - aviram@bc.edu

echo Building ...
gcc -Wall -Werror -std=c99 pa3.c -o pa3
echo Building complete.

echo Running ...
./pa3 < input_pa3.txt > output.txt
echo Running complete.

echo Comparing real and expected output.
DIFF=$(diff output.txt expected_pa3.txt)
if [ "$DIFF" != "" ]
then
    printf "\nXXXXXXXX UNEXPEXTED OUTPUT: XXXXXXXX\n\n"
    printf "In each pair below, your output appears above the expected output.\n"
    printf "$DIFF\n\n"
else
    printf "\n======== CORRECT ========\n\n"
fi
rm output.txt
