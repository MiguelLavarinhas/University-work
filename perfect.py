# program to calculate whether a number is perfect or not
# Miguel Lavarinhas
# 7 March 2023

number = eval(input("Enter a number:\n"))
divisors = ""
sum_number =0
#code to find divisors of the entered number and add them together
for x in range(1,number):
    if number % x == 0:
        divisors = divisors + str(x) + " "
        sum_number += x
        
print ("The proper divisors of", number, "are:")
print (divisors, "\n")
#code to decide whether sum of divisors is equal to number and display accordingly
if number == sum_number:
    print (number,"is a perfect number.")
else:
    print (number,"is not a perfect number.")