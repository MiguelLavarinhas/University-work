// Reads File
// Name: Miguel Lavarinhas
// Student Number: LVRMIG001
// Date: 08/08/23

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class DemoProgram(String fileName) {
public static void main(final String[] args) throws FileNotFoundException
{
Scanner fileIn = new Scanner(new File(fileName));
   int count =  fileIn.nextInt();
   Seller[] records = new Seller[count];
   int counter = 0;
   if (fileIn.hasNextLine())
   {
      String firstLine = fileIn.nextLine();
      Scanner scanner = new Scanner(firstLine);
      scanner.useDelimiter("\\s*,\\s*");
      Seller shop = new Seller();
      shop.ID = scanner.next();
      shop.Name = scanner.next();
      shop.Product = scanner.next();
      Money price = new Money(scanner.next(), rand);
      shop.unit_price = price;
      shop.number_of_units = scanner.nextInt();
      records[counter] = shop;
      counter++;
   }
fileIn.close();
return records;
}