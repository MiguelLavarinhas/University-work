// Creates a work shift object.
// Name: Miguel Lavarinhas
// Student Number: LVRMIG001
// Date: 13/09/23

import java.util.Scanner;

class Shift
{
  private CalendarTime start;
  private CalendarTime finish;
  
  public Shift(CalendarTime start, CalendarTime finish){
      this.start = start;
      this.finish = finish;
  }
  
  public CalendarTime start(){
      return this.start;
  }
  
  public CalendarTime finish(){
      return this.finish;
  }
  
  public boolean inWeek(Week w){
   // Determine whether this shift occurred within the given week.
      if(w.includes(start().date()) || w.includes(finish().date()) ){
         return true;
      }
      return false;
   }
   
   public boolean includesDate(Date date){
   // Determine whether this shift at least partly occurred on the given date.
      if( (this.start.date().compareTo(date) <= 0) && (this.finish.date().compareTo(date) >= 0) ){
         return true;
      }
      return false;
   }
   
   public Duration length(){
   // Obtain the length of this shift.
      Duration d = this.finish.subtract(this.start);
      return d;
   }
   
   public String toString(){
   // Obtain a string representation of this shift of the form "<date>%:<time>-<date>%:<time>"
      return this.start.toString() + " - " + this.finish.toString();
   }
   
}