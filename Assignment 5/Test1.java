// Calculates Sum of Costs.
// Name: Miguel Lavarinhas
// Student Number: LVRMIG001
// Date: 31/07/23

import java.util.Scanner;

class Test1
{
public static void main (String [] args )
{
   Time tOne = new Time("6:50");
Ticket ticket = new Ticket(tOne, "8005A3");
Time tTwo = new Time("7:19");
System.out.println(ticket.toString());
System.out.println(ticket.ID());
Duration d = ticket.age(tTwo);
System.out.println(d.intValue("minute"));
}
}