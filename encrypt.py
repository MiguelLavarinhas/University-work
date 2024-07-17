# program to encrypt a string
# Miguel Lavarinhas
# 23 April 2023

#input
text = input("Enter a message:\n")

def encrypt(text):
    """Function to change a every char in the string to the next char"""
    if text == "":
        return ""
    else:
        if text[0] == 'z':
            new = "a"
        elif text[0].islower():
            new = chr(ord(text[0])+1)
        else:
            new = text[0]
        return new + encrypt(text[1:])

print("Encrypted message:\n", encrypt(text),sep="")