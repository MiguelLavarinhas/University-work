import java.io.File;
import java.io.FileNotFoundException;
//
import java.util.Scanner;
/**
 * See Assignment II Question II
 *
 * @author Stephan Jamieson
 * @version 26/7/2019
 */
public class MarketPlace {
    
    private MarketPlace() {}
    
    private final static Currency RAND = new Currency("R", "ZAR", 100);
    
    
    // Create an instance of Seller with attributes ID, name, location, product, 
    // unit_price and number_of_units
    private static Seller makeSeller(final String data) {
        final Scanner scanner = new Scanner(data.trim());
        scanner.useDelimiter("\\s*,\\s*");
        
        // Add your code here
        Seller shop = new Seller();
        shop.ID = scanner.next();
        shop.Name = scanner.next();
        shop.Location = scanner.next();
        shop.Product = scanner.next();
        Money price = new Money(scanner.next(), RAND);
        shop.unit_price = price;
        shop.number_of_units = scanner.nextInt();
        
        return shop;
    }
    
    // Read the contents of CSV file into an array.
    // See the Appendix on page 4 of the Assignment sheet.
    private static Seller[] parseFile(final String fileName) throws FileNotFoundException {
        final Scanner inFile = new Scanner(new File(fileName));
        Seller[] sellers = null;
    
        if (inFile.hasNextLine()) {
            sellers = new Seller[Integer.parseInt(inFile.nextLine().trim())];
            for (int index=0; index<sellers.length; index++) {
                sellers[index] = makeSeller(inFile.nextLine());
            }
        }
        inFile.close();
        return sellers;
    }
    
    public static void main(final String[] args) throws FileNotFoundException {
        final Scanner inKey = new Scanner(System.in);
        System.out.println("Enter the name of a \"Comma Separated Values\" (CSV) file:");
        final Seller[] sellers = parseFile(inKey.nextLine());
        
        // Your Code here
        
        if (sellers.length == 0 || sellers == null)
        {
        System.out.println("The file contains no seller data.");
        
    }
    else
    {
    System.out.println("Enter the name of a product:");
        String productName = inKey.nextLine();
        System.out.println("Enter the number of units required:");
        int units = inKey.nextInt();
        System.out.println("Enter the maximum unit price:");
        String price = inKey.next();
        Money max =  new Money(price, RAND);
        int found = 0;
        int r;
        for (r = 0; r< sellers.length ; r++)
        {
            if((sellers[r].unit_price.compareTo(max) <= 0) && (sellers[r].Product.equals(productName)) && (sellers[r].number_of_units >= units)){
               System.out.println(sellers[r].ID + " : "+ sellers[r].Name + " in "+ sellers[r].Location + " has "+ sellers[r].number_of_units + " " + sellers[r].Product +" for " +sellers[r].unit_price + " each.");
               found ++;
            }
        }
        if(found == 0)
        System.out.println("None found.");
    }
    }
    
}
