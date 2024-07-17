// Calculates Duration between two times.
// Name: Miguel Lavarinhas
// Student Number: LVRMIG001
// Date: 31/07/23

import java.util.Scanner;

class CalculateDuration
{
public static void main (String [] args )
{
 System.out.println ("Enter time A:");
 Scanner keyboard = new Scanner(System.in);
 String time1 = keyboard.nextLine();
 System.out.println ("Enter time B:");
 String time2 = keyboard.nextLine();
 Time t1 = new Time(time1);
 Time t2 = new Time(time2);
 Duration td = t2.subtract(t1);
 System.out.print("The time ");
 System.out.print(t2);
 System.out.print(" occurs ");
 System.out.print(td.intValue("minute"));
 System.out.print( " minutes after the time ");
 System.out.print(t1);
 System.out.print(".");
}
}