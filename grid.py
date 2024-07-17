# program to print grid of 41 number after the entered value
# Miguel Lavarinhas
# 21 February 2023

number = eval(input("Enter a number between -6 and 2:\n"))

#code to validate if the input is correct
if number > -6 and number < 2:
    if len(str(number))>=2:
        line= str(number) + " "
    else:
        line= " "+str(number)+ " "
    #code to create the grid
    for row in range(1,7):
        while len(line)<20:
            number+=1
            #code creating a line to print
            if number <10 and number >=0:
                line= line + " "+ str(number)+ " "
            else:    
                line= line + str(number)+ " "
        print (line)  
        line =""
else:
    print ("Invalid input! The value of 'n' should be between -6 and 2.")
    