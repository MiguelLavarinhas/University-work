// Creates ParkingTariff object consisting of price and period of stay.
// Name: Miguel Lavarinhas
// Student Number: LVRMIG001
// Date: 03/09/23

import java.util.Scanner;

class ParkingTariff
{
  private TimePeriod time;
  private Money cost;
  //Constructor
  public ParkingTariff(TimePeriod time, Money cost){
   this.time = time;
   this.cost = cost;
  }
  //Get time method
  public TimePeriod getTime(){
   return time;
  }
  //Get cost method
  public Money getCost(){
   return cost;
  }
  
  //Display method
  public String toString(){
   return time.toString() + " : " + cost;
  }
  
}