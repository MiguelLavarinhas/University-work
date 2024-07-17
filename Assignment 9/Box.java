// Creates a derived class of computer.
// Name: Miguel Lavarinhas
// Student Number: LVRMIG001
// Date: 19/09/23

import java.util.*;

public class Box extends Computer
{
   /*private String serial;
   private String manufacturer;
   private String colour;*/
   private String memory;
   
   public Box(String serial,String manufacturer,String colour,String memory){
   //Constructor
      super(serial,manufacturer,colour);
      /*this.serial = serial;
      this.manufacturer = manufacturer;
      this.colour = colour;*/
      this.memory = memory;
   }
   
   public Box(Box other){
      //this(other.serial,other.manufacturer,other.colour,other.memory);
      super(other);
      this.memory= other.memory;
   }
   
   public String getSerial(){
      return this.serial;
   }
   
   
      
   final public String toString(){
   //To string method
      return "Box: "+serial+", "+manufacturer+", "+colour+", "+memory;
   }

}