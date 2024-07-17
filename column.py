# program to generate a sequence of numbers starting with the user's input and increasing by 7 till n + 41
# Miguel Lavarinhas
# 7 March 2023

start = eval(input("Enter a number:\n"))
if start > -6 and start < 2:
  #code to assign space in front of user input number if shorter than 2 characters
  if len(str(start)) >=2:
    print (start)
  else:
    print ( " " ,start,sep="")

  #code to decide whether next number in sequence is the 7th number and 2 characters long and assign it a space dependant on that
  new_number = start
  while new_number < start + 41:
      new_number += 1
      if (new_number-start)%7==0 and len(str(new_number)) >= 2:
        print( new_number)
      elif (new_number-start)%7==0:
        print ( " ",new_number,sep="")
else:
  #code to print message if entered value is not within range
  print ("Enter number between -6 and 2.")