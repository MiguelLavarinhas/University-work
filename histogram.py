# program to Display histogram according to marks
# Miguel Lavarinhas
# 18 April 2023

marks = input("Enter a space-separated list of marks:\n")
                
counts = [0, 0, 0, 0, 0]  # initialize counters for each category

for i in marks.split(" "):
    mark = int(i)
    if mark < 50:
        counts[0] += 1
    elif mark < 60:
        counts[1] += 1
    elif mark < 70:
        counts[2] += 1
    elif mark < 75:
        counts[3] += 1
    else:
        counts[4] += 1

print ("1 |", counts[4]*"x",sep="")
print ("2+ |", counts[3]*"x",sep="")
print ("2- |", counts[2]*"x",sep="")
print ("3 |", counts[1]*"x",sep="")
print ("F |", counts[0]*"x",sep="")
        
