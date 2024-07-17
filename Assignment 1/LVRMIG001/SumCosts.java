// Calculates Sum of Costs.
// Name: Miguel Lavarinhas
// Student Number: LVRMIG001
// Date: 31/07/23

import java.util.Scanner;

class SumOfCosts
{
public static void main (String [] args )
{
System.out.println("Enter an amount or '[D]one' to quit:");
Scanner keyboard = new Scanner(System.in);
String line = keyboard.nextLine();
Currency rand = new Currency("R", "ZAR", 100);
Money money = new Money("R0.00", rand);
while (line.charAt(0) != 'D'){
   Money addition = new Money(line, rand);
   money = money.add(addition);
   System.out.println("Enter an amount or '[D]one' to quit:");
   line = keyboard.nextLine();
}
System.out.print("Total: ");
System.out.print(money.toString());
}
}