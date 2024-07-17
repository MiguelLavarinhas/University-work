// Creates a derived class of VectorObject.
// Name: Miguel Lavarinhas
// Student Number: LVRMIG001
// Date: 19/09/23

import java.util.*;
import java.lang.Math;

public class PtLine extends VectorObject
{
   private int x1;
   private int y1;
   
   public PtLine(int anId, int ax, int ay , int x1,int y1){
   //Constructor
      super(anId,ax,ay);
      this.x1 = x1;
      this.y1 = y1;
   }
   
   
   public void draw(char[][] matrix){
   //Draw method
      int swap = 0;
      boolean steep = Math.abs(y1-y) > Math.abs(x1-x);
      if(steep){
         swap = x;
         x = y;
         y= swap;
         swap = y1;
         y1 = x1;
         x1 = swap;
      }
      
      if(x>x1){
        swap = x;
        x = x1;
        x1 = swap;
        swap = y;
        y = y1;
        y1 = swap; 
      }
      
      int ys =0;
      if(y<y1){
         ys=1;
      }else{
         ys=-1;
      }
      
      double m = Math.abs(y1-y) / (x1-x);
      double error = 0;
      
      for(int i=x; i<=x1;i++){
         if(steep){
            matrix[i][y]='*';
         }else{
            matrix[y][i]='*';
         }
         error+=m;
         if(error>0.5){
            y= y+ys;
            error-=1;
         }
      }
      
   }

}