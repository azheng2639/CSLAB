# HW #00
# Author: Andy Zheng - zhengno@bc.edu
# 

from math import log
from is_prime import is_prime

#initiating cache
cache = [2]
current_prime = 2

def nth_prime(n):
    global current_prime
    if (n <= len(cache)): #cache hit
        return cache[n - 1]
    else: #cache miss
        while (n > len(cache)):
            for i in range(current_prime + 1, 2 * int(n * log(n))): #approximate from current prime to upper bound of prime
                if (is_prime(i)):
                    cache.append(i)
    # store last element of cache as current prime
    current_prime = cache[-1]
    return cache[n - 1]


if __name__ == '__main__':
    while True:
        print(nth_prime(int(input('> '))))