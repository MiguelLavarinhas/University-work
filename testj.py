# program to count number of adjacent odd-even pairs
# Miguel Lavarinhas
# 14 April 2023

number = input("Enter a number or 'DONE' to finish:\n")
count = 0

while number != "DONE":
    first = eval(number)
    number = input("Enter a number or 'DONE' to finish:\n")
    if number != "DONE":
        second = eval (number)
        if first%2>0 and second%2==0:
            count+=1
print("The number of pairs of adjacent odd-even numbers is: ",count,".",sep="")