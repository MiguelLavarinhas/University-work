/**
 * This class loads a large amount of statements into a Binary Search tree and then allows the user to use a menu of options to access the statements.
 *
 * @author Miguel Lavarinhas
 * @version 1.0
 * @since 25/02/2024
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class GenericsKbBSTApp
{
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
    * @param args Command line arguments (not used)
    */
   public static void main (String [] args )
   {
      //Initialising a Binary Tree to store statements.
      BinaryTree bt = new BinaryTree();
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
                  //Reading textfile into array.
                  while(scanner.hasNextLine()){
                     String[] three = scanner.nextLine().split("\t");
                     Statement line = new Statement(three[0],three[1],Double.parseDouble(three[2]));
                     //Adds to the database or updates if the statement already exists.
                     BinaryTreeNode <Statement> updated = new BinaryTreeNode<>(line,null,null);
                     BinaryTreeNode <Statement> found = bt.find(updated.data);
                     
                     if(found == null){ 
                     bt.insert(updated.data);
                     }
                     else{
                      if(updated.data.getConfidence() >= found.data.getConfidence()){
                      found.data = updated.data;
                     }
              }

                     //bt.insert(line);
                  }
                  scanner.close();
                  System.out.println("Knowledge base loaded successfully.");
                  }
                  //Catches error if file is not found.
                catch(FileNotFoundException e){
                  System.err.println("File not found: " + e.getMessage());
                }  
               }
          //Code to edit the sentence and confidence of a statement if the confidence given by the user is greater than the original statement's.     
          if( in.equals("2")){
               System.out.println("Enter the term: ");
               String term = keyboard.nextLine();
               System.out.println("Enter the statement: ");
               String statement = keyboard.nextLine();
               System.out.println("Enter the confidience score: ");
               double confidence = keyboard.nextFloat();
               keyboard.nextLine();
               
              BinaryTreeNode <Statement> updated = new BinaryTreeNode<>(new Statement(term,"",confidence),null,null);
               
              BinaryTreeNode <Statement> found = bt.find(updated.data);
              
              if(found == null){ 
               bt.insert(updated.data);
               System.out.println("Statement found: "+ statement+ " (Confidence score: "+ updated.data.getConfidence()+")");
              }
              else{
               if(updated.data.getConfidence() >= found.data.getConfidence()){
                  updated = new BinaryTreeNode<>(new Statement(term,statement,confidence),null,null);
                  found.data = updated.data;
                  System.out.println("Statement found: "+ found.data.getSentence()+ " (Confidence score: "+ found.data.getConfidence()+")");
               }else{
                  System.out.println("Statement for term "+ term+" has not been found or confidence level is too low." );
               }
              }
                        
               
          }
          //Code to find statements which contain the term given by the user.
          if(in.equals("3")){
               System.out.println("Enter the term to search: ");
               String term = keyboard.nextLine();
               BinaryTreeNode <Statement> updated = new BinaryTreeNode<>(new Statement(term,"",0),null,null); 
               bt.postOrder(updated.data);
               
               if(bt.count==0){
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
               BinaryTreeNode <Statement> updated = new BinaryTreeNode<>(new Statement(term,statement,0),null,null);
               BinaryTreeNode <Statement> found = bt.find(updated.data);
               if(found == null){ 
                  System.out.println("Statement not found for term: "+term);
               }
               else{
                  System.out.println("Statement found: "+ found.data.getSentence()+ " (Confidence score: "+ found.data.getConfidence()+")");
               }
          
            }

     
               
         userAction();
         in = keyboard.nextLine();
      }
   } 

}
