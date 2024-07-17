import math


def day_of_week(day, month, year):
    # Your code here
    week_number = 0
    h = 0
    year = int(year)
    if month == 1 or month == 2:
        h = math.floor(( day + (13*(month+13)/5) + (year-1) +(year-1)/4 - (year-1)/100 + (year-1)/400) % 7)
    else:
        h = math.floor(( day + (13*(month+1)/5) + (year) +(year)/4 - (year)/100 + (year)/400) % 7)
    week_number = ((h + 5) %7)+1
    #Assigning week
    if week_number == 0:
        return 6
    if week_number == 1:
        return 7
    if week_number == 2:
        return 1
    if week_number == 3:
        return 2    
    if week_number == 4:
        return 3
    if week_number == 5:
        return 4
    if week_number == 6:
        return 5

def is_leap(year):
    # Your code here
    if (int(year)%400==0) or ((int(year)%4==0) and (int(year)%100>0)):     
        return True
    else:
        return False
    

def month_num(month_name):
    # Your code here
    if month_name.lower() == "january":
        return 1
    if month_name.lower() == "february":
        return 2
    if month_name.lower() == "march":
        return 3
    if month_name.lower() == "april":
        return 4
    if month_name.lower() == "may":
        return 5
    if month_name.lower() == "june":
        return 6
    if month_name.lower() == "july":
        return 7
    if month_name.lower() == "august":
        return 8
    if month_name.lower() == "september":
        return 9
    if month_name.lower() == "october":
        return 10
    if month_name.lower() == "november":
        return  11
    if month_name.lower() == "december":
        return  12
        
    
def num_days_in(month_num, year):
    # Your code here
    if (month_num== 1 or month_num==3 or month_num==5 or month_num==7 or month_num==8 or month_num==10 or month_num==12):
        return 31
    elif (month_num==4 or month_num==6 or month_num==9 or month_num==11):
        return 30
    elif month_num==2 and is_leap(year)== False:
        return 28   
    else:
        return 29

def num_weeks(month_num, year):
    # Your code here
    firstday = day_of_week(1,month_num,year)
    monthNum = month_num - (7-firstday)
    weeks= 1
    while monthNum > 7:
        monthNum -=7
        weeks+=1
    if month_num == 1:
        return 5
    else:
        return weeks +1 
        
    
    
        

def week(week_num, start_day, days_in_month):
    # Your code here
    if week_num == 1:
        day = 0
        week = " "*(2*(start_day-1))+ (start_day-1)*" "
        for i in range(start_day,8):
            day += 1
            if day < 10:
                week += " "+str(day) + " "
            else:
                week += str(day) + " "
        return week
         
    if week_num > 1:
        day = 7-(7-start_day)-1
        for x in range(week_num-1):
            week=""
            if day < days_in_month:
                for z in range(7):
                    if day < 10:
                        week += " "+str(day) + " "
                    else:
                        week += str(day) + " "
                    day += 1
        return week
                
           

        
        
    


def main():
    # Your code here
    month = input("Enter month:\n")
    year= input("Enter year:\n")
    monthNum = month_num(month)
    dayCount= num_days_in(monthNum, year)
    weeksNum = num_weeks(monthNum, year)
    print(month,"\nMo Tu We Th Fr Sa Su")
    for i in range(1,weeksNum+1):
        print (week(i,day_of_week(1,monthNum,year),dayCount))
    

               


if __name__=='__main__':
    main()






