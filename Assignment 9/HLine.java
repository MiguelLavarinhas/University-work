// Creates a derived class of VectorObject.
// Name: Miguel Lavarinhas
// Student Number: LVRMIG001
// Date: 19/09/23

import java.util.*;

public class HLine extends VectorObject
{
   private int xLength;
   
   public HLine(int anId, int ax, int ay ,int xLength){
   //Constructor
      super(anId,ax,ay);
      this.xLength = xLength;
   }
   
   public void draw(char[][] matrix){
   //Draw method for hline
      for(int i=x; i<x+xLength; i++){
         matrix[y][i]= '*';
      }
   }
}