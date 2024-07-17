import java.util.Scanner;
/**
 * The CarParkSim class contains the main car park simulation method.
 * It creates and manipulates the main objects, and handles user I/O.
 *
 * @author Stephan Jamieson and ...
 * @version 14/7/2019
 */
public class CarParkSim {
        
    public static void main(final String[] args) {
        final Scanner keyboard = new Scanner(System.in);
        // YOUR CODE HERE.
        // Declare variables to store a Clock and a Register object, create the relevant objects and assign them. 
        Register reg = new Register();
        Clock clock = new Clock(new Time("00:00"));
        
        System.out.println("Car Park Simulator");
        // YOUR CODE HERE.
        // Print current time.
        Time t = clock.examine();
        System.out.println("The current time is "+ t+".");
        System.out.println("Commands: advance {minutes}, arrive, depart, quit.");
        System.out.print(">");
        String input = keyboard.next().toLowerCase();
        while (!input.equals("quit")) {
            if (input.equals("advance")) {
                // YOUR CODE HERE.
                // Advance the clock, print the current time.
                clock.advance(new Duration("minute", keyboard.nextInt()));
                System.out.println("The current time is "+ clock.examine()+".");

            }
            else if (input.equals("arrive")) {
                // YOUR CODE HERE.
                // Create a new ticket, add it to the register, print details of ticket issued.
                Ticket ticket = new Ticket(clock.examine(),  UIDGenerator.makeUID());
                System.out.println("Ticket issued: "+ ticket.toString()+".");
                reg.add(ticket);
            }
            else if (input.equals("depart")) {
                // YOUR CODE HERE.
                // Determine if ticket is valid, i.e. in the register.
                // If not, print error message.
                // If yes, retreive it, calculate duration of stay and print it.
                String idIn = keyboard.next();
                if(reg.contains(idIn)){
                  Ticket t1 = reg.retrieve(idIn);
                  System.out.println("Ticket details: "+t1.toString()+".");
                  System.out.println("Current time: "+ clock.examine()+".");  
                  String d = Duration.format(t1.age(clock.examine()),"minute");
                  System.out.println("Duration of stay: "+d+".");
                }
                else
                {
                   System.out.println("Invalid ticket ID.");  
                }
            }
            else {
                System.out.println("That command is not recognised.");
                System.out.println("Commands: advance <minutes>, arrive, depart, quit.");
            }            
            System.out.print(">");
            input = keyboard.next().toLowerCase();
        }            
        System.out.println("Goodbye.");
    }

}
