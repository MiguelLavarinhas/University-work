/**
 * This class loads a large amount of statements into an array and then allows the user to use a menu of options to access the statements.
 *
 * @author Miguel Lavarinhas
 * @version 1.0
 * @since 25/02/2024
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class GenericsKbArrayApp
{
   /**
     * Counts the total number of statements.
     */
   static int count;
   /**
     * Array that holds the statements.
     */
   static Statement[] statements;
    /**
     * Prints the list of actions the user can take.
     */
    public static void userAction(){
        System.out.print("Choose an action from the menu:\n"
        +"1. Load a knowledge base from a file\n"
        +"2. Add a new statement to the knowledge base\n"
        +"3. Search for an item in the knowledge base by term\n"
        +"4. Search for a item in the knowledge base by term and sentence\n"
        +"5. Quit\n"
        +"Enter your choice ");
    }
    /**
     * Main method to load the array and allow user to interact with the options.
     * @param args   Command line arguments (not used)
     */
    public static void main (String [] args )
    {  
        //Initialised array for statements.
        statements = new Statement[10000000];  
        final Scanner keyboard = new Scanner(System.in); 
        userAction();
        String in = keyboard.next();
        keyboard.nextLine();
        //While loop which stops only when user enters exit input.
        while (!in.equals("5")) {
        
            if ( in.equals("1")){
               System.out.println();
               System.out.println("Enter file name: ");
               String file1 = keyboard.nextLine();
               try{
                  Scanner scanner = new Scanner(new File(file1));
                  count = 0;
                  //Reading textfile into array.
                  while(scanner.hasNextLine()){
                     String[] three = scanner.nextLine().split("\t");
                     Statement line = new Statement(three[0],three[1],Double.parseDouble(three[2]));
                     boolean found = false;
                     for(int i=0; i<count; i++){
                       if(statements[i]== line){
                        found = true;
                        if(line.getConfidence() >= statements[i].getConfidence()){
                           statements[i] = line;
                        }
                       }
                     }
                     if(found == false){
                        statements[count++] = line;
                     }
                  }
                  scanner.close();
                  System.out.println("Knowledge base loaded successfully.");
                  }
                //Catches error if file is not found.
                catch(FileNotFoundException e){
                  System.err.println("File not found: " + e.getMessage());
                }  
               }
               
            if( in.equals("2")){
               //Code to edit the sentence and confidence of a statement if the confidence given by the user is greater than the original statement's. 
               System.out.println("Enter the term: ");
               String term = keyboard.nextLine();
               System.out.println("Enter the statement: ");
               String statement = keyboard.nextLine();
               System.out.println("Enter the confidience score: ");
               double confidence = keyboard.nextFloat();
               keyboard.nextLine();
               boolean found = false;
               for(int i=0; i<count; i++){
                  if( (term.equals(statements[i].getTerm())) && (confidence>=statements[i].getConfidence()) ){
                     statements[i].editSentence(statement);
                     statements[i].editConfidence(confidence);
                     found = true;
                  }
               }
               if(found){
                  System.out.println("Statement for term "+ term+" has been updated" );
               }else{
                  System.out.println("Statement for term "+ term+" has not been found or confidence level is too low." );
               }
            }
            //Code to find statements which contain the term given by the user.
            if(in.equals("3")){
               System.out.println("Enter the term to search: ");
               String term = keyboard.nextLine();
               String statement = "";
               double con = 0;
               boolean found = false;
               for(int i=0; i<count; i++){
                  if(statements[i].getSentence().toLowerCase().contains(term)){
                     found = true;
                     statement = statements[i].getSentence();
                     con = statements[i].getConfidence();
                     System.out.println("Statement found: "+statement+" (Confidence score: "+con+")\n");
                  }
               }
               if(found== false){
                  System.out.println("Statement not found.");
               }               
            }
            //Check for the statement that matches the user input for both term and sentence.
             if( in.equals("4")){
               System.out.println("Enter the term: ");
               String term = keyboard.nextLine();
               System.out.println("Enter the statement to search for: ");
               String statement = keyboard.nextLine();
               double confidence = 0;
               boolean found = false;
               for(int i=0; i<count; i++){
                  if((term.equals(statements[i].getTerm())) && (statement.equals(statements[i].getSentence())) ){
                     found = true;
                     confidence = statements[i].getConfidence();
                  }
               }
               if(found){
                  System.out.println("The statement was found and has a confidence of: "+confidence);
               }else{
                  System.out.println("Statement not found.");

               }           
            }
            userAction();
            in = keyboard.nextLine();
         }
    }
}