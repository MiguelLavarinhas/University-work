// Creates a derived class of VectorObject.
// Name: Miguel Lavarinhas
// Student Number: LVRMIG001
// Date: 19/09/23

import java.util.*;

public class Rectangle extends VectorObject
{
   private int xLength;
   private int yLength;
      
   public Rectangle(int anId, int ax, int ay ,int xLength, int yLength){
   //Constructor
      super(anId,ax,ay);
      this.xLength = xLength;
      this.yLength = yLength;
   
   }
   
   public void draw(char[][] matrix){
   //Draw method
      for(int i=x; i<x+xLength; i++){
         for(int j=y; j<y+yLength; j++){
            matrix[j][i]='*';
         }
      }
   }

}