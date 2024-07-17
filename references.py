# program to change the format of the entered reference
# Miguel Lavarinhas
# 24 March 2023

line = input("Enter the reference:\n")
#new = line
#changing autor format
new_author = line[0:line.find("(")].title()
new = line.replace(line[0:line.find("(")] , new_author)
#changing title
commas = 0
comma2 =0
#finding position of second comma
length = line[0:line.find(",")+1]
newline = line.replace(line[0:line.find(",")+1], len(length)*" ")
comma2= newline.find(",")
#creating new line that fits format
new_title = line[line.find(")")+2].upper()
new_title = new_title + line[line.find(")")+3:comma2].lower()
new2 =  new.replace(line[line.find(")")+2: comma2] , new_title)  

print ("Reformatted reference:")
print (new2)
