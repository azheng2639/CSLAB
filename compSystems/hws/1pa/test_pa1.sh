#!/bin/sh
# Author: Amittai Aviram - aviram@bc.edu

echo Building ...
gcc -Wall -Werror -std=c99 pa1.c -o pa1
echo Building complete.

echo Running ...
./pa1 63 cm >> output.txt
./pa1 34 in >> output.txt
./pa1 169 cm >> output.txt
./pa1 13 in >> output.txt
./pa1 68 cm >> output.txt
./pa1 158 in >> output.txt
./pa1 181 cm >> output.txt
./pa1 134 in >> output.txt
./pa1 115 cm >> output.txt
./pa1 71 in >> output.txt
./pa1 151 cm >> output.txt
./pa1 4 in >> output.txt
./pa1 65 cm >> output.txt
./pa1 54 in >> output.txt
./pa1 69 cm >> output.txt
./pa1 15 in >> output.txt
./pa1 110 cm >> output.txt
./pa1 198 in >> output.txt
./pa1 166 cm >> output.txt
./pa1 154 in >> output.txt
./pa1 78 cm >> output.txt
./pa1 96 in >> output.txt
./pa1 25 cm >> output.txt
./pa1 126 in >> output.txt
./pa1 70 cm >> output.txt
./pa1 152 in >> output.txt
./pa1 105 cm >> output.txt
./pa1 162 in >> output.txt
./pa1 127 cm >> output.txt
./pa1 93 in >> output.txt
./pa1 157 cm >> output.txt
./pa1 165 in >> output.txt
./pa1 52 cm >> output.txt
./pa1 67 in >> output.txt
./pa1 137 cm >> output.txt
./pa1 191 in >> output.txt
./pa1 171 cm >> output.txt
./pa1 89 in >> output.txt
./pa1 63 cm >> output.txt
./pa1 34 in >> output.txt
./pa1 5 cm >> output.txt
./pa1 146 in >> output.txt
./pa1 163 cm >> output.txt
./pa1 85 in >> output.txt
./pa1 117 cm >> output.txt
./pa1 188 in >> output.txt
./pa1 161 cm >> output.txt
./pa1 10 in >> output.txt
./pa1 43 cm >> output.txt
./pa1 89 in >> output.txt
./pa1 159 cm >> output.txt
./pa1 132 in >> output.txt
./pa1 54 cm >> output.txt
./pa1 177 in >> output.txt
./pa1 58 cm >> output.txt
./pa1 27 in >> output.txt
./pa1 67 cm >> output.txt
./pa1 148 in >> output.txt
./pa1 194 cm >> output.txt
./pa1 34 in >> output.txt
./pa1 40 cm >> output.txt
./pa1 120 in >> output.txt
./pa1 156 cm >> output.txt
./pa1 119 in >> output.txt
./pa1 182 cm >> output.txt
./pa1 135 in >> output.txt
./pa1 3 cm >> output.txt
./pa1 0 in >> output.txt
./pa1 10 cm >> output.txt
./pa1 62 in >> output.txt
./pa1 21 cm >> output.txt
./pa1 158 in >> output.txt
./pa1 35 cm >> output.txt
./pa1 5 in >> output.txt
./pa1 143 cm >> output.txt
./pa1 91 in >> output.txt
./pa1 105 cm >> output.txt
./pa1 89 in >> output.txt
./pa1 9 cm >> output.txt
./pa1 186 in >> output.txt

echo Running complete.
echo Comparing real and expected output.

DIFF=$(diff output.txt expected_pa1.txt)
if [ "$DIFF" != "" ]
then
    printf "\nXXXXXXXX UNEXPEXTED OUTPUT: XXXXXXXX\n\n"
    printf "In each pair below, your output appears above the expected output.\n"
    printf "$DIFF\n\n"
else
    printf "\n======== CORRECT ========\n\n"
fi
rm output.txt

