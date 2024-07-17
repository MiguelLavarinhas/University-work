# program to doctest function for all cumulative paths
# Miguel Lavarinhas
# 18 April 2023

#different path tests
"""
>>> import numberutil
>>> numberutil.aswords(0) 
'zero'
>>> numberutil.aswords(7)
'seven'
>>> numberutil.aswords(100)
'one hundred'
>>> numberutil.aswords(21)
'twenty one'
>>> numberutil.aswords(40)
'forty'
>>> numberutil.aswords(115)
'one hundred and fifteen'
>>> numberutil.aswords(526)
'five hundred and twenty six'
>>> numberutil.aswords(999)
'nine hundred and ninety nine'
"""
import doctest
doctest.testmod(verbose=True)