# program to print the values in an array of the given coordinates
# Miguel Lavarinhas
# 18 April 2023

#receiving values and putting them in a list
array = input("Enter an array:\n")
list2 = [ ]
for i in range(9):
    list1 = [ ]
    for x in range(9):
        list1.append(array[x])
    list2.append(list1)
    array = array[9:len(array)+1]
    
#receiving coordinates and printing values in array
coordinates = input("Enter coordinates:\n")
while not coordinates[0:2] == "-1" and not coordinates[2:4] == "-1" and not coordinates[3:5] == "-1":
    print ("Value =",list2[int(coordinates[0])][int(coordinates[2])])
    coordinates = input("Enter coordinates:\n")
else:
    print ("DONE")
    