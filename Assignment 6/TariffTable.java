// Calculates Sum of Costs.
// Name: Miguel Lavarinhas
// Student Number: LVRMIG001
// Date: 03/09/23

import java.util.Scanner;

class TariffTable
{
  private ParkingTariff[] parkingTariffs;
  private int nextFree;
  
  public TariffTable(int maxSize){
   parkingTariffs = new ParkingTariff[maxSize];
   nextFree = 0;
  }
  
  public void addTariff(TimePeriod period, Money tariff){
   ParkingTariff p = new ParkingTariff(period, tariff);
   if((nextFree == 0) || (period.adjacent(parkingTariffs[nextFree-1].getTime())) ){
      parkingTariffs[nextFree] = p;
      nextFree++;
   }else
   {
      throw new IllegalArgumentException("Tariff periods must be adjacent.");
   }
  }
  
  public Money getTariff(Duration lengthOfStay){
   for(int i = 0; i < nextFree; i++){
      TimePeriod t = parkingTariffs[i].getTime();
      if(t.includes(lengthOfStay)){
         return parkingTariffs[i].getCost();
      }
   }
   Currency currency = new Currency("R", "ZAR", 100);
   Money m = new Money("R0",currency);
   return m;
  }
  
  public String toString(){
   String s = "";
   for(int i = 0; i<nextFree; i++){
      s += parkingTariffs[i].toString();
      if((i+1)<nextFree){
         s+= "\n";
      }
   }
   return s;
  }   
  
 }