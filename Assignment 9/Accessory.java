// Creates a derived class of computer.
// Name: Miguel Lavarinhas
// Student Number: LVRMIG001
// Date: 19/09/23

import java.util.*;

public class Accessory extends Computer
{
   
   public Accessory(String serial,String manufacturer,String colour){
   //Constructor
      super(serial,manufacturer,colour);
   }
   
   public Accessory(Accessory other){
      super(other);}
      //this(other.serial,other.manufacturer,other.colour);
   //}
   
   public String getSerial(){
      return this.serial;
   }

      
   public String toString(){
   //To string method
      return "Accessories: "+serial+", "+manufacturer+", "+colour;
   }
}
