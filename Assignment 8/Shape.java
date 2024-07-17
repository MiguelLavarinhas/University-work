// Creates a parent class shape.
// Name: Miguel Lavarinhas
// Student Number: LVRMIG001
// Date: 19/09/23

import java.util.*;

public class Shape
{
   public String name;
   public String colour;
   
   public Shape(Shape other){
   //Constructor
      this(other.name, other.colour);
   }

   
   public Shape(String name,String colour){
   //Constructor
      this.name = name;
      this.colour = colour;
   }
   
      
   public String toString(){
   //To string method
      return name + " "+ colour;
   }

}