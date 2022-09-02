# HW #00
# Author: Andy Zheng - zhengno@bc.edu
# 
def is_prime(n):
    if (n < 2):
        return False
    for i in range(2,n//2 + 1): #only need to search half the range due to factor pairings
        if (n % i == 0):
            return False
    return True

if __name__ == '__main__':
    while True:
        print(is_prime(int(input('> '))))