echo "Compiling ..."
make clean && make

echo "Running ..."
./fp_analyzer < input_pa6_f.txt > output_f.txt
./fp_analyzer_d < input_pa6_d.txt > output_d.txt
echo >> output_f.txt
echo >> output_d.txt

echo "FLOAT -- Diffing ..."
DIFF=$(diff expected_pa6_f.txt output_f.txt)
if [ "$DIFF" != "" ]
then
    echo "\nXXXXXXXX UNEXPECTED OUTPUT: XXXXXXXX\n"
    echo "$DIFF\n"
else
    echo "\n======== CORRECT ========\n"
fi

echo "DOUBLE -- Diffing ..."
DIFF=$(diff expected_pa6_d.txt output_d.txt)
if [ "$DIFF" != "" ]
then
    echo "\nXXXXXXXX UNEXPECTED OUTPUT: XXXXXXXX\n"
    echo "$DIFF\n"
else
    echo "\n======== CORRECT ========\n"
fi

#rm -f output*.txt
#make clean

