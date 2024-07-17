// Creates a list oject of three derived classes.
// Name: Miguel Lavarinhas
// Student Number: LVRMIG001
// Date: 19/09/23

import java.util.*;

public class Question1
{
   //Creating base class list
   private static List<Computer> computer;
   private static int count;
   
   public static void main(String []args){
      computer = new ArrayList<Computer>();
      count = 0;
      System.out.println("Welcome to Great International Technology"+"\n"+"MENU: add (B)ox, add (S)creen, add (A)ccessories, (D)elete, (L)ist, (Q)uit");
      Scanner keyboard = new Scanner(System.in);
      String input = keyboard.nextLine().toLowerCase();
      //Looping through as long as input is not quit
      while(input.equals("q")== false){
            if(input.equals("b")){
               System.out.println("Enter the serial number");
               String s = keyboard.nextLine();
               System.out.println("Enter the manufacturer");
               String m =  keyboard.nextLine();
               System.out.println("Enter the colour");
               String c = keyboard.nextLine();
               System.out.println("Enter the amount of memory (MB)");
               String mem = keyboard.nextLine();
               Box b = new Box(s,m,c,mem);
               computer.add(b);
               count++;
               System.out.println("Done");
               System.out.println("MENU: add (B)ox, add (S)creen, add (A)ccessories, (D)elete, (L)ist, (Q)uit");
               input = keyboard.nextLine().toLowerCase();
               } 
            if(input.equals("s")){
               System.out.println("Enter the serial number");
               String s2 = keyboard.nextLine();
               System.out.println("Enter the manufacturer");
               String m2 = keyboard.nextLine();
               System.out.println("Enter the colour");
               String c2 = keyboard.nextLine();
               System.out.println("Enter the screen size in inches");
               String size = keyboard.nextLine();
               Screen screen = new Screen(s2,m2,c2,size);
               computer.add(screen);
               count++;
               System.out.println("Done");
               System.out.println("MENU: add (B)ox, add (S)creen, add (A)ccessories, (D)elete, (L)ist, (Q)uit");
               input = keyboard.nextLine().toLowerCase();
               } 
            if(input.equals("a")){
               System.out.println("Enter the serial number");
               String s3 = keyboard.nextLine();
               System.out.println("Enter the manufacturer");
               String m3 = keyboard.nextLine();
               System.out.println("Enter the colour");
               String c3 = keyboard.nextLine();
               Accessory accessory = new Accessory(s3,m3,c3);
               computer.add(accessory);
               count++;
               System.out.println("Done");
               System.out.println("MENU: add (B)ox, add (S)creen, add (A)ccessories, (D)elete, (L)ist, (Q)uit");
               input = keyboard.nextLine().toLowerCase();
               } 
            if(input.equals("d")){
            //Deleting out of list
               System.out.println("Enter the serial number");
               String s4 = keyboard.nextLine();
               boolean found = false;
               for(int i=0; i<computer.size(); i++){
                  if( computer.get(i).getSerial().equals(s4) ){
                     computer.remove(i);
                     found = true;
                     count--;
                     }
                  }
                  if(found){
                  System.out.println("Done");
                  }else{
                  System.out.println("Not found");
                  } 
               System.out.println("MENU: add (B)ox, add (S)creen, add (A)ccessories, (D)elete, (L)ist, (Q)uit");
               input = keyboard.nextLine().toLowerCase();                  
               } 
               
                
            if(input.equals("l")){
            //Listing objects in the array
               if(count > 0){
               for(int i=0;i<count;i++){
                System.out.println(computer.get(i).toString());
                }
                }
                
                System.out.println("Done");
                System.out.println("MENU: add (B)ox, add (S)creen, add (A)ccessories, (D)elete, (L)ist, (Q)uit");
                input = keyboard.nextLine().toLowerCase();
               }                   
      }

   }
}

