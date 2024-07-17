# program to print the value of an equation of vectors
# Miguel Lavarinhas
# 18 April 2023

import math
line = "Choose an option:\n"+ "1. Magnitude of a vector\n"+"2. Vector addition\n"+"3. Scalar multiplication\n"+"4. Dot product of two vectors\n"+"5. Cross product of two 3-dimensional vectors\n"+"6. Exit"
print(line)
calc = int(input(""))
if str(calc) in "123456":
    
    while not calc ==6:
        #Obtaining magnitude
        if calc == 1:
            values= input("Enter the components of the vector separated by spaces:\n")
            v1 = eval(values[0:values.find(" ")])
            v2 = eval(values[values.find(" ")+1:len(values)+1])
            print("Magnitude of the vector is:", round(math.sqrt(v1**2+v2**2),1))
            print(line)
            calc = int(input(""))
        #Vector addition
        if calc == 2:
            value1= input("Enter the components of the first vector separated by spaces:\n")
            value2= input("Enter the components of the second vector separated by spaces:\n")
            if len(value1) == len(value2):
                v1 = eval(value1[0:value1.find(" ")]) + eval(value2[0:value2.find(" ")])
                v2 = eval(value1[value1.find(" ")+1:len(value1)+1]) + eval(value2[value2.find(" ")+1:len(value2)+1])
                print("Sum of the vectors is: (",v1,", ",v2,")",sep="")
            else:
                print("Error: Vectors must have the same length.")
            print(line)
            calc = int(input(""))
        #Scalar multiplication    
        if calc == 3:
            values = input("Enter the components of the vector separated by spaces:\n")
            scalar = int(input("Enter the scalar:\n"))
            print("Scalar multiplication of the vector is: (",scalar*eval(values[0:values.find(" ")]),", ",scalar*eval(values[values.find(" ")+1:len(values)+1]),")",sep="")
            print(line)
            calc = int(input(""))
        #Dot product   
        if calc == 4:
            value1= input("Enter the components of the first vector separated by spaces:\n")
            value2= input("Enter the components of the second vector separated by spaces:\n")
            if len(value1) == len(value2):
                v1 = eval(value1[0:value1.find(" ")]) * eval(value2[0:value2.find(" ")])
                v2 = eval(value1[value1.find(" ")+1:len(value1)+1]) * eval(value2[value2.find(" ")+1:len(value2)+1])
                print("Dot product of the vectors is:",v1+v2)
            else:
                print("Error: Vectors must have the same length.")
            print(line)
            calc = int(input(""))            
        #Cross product    
        if calc == 5:
            v1 = input("Enter the components of the first 3-dimensional vector separated by spaces:\n").split(" ")
            v2 = input("Enter the components of the second 3-dimensional vector separated by spaces:\n").split(" ")
            if len(str(v1)) == len(str(v2)):
                print ("Cross product of the vectors is: (",eval(v1[1])*eval(v2[2])-eval(v1[2])*eval(v2[1]),", ",eval(v1[2])*eval(v2[0])-eval(v1[0])*eval(v2[2]),", ",eval(v1[0])*eval(v2[1])-eval(v1[1])*eval(v2[0]),")",sep="")
            else:
                print ("Error: Vectors must have the same length and 3-dimensional.")
            print(line)
            calc = int(input(""))
    print ("Exiting...")
                


            
                                                                          
                                                                        

            
            
        