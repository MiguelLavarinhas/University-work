# program to doctest function for all cumulative paths
# Miguel Lavarinhas
# 18 April 2023

#different path tests
"""
>>> import palindrome
>>> palindrome.is_palindrome("") 
True
>>> palindrome.is_palindrome("b")
True
>>> palindrome.is_palindrome("racecar")
True
>>> palindrome.is_palindrome("shorty")
False
>>> palindrome.is_palindrome("saippuakivikauppias")
True
"""
import doctest
doctest.testmod(verbose=True)