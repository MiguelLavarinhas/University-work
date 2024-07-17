// Creates a class used for cows and bulls guessing game.
// Name: Miguel Lavarinhas
// Student Number: LVRMIG001
// Date: 19/09/23

import java.util.*;

public class CowsAndBulls
{
  private int mystery;
  private int guessesLeft;
  private Result r;
  
 
 //Constants
 public final static int NUM_DIGITS = 4;
 public final static int MAX_VALUE = 9876;
 public final static int MIN_VALUE = 1234;
 public final static int MAX_GUESSES = 10;
 
 public CowsAndBulls(int seed){
   // Create a CowsAndBulls game using the given randomisation seed value to generate
   NumberPicker p = new NumberPicker(seed,1,9);
   mystery=0;
   guessesLeft =10;
   for(int i=0; i<NUM_DIGITS; i++){
      mystery = mystery*10 + p.nextInt();
   }
 }
 
 public int guessesRemaining(){
   // Obtain the number of guesses remaining.
   return guessesLeft; 
 }
 
 public Result guess(int guessNumber){
   // Evaluates a guess that the mystery number is guessNumber returning the outcome in the form of a Result object. Decrements guesses remaining.
   int cow= NumberUtils.countIntersect(guessNumber,mystery)-NumberUtils.countMatches(guessNumber,mystery);
   int bull= NumberUtils.countMatches(guessNumber,mystery);
   
   r = new Result(cow,bull);
   guessesLeft--;
   return r; 
 }
 
 public int giveUp(){
   // End the game returning the secretNumber
   guessesLeft = 0;
   return mystery;  
 }
 
 public boolean gameOver(){
   //Checks if game is over
   if( r != null){
      if((r.isCorrect()) || (guessesLeft==0) ){
      return true;
      }
      else{ return false;}
   }
   else if(guessesLeft == 0){
            return true;
   }else {return false;}
 }
 
}