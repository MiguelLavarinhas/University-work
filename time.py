# program to validate the time that user input
# Miguel Lavarinhas
# 27 February 2023

hours = eval(input("Enter the hours: "))
mins = eval(input("Enter the minutes: "))
seconds = eval(input("Enter the seconds: "))

if (hours>=0) and (hours<=24) and (mins>=0) and (mins<=59) and (seconds>=0) and (seconds<=59):
    print ("Your time is valid.")
else:
        print ("Your time is invalid.")