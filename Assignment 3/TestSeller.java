// Creates shop model and fills attributes.
// Name: Miguel Lavarinhas
// Student Number: LVRMIG001
// Date: 08/08/23

import java.util.Scanner;

class TestSeller
{
public static void main (String [] args )
{
   //creating object
   Seller shop1 = new Seller();
   Scanner keyboard = new Scanner(System.in);
   Currency rand = new Currency("R", "ZAR", 100);

   //Retrieving details
   System.out.println("Please enter the details of the seller.");
   System.out.print("ID: ");
   String line = keyboard.nextLine();
   shop1.ID = line;
   System.out.print("Name: ");
   line = keyboard.nextLine();
   shop1.Name = line;
   System.out.print("Location: ");
   line = keyboard.nextLine();
   shop1.Location = line;
   System.out.print("Product: ");
   line = keyboard.nextLine();
   shop1.Product = line;
   System.out.print("Price: ");
   line = keyboard.nextLine();
   Money price = new Money(line, rand);
   shop1.unit_price = price;
   System.out.print("Units: ");
   line = keyboard.nextLine();
   shop1.number_of_units =  Integer.parseInt(line);
   System.out.println("The seller has been successfully created:");
   System.out.println("ID of the seller: "+ shop1.ID);
   System.out.println("Name of the seller: "+ shop1.Name);
   System.out.println("Location of the seller: "+ shop1.Location);
   System.out.println("The product to sell: "+ shop1.Product);
   System.out.println("Product unit price: "+shop1.unit_price);
   System.out.println("The number of available units: "+shop1.number_of_units); 
}
}