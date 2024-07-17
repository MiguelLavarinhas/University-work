# program to calculate the area of a triangle
# Miguel Lavarinhas
# 27 February 2023

import math

side_1= float(input("Enter the length of the first side: "))
side_2= float(input("Enter the length of the second side: "))
side_3= float(input("Enter the length of the third side: "))
s = (side_1+side_2+side_3)/2
if (s* (s-side_1)*(s-side_2)*(s-side_3)>0):
  area= round(math.sqrt(s* (s-side_1)*(s-side_2)*(s-side_3)),2)
  print ("The area of the triangle with sides of length ",round(side_1,2)," and ",round(side_2,2)," and ",round(side_3,2)," is ",area,".",sep="")
else:
  print ("Error: The input does not describe a triangle.")

            