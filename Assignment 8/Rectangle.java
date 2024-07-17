// Creates a child class rectangle of class circle.
// Name: Miguel Lavarinhas
// Student Number: LVRMIG001
// Date: 19/09/23

import java.util.*;

public class Rectangle extends Shape
{
   private double width;
   private double length;
   
   public Rectangle(Rectangle other){
     
     this(other.name, other.colour, other.width,other.length);
   }

   public Rectangle(String name,String colour,double length, double width){
   //Constructor
      super(name,colour);
      this.width = width;
      this.length = length;
   }
      
   public String toString(){
   //To string method
      return "Rectangle "+ colour + " Length "+this.length+ " Width "+this.width;
   }
}