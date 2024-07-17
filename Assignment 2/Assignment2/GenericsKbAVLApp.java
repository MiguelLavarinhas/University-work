   /**
 * This class loads a large amount of statements into a AVL tree and then allows the user to use a menu of options to access the statements.
 *
 * @author Miguel Lavarinhas
 * @version 1.0
 * @since 20/03/2024
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

public class GenericsKbAVLApp {
    /**
    * Time taken to insert file.
    */
    static long timetaken1;
    /**
    * Time taken to search file.
    */
    static long timetaken2;
    /**
    * Combination of timetaken1 and timetaken2.
    */
    static long finalTime;
   /**
    * Prints the list of actions the user can take.
    */
   public static void userAction(){
        System.out.print("Choose an action from the menu:\n"
        +"1. Load a knowledge base from a file\n"
        +"2. Search for statements by entering new file\n"
        +"3. Test with random subset\n"
        +"4. Get Statistical summary of main dataset\n"
        +"5. End program\n"
        +"Enter your choice ");
    }
    /**
    * Prints a list of statistics relating to the two files entered.
    */
    public static void getStats(){
      double lowest = 0;
      double highest = 0;
      double average = 0;
      
      Statement[] statements = new Statement[50000];
      int count = 0;
      try{
        Scanner scanner = new Scanner(new File("GenericsKB.txt"));
        //Reading textfile into array.
        while(scanner.hasNextLine()){
           String[] three = scanner.nextLine().split("\t");
           Statement line = new Statement(three[0],three[1],Double.parseDouble(three[2]));
                 statements[count++] = line;             
           }       
        scanner.close();
      }
      //Catches error if file is not found.
      catch(FileNotFoundException e){
        System.err.println("File not found: " + e.getMessage());
      }  

      for(Statement statement: statements){
        average += statement.getConfidence();
        if (statement.getConfidence() > highest) {
          highest = statement.getConfidence();
        }
        if (statement.getConfidence() < lowest) {
          lowest = statement.getConfidence();
        }
      }
      average= average/count;
      System.out.println("\nStatistics summary:\n"+ "Highest confidence score: "+ highest+ "\nLowest confidence score: "+ lowest+ "\nAverage confidence score: "+average);
      finalTime= timetaken1+ timetaken2;
      System.out.println("Time taken to run: "+ finalTime+" ms.\n");
    }

    
   /**
    * Main method to load the a AVL Tree and allow user to interact with the options.
    * @param args Command line arguments (not used)
    */
   public static void main (String [] args )
   {
      //Initialising an AVL Tree to store statements.
      AVLTree bt = new AVLTree<>();
      final Scanner keyboard = new Scanner(System.in); 
      String in;
      finalTime =0;
      ArrayList<Integer> insert = new ArrayList<Integer>();
      ArrayList<Integer> search = new ArrayList<Integer>();
      
      do{
        userAction();
         in = keyboard.nextLine();
        switch (in) {
         
         case "1":
               System.out.println();
               System.out.println("Enter file name: ");
               String file1 = keyboard.nextLine();
               long start = System.currentTimeMillis();
               try{
                  Scanner scanner = new Scanner(new File(file1));
                  //Reading textfile into array.
                  while(scanner.hasNextLine()){
                     String[] three = scanner.nextLine().split("\t");
                     Statement line = new Statement(three[0],three[1],Double.parseDouble(three[2]));
                     //Adds to the AVL tree.
                     BinaryTreeNode <Statement> updated = new BinaryTreeNode<>(line,null,null);
                     bt.insert(updated.data);
                     insert.add(bt.getInsertCount());
                     bt.resetInsertCount();;
                     }
                  scanner.close();
                  System.out.println("Knowledge base loaded successfully.");
                  timetaken1 = System.currentTimeMillis() - start;
                  }
                  //Catches error if file is not found.
                catch(FileNotFoundException e){
                  System.err.println("File not found: " + e.getMessage());
                }  
               break;
          //Code to read the second file and compare the terms in the second file to that of the first.     
        case "2":
            System.out.println();
            System.out.println("Enter file name: ");
            file1 = keyboard.nextLine();
            start = System.currentTimeMillis();
            try{
               Scanner scanner = new Scanner(new File(file1));
               //Reading textfile into String.
               while(scanner.hasNextLine()){
                  String term = scanner.nextLine();
                  Statement line = new Statement(term,"",0);
                  //Checks if the term is found in the AVL tree.
                  BinaryTreeNode <Statement> updated = new BinaryTreeNode<>(line,null,null);
                  BinaryTreeNode <Statement> found = bt.find(updated.data);
                  search.add(bt.getSearchCount());
                  bt.resetSearchCount();;
                  
                  if(found != null){ 
                    System.out.println("Statement found for "+found.data.getTerm()+ ": "+ found.data.getSentence()+ "("+found.data.getConfidence()+")");
                  }
                  else{
                   System.out.println("Statement for term "+updated.data.getTerm()+ " not found.");
                  }
                }

               
               scanner.close();
               System.out.println("Knowledge base loaded successfully.");
               double insertAVG = 0;
        double searchAVG = 0;
        for(int i=0;i<insert.size();i++){
          insertAVG+=insert.get(i);
        }
        insertAVG= insertAVG/insert.size();
        for(int i=0;i<search.size();i++){
          searchAVG+=search.get(i);
        }
        searchAVG= searchAVG/search.size();
        long timetaken = System.currentTimeMillis() - start;
        System.out.println("The number of insert operations:\nBest case: "+ Collections.min(insert)+"\nAverage case: "+insertAVG+"\nWorst case: "+Collections.max(insert));
        System.out.println("The number of search operations:\nBest case: "+ Collections.min(search)+"\nAverage case: "+searchAVG+"\nWorst case: "+Collections.max(search));
               timetaken2 = System.currentTimeMillis()-start;
              }
               //Catches error if file is not found.
             catch(FileNotFoundException e){
               System.err.println("File not found: " + e.getMessage());
             }  
            break; 
            //Code to Call TestSubset class and create and run through a subset for testing.
            case"3":
              System.out.println();
              System.out.println("Enter amount of test entries: ");
              String entries = keyboard.nextLine();
              TestSubset test = new TestSubset( Integer.valueOf(entries));
              test.createSubset();
              test.runCode();
            break;
            //Code to view stats about the two entered files
            case"4":
            getStats();
            break;
            //Code to exit
            case "5":
            System.out.println("Exiting...");
            break;
        default:
            System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            break;
    }
    } 
    while (!in.equals("5"));
        keyboard.close();
    }
}
