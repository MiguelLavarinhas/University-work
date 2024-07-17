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
        //Creating tarifftable.
        Currency currency = new Currency("R", "ZAR", 100);
        TariffTable tariffs = new TariffTable(10);
        TimePeriod p1 = new TimePeriod(new Duration("minute",0), new Duration("minute",30));
        TimePeriod p2 = new TimePeriod(new Duration("minute",30), new Duration("minute",60));
        TimePeriod p3 = new TimePeriod(new Duration("minute",60), new Duration("minute",180));
        TimePeriod p4 = new TimePeriod(new Duration("minute",180), new Duration("minute",240));
        TimePeriod p5 = new TimePeriod(new Duration("minute",240), new Duration("minute",300));
        TimePeriod p6 = new TimePeriod(new Duration("minute",300), new Duration("minute",360));
        TimePeriod p7 = new TimePeriod(new Duration("minute",360), new Duration("minute",480));
        TimePeriod p8 = new TimePeriod(new Duration("minute",480), new Duration("minute",600));
        TimePeriod p9 = new TimePeriod(new Duration("minute",600), new Duration("minute",720));
        TimePeriod p10 = new TimePeriod(new Duration("minute",720), new Duration("hour",24));
        tariffs.addTariff(p1, new Money("R10.00", currency));
        tariffs.addTariff(p2, new Money("R15.00", currency));
        tariffs.addTariff(p3, new Money("R20.00", currency));
        tariffs.addTariff(p4, new Money("R30.00", currency));
        tariffs.addTariff(p5, new Money("R40.00", currency));
        tariffs.addTariff(p6, new Money("R50.00", currency));
        tariffs.addTariff(p7, new Money("R60.00", currency));
        tariffs.addTariff(p8, new Money("R70.00", currency));
        tariffs.addTariff(p9, new Money("R90.00", currency));
        tariffs.addTariff(p10, new Money("R100.00", currency));
        
        
        System.out.println("Car Park Simulator");
        // YOUR CODE HERE.
        // Print current time.
        Time t = clock.examine();
        System.out.println("The current time is "+ t+".");
        System.out.println("Commands: tariffs, advance {minutes}, arrive, depart, quit.");
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
                Ticket ticket = new Ticket(clock.examine());
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
                  System.out.println("Cost of stay : "+ tariffs.getTariff(t1.age(clock.examine()))+".");
                }
                else
                {
                   System.out.println("Invalid ticket ID.");  
                }
            }
            else if (input.equals("tariffs")){
               //Code to display what tariffs there are.
               System.out.println(tariffs.toString());
            }
            else {
                System.out.println("That command is not recognised.");
                System.out.println("Commands: tariffs, advance <minutes>, arrive, depart, quit.");
            }            
            System.out.print(">");
            input = keyboard.next().toLowerCase();
        }            
        System.out.println("Goodbye.");
    }

}
