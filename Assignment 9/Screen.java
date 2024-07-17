// Creates a derived class of computer.
// Name: Miguel Lavarinhas
// Student Number: LVRMIG001
// Date: 19/09/23

import java.util.*;

public class Screen extends Computer
{
   /*private String serial;
   private String manufacturer;
   private String colour;*/
   private String size;
   
   public Screen(String serial,String manufacturer,String colour,String size){
   //Constructor
      super(serial,manufacturer,colour);
      /*this.serial = serial;
      this.manufacturer = manufacturer;
      this.colour = colour;*/
      this.size = size;
   }
   
   public Screen(Screen other){
      //this(other.serial,other.manufacturer,other.colour,other.size);
      super(other);
      this.size = other.size;
   }
   
   public String getSerial(){
      return this.serial;
   }


   
      
   final public String toString(){
   //To string method
      return "Screen: "+serial+", "+colour+", "+manufacturer+", "+size;
   }

}
