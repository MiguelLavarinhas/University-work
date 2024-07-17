 /**
 * This class creates a subset of the GenericsKB.txt file and runs the code from GenericsKbAVLApp through the subset.
 *
 * @author Miguel Lavarinhas
 * @version 1.0
 * @since 20/03/2024
 */
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TestSubset {
    /**
    * The size of the subset.
    */
    private int entries;
    /**
    * The main file GenericsKB.txt.
    */
    private String file1;
    /**
    * The subset file.
    */
    private String file2;
    /**
    * Constructor to create a subset with zero entries.
    */
    public TestSubset(){
        entries=0;
        file1 = "GenericsKB.txt";
        file2 = "Subset.txt";
    }
    /**
    * Constructor to set entries to a certain amount.
    * @param entries  Amount of entries.
    */
    public TestSubset(int entries){
        this.entries=entries;
        entries=0;
        file1 = "GenericsKB.txt";
        file2 = "Subset.txt";
    }
    /**
    * Method to create a subset of the main file with a certain amount of entries.
    */
    public void createSubset(){
        ArrayList<Statement> unFiltered = new ArrayList<Statement>();
        try{
            Scanner scanner = new Scanner(new File(file1));
            //Reading textfile into array.
            while(scanner.hasNextLine()){
               String[] three = scanner.nextLine().split("\t");
               Statement line = new Statement(three[0],three[1],Double.parseDouble(three[2]));
               //Adds to the database or updates if the statement already exists.
               unFiltered.add(line);
               }
            scanner.close();
            }
            //Catches error if file is not found.
          catch(FileNotFoundException e){
            System.err.println("File not found: " + e.getMessage());
          }
        

          Collections.shuffle(unFiltered);
          ArrayList<Statement> filtered =  new ArrayList<Statement>(unFiltered.subList(0, Math.min(entries, unFiltered.size())));

        try {
            //File fold = new File(file2);
            FileWriter myWriter = new FileWriter(file2);
            for (Statement entry : filtered) {
                myWriter.write(entry.getTerm()+ "\t"+entry.getSentence()+"\t"+entry.getConfidence()+"\n");
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
            
    }
    /**
    * Method to run the subset through the GenericsKbAVLApp code and check if any queries match.
    */
    public void runCode(){
        AVLTree bt = new AVLTree<>();
        long start = System.currentTimeMillis();
        ArrayList<Integer> insert = new ArrayList<Integer>();
        ArrayList<Integer> search = new ArrayList<Integer>();
        try{
            Scanner scanner = new Scanner(new File(file2));
            //Reading textfile into array.
            while(scanner.hasNextLine()){
               String[] three = scanner.nextLine().split("\t");
               Statement line = new Statement(three[0],three[1],Double.parseDouble(three[2]));
               //Adds to the database or updates if the statement already exists.
               BinaryTreeNode <Statement> updated = new BinaryTreeNode<>(line,null,null);
               bt.insert(updated.data);
               insert.add(bt.getInsertCount());
               bt.resetInsertCount();;

               }
            scanner.close();
            }
            //Catches error if file is not found.
          catch(FileNotFoundException e){
            System.err.println("File not found: " + e.getMessage());
          }

        try{
            Scanner scanner = new Scanner(new File("GenericsKB-queries.txt"));
            //Reading textfile into array.
            while(scanner.hasNextLine()){
               String term = scanner.nextLine();
               Statement line = new Statement(term,"",0);
               //Adds to the database or updates if the statement already exists.
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
        }
        catch(FileNotFoundException e){
            System.err.println("File not found: " + e.getMessage());
        }
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
        System.out.println("Time Taken to run subset: "+ timetaken+ " ms.");
    }
    

        
    }
    
    

