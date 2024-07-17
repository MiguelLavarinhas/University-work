// Creates a base class called computer.
// Name: Miguel Lavarinhas
// Student Number: LVRMIG001
// Date: 19/09/23

import java.util.*;

public class Computer
{
   public String serial;
   public String manufacturer;
   public String colour;
   
   public Computer(String serial,String manufacturer,String colour){
   //Constructor
      this.serial = serial;
      this.manufacturer = manufacturer;
      this.colour = colour;
   }
   
   public Computer(Computer other){
      this(other.serial,other.manufacturer,other.colour);
   }
   
   public String getSerial(){
      return this.serial;
   }
    
   public String toString(){
   //To string method
      return "Computer: "+serial+", "+manufacturer+", "+colour;
   }
}