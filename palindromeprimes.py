# program to print palindrome primes between two points
# Miguel Lavarinhas
# 23 April 2023

import sys
sys.setrecursionlimit(30000)

#Inputs
n = int(input("Enter the starting point N:\n"))
m = int(input("Enter the ending point M:\n"))

def palindrome(n):
    """Finding palindromes"""
    if len(str(n)) <= 1:
        return True
    else:
        string = str(n)
        return string[0] == string[-1] and palindrome(string[1:-1])

def prime(n, c =2):
    """Finding primes"""
    if n < 2:
        return False
    elif n == 2:
        return True
    elif n % c == 0:
        return False
    elif c * c > n:
        return True
    else: 
        return prime(n, c+1)
    
def palindromeprimes(n,m):
    """Finding out if number is a palindrome and a prime and printing it"""
    if n > m:
        return
    elif palindrome(n) and prime(n):
        print(n)
    palindromeprimes(n+1,m)

print("The palindromic primes are:")
palindromeprimes(n,m)

