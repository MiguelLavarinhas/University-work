// Calculates Sum of Costs.
// Name: Miguel Lavarinhas
// Student Number: LVRMIG001
// Date: 03/09/23

import java.util.Scanner;

class TimePeriod
{
   private Duration upperBound;
   private Duration lowerBound;
   
   public TimePeriod(Duration lowerBound, Duration upperBound){
      this.upperBound = upperBound;
      this.lowerBound = lowerBound;
   }
   
   public Duration lowerBound(){
      return lowerBound;
   }
   
   public Duration upperBound(){
      return upperBound;
   }
   
   public boolean includes(Duration duration){
      if((this.lowerBound.compareTo(duration)  < 1 ) && (this.upperBound.compareTo(duration) > 0)){
         return true;
      }
      return false;
   }
   
   public boolean precedes(TimePeriod other){
      if( this.upperBound.compareTo(other.lowerBound()) <= 0){
         return true;
      }
      return false;
   }
   
   public boolean adjacent(TimePeriod other){
      if((this.upperBound.compareTo(other.lowerBound())==0) || (this.lowerBound.compareTo(other.upperBound())==0)){
         return true;
      }
      return false;
   }
   
   public String toString(){
      String l = Duration.format(lowerBound,"minute");
      String u = Duration.format(upperBound,"minute");
      return "[" + l + " .. " + u + "]";
   }
 
}