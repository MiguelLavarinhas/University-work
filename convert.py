# program to change the format of the date and time entered
# Miguel Lavarinhas
# 24 March 2023

#slicing string to get values
text = input("Enter the date and time (yyyy-mm-dd hh:mm):\n")
year = text[2:4]
text = text[text.find("-")+1: len(text)]
month = int(text[0:2])
text = text[text.find("-")+1: len(text)]
day = int(text[0:2])
hour = int(text[text.find(" ")+1: text.find(":")])
minute = text[text.find(":")+1: len(text)+1]
time = "am"
#using if statements to determine month and time
if month == 1:
    month1 = "January"
if month == 2:
    month1 = "February"
if month == 3:
    month1 = "March"
if month == 4:
    month1 = "April"    
if month == 5:
    month1 = "May"
if month == 6:
    month1 = "June"
if month == 7:
    month1 = "July"
if month == 8:
    month1 = "August"
if month == 9:
    month1 = "September"    
if month == 10:
    month1 = "October"
if month == 11:
    month1= "November"
if month == 12:
    month1= "December"
#assigning correct suffixes to time and day   
if hour >= 12 and hour < 24:
    hour = hour - 12
    time = "pm"
if hour == 0:
    hour = 12
if day == 1 or day == 21 or day == 31:
    suffix = "st"
elif day == 2 or day == 22:
    suffix = "nd"
elif day==3 or day ==23:
    suffix= "rd"
else:
    suffix = "th"
print (hour, ":",minute," ",time," on the ",day,suffix," of ",month1," '",year,sep="")