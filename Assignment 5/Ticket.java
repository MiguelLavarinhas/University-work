// Creates Ticket object.
// Name: Miguel Lavarinhas
// Student Number: LVRMIG001
// Date: 19/08/23

import java.util.Scanner;

class Ticket
{
   private String id;
   private Time issueTime;
   
   //Constructor
   public Ticket(Time currentTime, String ID){
      // Set the istance variables of the ticket object.
      id = ID;
      issueTime = currentTime;
            
   }
   
   //GetMethod
   public String ID(){
      // Obtain the ID of ticket.
      return id;
   }
   
   //GetMethod
   public Duration age(Time currentTime){
      // Obtain the age of the ticket.
      Duration timer = currentTime.subtract(issueTime);
      return timer;
   }
      
   //GetMethod
   public String toString(){
      // Obtain the string output of the object.
      //String UID = UIDGenerator.makeUID();
      String out = "Ticket[id="+ id+", time="+issueTime.toString()+"]";
      return out;
   }

}