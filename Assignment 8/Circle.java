// Creates a child class circle of class circle.
// Name: Miguel Lavarinhas
// Student Number: LVRMIG001
// Date: 19/09/23

import java.util.*;

public class Circle extends Shape
{
   private double radius;
   
   public Circle(Circle other){
      //Constructor
      this(other.name,other.colour,other.radius);
   }
   
   public Circle(String name,String colour,double radius){
   //Circle Constructor
      super(name,colour);
      this.radius = radius;
   }
   
   public String toString(){
   //To string method
      return "Circle "+colour+ " Radius "+ this.radius;
   }
}