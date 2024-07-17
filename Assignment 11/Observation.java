// Creates a class of an observed vehicle.
// Name: Miguel Lavarinhas
// Student Number: LVRMIG001
// Date: 18/10/23

public class Observation
{
   private Registration registration;
   private Time time;
   
   public Observation(final Registration registration, final Time time){
      this.registration = registration;
      this.time = time;
   }
   
   public Time getTime(){
      return time;
   }
   
   public Registration getIdentifier(){
      return registration;
   }
   
   public boolean isFor(final Registration identifier){
      if(registration.equals(identifier) ){
         return true;
      }
      return false;
   }
   
   public boolean inPeriod(final Time s, final Time e){
      if( (time.compareTo(s)>=0) && (time.compareTo(e)<=0)){
         return true;
      }  
      return false;
   }
   
   public int compareTo(Observation other){
      if(time.compareTo(other.time)==1){
         return -1;
      }else if(time.compareTo(other.time)==0){
         return 0;
      }else{
         return 1;
      }
   }
   
   public String toString(){
      return "["+time +", "+ registration.getIdentifier()+"]";
   }
}