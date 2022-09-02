# HW #00
# Author: Andy Zheng - zhengno@bc.edu
# 

from is_prime import is_prime

def prime_factorization(n):
    arr = []
    current_int = 2
    while(True):
        if (is_prime(current_int)):
            while(n % current_int == 0): #while loop for repeating prime factors
                n = n // current_int
                arr.append(current_int)
        if (n == 1): #condition for all primes extracted
            return arr
        current_int = current_int + 1

if __name__ == '__main__':
    while True:
        print(prime_factorization(int(input('> '))))