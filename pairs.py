# program to find amount of pairs in a string
# Miguel Lavarinhas
# 23 April 2023

#input
text = input("Enter a message:\n")

def pairs(s):
    """Function that finds amount of pairs in a string"""
    if len(s) <= 1:
        return 0
    elif s[0] == s[1]:
        return 1+ pairs(s[2:])
    else:
        return pairs(s[1:])
        
print("Number of pairs:",pairs(text))  

        
    