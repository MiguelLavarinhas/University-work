// Creates Register object.
// Name: Miguel Lavarinhas
// Student Number: LVRMIG001
// Date: 19/08/23

import java.util.Scanner;

class Register
{
   private Ticket[] tickets;
   private int numTickets;
   
   //Constructor
   public Register(){
      // Creates new object
      numTickets = 0;   
      tickets = new Ticket[100];     
   }
   
   //SetMethod
   public void add(Ticket ticket){
      // Stores ticket.
      tickets[numTickets] = ticket;
      numTickets++;
   }
   
   public boolean contains(String ticketID){
      // See if ticket is in register.
      boolean found = false;
      for(int n=0; n<numTickets ; n++){
         Ticket con = tickets[n];
         String id1 = con.ID();
         if(id1.equals(ticketID)){
         found = true; 
         }  
      } 
      return found;
   }
      
   public Ticket retrieve(String ticketID){
      //Obtain the ticket from the ID.
      int found = 0;
      for(int n=0; n<numTickets; n++){
         if(tickets[n].ID().equals(ticketID))
         found = n;
      }
      return tickets[found];
   }
}   
   