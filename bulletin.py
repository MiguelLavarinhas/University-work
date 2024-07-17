# program to print BBS system for UCT and show messages for user inputs
# Miguel Lavarinhas
# 21 February 2023

#setting list to make display of options easier
text = ["Welcome to UCT BBS", "MENU","(E)nter a message","(V)iew message","(L)ist files","(D)isplay file","e(X)it","Enter your selection:"]
for i in range(8):
    print(text[i])
value = input("")
message =""

#Code to only run messages if input is not X
while value.lower() != "x":
    if value.lower() == "e":
        message = input("Enter the message:\n")
        for i in range(8):
            print(text[i])
        value = input("")        
    if value.lower() == "v":
        if len(message) > 0:
            print ("The message is:",message)
        else:
            print ("The message is: no message yet")
        for i in range(8):
            print(text[i])
        value = input("")          
    if value.lower() == "l":
        print ("List of files: 42.txt, 1015.txt")
        for i in range(8):
            print(text[i])
        value = input("")
    if value.lower() == "d":
        filename = input("Enter the filename:\n")
        #validating correct input
        if filename== "42.txt":
            print("The meaning of life is blah blah blah ...")
        elif filename == "1015.txt":
            print("Computer Science class notes ... simplified","Do all work","Pass course","Be happy",sep="\n")
        else:
            print("File not found")
            
        for i in range(8):
            print(text[i])
        value = input("")  
print ("Goodbye!")
        