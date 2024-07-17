# program to break up a sentence into a list of words seperated by commas
# Miguel Lavarinhas
# 24 March 2023

line = input("Enter a sentence:\n")
if line.count(" ")>0:
    sentence = line[0:line.find(" ")].lower()   
    line = line[line.find(" ")+1: len(line)]
    spaces = line.count(" ")
    #code to add new word after every space found
    for i in range(spaces):
        sentence = sentence +", "+ line[0:line.find(" ")].lower()
        #removes parts of the line already added
        line = line[line.find(" ")+1: len(line)]  
    sentence = sentence +", "+ line.lower()
else:
    sentence= line.lower()
print ("The word list: ",sentence,".",sep="")