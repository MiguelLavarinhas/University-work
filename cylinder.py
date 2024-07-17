# program to change the format of the entered reference
# Miguel Lavarinhas
# 24 March 2023

import math
def circle_area(diameter):
    # Your code here
    return 0.25*math.pi*diameter**2
def cylinder_volume(area, height):
    # Your code here
    return float(area * height)
def main():
    # Your code here
    diameter = eval(input("Enter diameter:\n"))
    height = eval(input("Enter height:\n"))
    print ("The volume of the cylinder is","{:.2f}".format(cylinder_volume(circle_area(diameter),height)))
if __name__=='__main__':
    main() 