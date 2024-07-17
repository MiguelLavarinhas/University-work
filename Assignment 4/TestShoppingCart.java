// Creates shopping cart of items purchased and creates receipt.
// Name: Miguel Lavarinhas
// Student Number: LVRMIG001
// Date: 14/08/23

import java.util.Scanner;

class TestShoppingCart
{
public static void main (String [] args )
{
System.out.println("How many items would you like to add to your Shopping Cart?:");
Scanner keyboard = new Scanner(System.in);
int count = Integer.parseInt(keyboard.nextLine());
if(count == 0){
   System.out.println("Your Shopping Cart is empty.");
   }  
   else
   {
      //Creating shopping cart object
      ShoppingCart trolley = new ShoppingCart();
      int r =0;
      while(count>r){
         //Creating item objects and adding them to shopping cart
         System.out.println("Enter the Product Name:");
         String product = keyboard.nextLine();
         System.out.println("Enter the Quantity:");
         int quantity = Integer.parseInt(keyboard.nextLine());
         System.out.println("Enter the Unit Cost:");
         Double cost = Double.parseDouble(keyboard.nextLine());
         Item t = new Item(product,quantity, cost);
         trolley.addItems(t);
         r++;
         }
   trolley.getDiscount("WELCOME20");
   System.out.println("The Shopping Cart has the following items:");
   trolley.queryCart();
   System.out.println("--- Shopping Cart with all items ---");
   trolley.printInvoice();
   }
}
}