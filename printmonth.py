# program to print calendar of users selected month and day
# Miguel Lavarinhas
# 21 February 2023

month = input("Enter the name of a month (e.g. January, ..., December):\n")
start = eval(input("Enter the start day (1 for Monday, ..., 7 for Sunday):\n"))
valid = True

#Assigning days of month dependant on input and printing days of the week
if (month== "January" or month=="March" or month=="May" or month=="July" or month=="August" or month=="October" or month=="December") and start<=7:
    print(month)
    print("Mo Tu We Th Fr Sa Su")
    days=31
elif (month=="April" or month=="June" or month=="September" or month=="November") and start<=7:
    print(month)
    print("Mo Tu We Th Fr Sa Su")
    days=30
elif month=="February" and start <= 7:
    print(month)
    print("Mo Tu We Th Fr Sa Su")
    days=28   
else:
    print("Invalid calendar: you have either entered an incorrect month name or start day.")
    valid = False

#Code validating that input is in correct range and is a real month
if valid:
    number=1 
    while number < days:
        line = " "*(2*(start-1))+ (start-1)*" "
        if month == "February":
            line = 20*" "
        for row in range (6):
            while len(line)<20 and number <= days:
               #code creating a line to print
                    start+=1
                    if number <10 and number >=0:
                        line= line + " "+ str(number)+ " "
                    elif number == days+1:
                        line = line + (20-len(line))*" "
                    else:    
                        line= line + str(number)+ " "
                    number+=1
            print (line)  
            line =""            
            

