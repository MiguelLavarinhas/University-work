// Creates a derived class of VectorObject.
// Name: Miguel Lavarinhas
// Student Number: LVRMIG001
// Date: 19/09/23

import java.util.*;

public class VLine extends VectorObject
{
   private int yLength;
   
   public VLine(int anId, int ax, int ay , int yLength){
   //Constructor
      super(anId,ax,ay);
      this.yLength = yLength;
   }
   
   public void draw(char[][] matrix){
   //Draw method
      for(int i=y; i<y+yLength; i++){
         matrix[i][x]= '*';
      }
   }
}