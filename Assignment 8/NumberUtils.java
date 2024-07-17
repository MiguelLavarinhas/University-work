// Creates a class useful for working with integers.
// Name: Miguel Lavarinhas
// Student Number: LVRMIG001
// Date: 19/09/23

import java.util.*;

public class NumberUtils
{
 private NumberUtils() {}
 
 public static int[] toArray(int number){
   // Given a number that is n digits in length maps the digits to an array length n.
      int len = Integer.toString(number).length();
      int[] a = new int[len];
      int i = 0;
      while(number!=0){
         a[len-i-1] = number % 10;
         number /= 10;
         i++;
      }
      return a;   
      }
   
 public static int countMatches(int numberA, int numberB){
   // Given two numbers, count the quantity of matching digits those with the same value and position.
   int[] a = toArray(numberA);
   int[] b = toArray(numberB);
   int total=0;
   for(int i=0; i<a.length; i++){
      if(a[i] == b[i]){
         total++;
      }
   }
   return total;
 }
 
 public static int countIntersect(int numberA, int numberB){
   // Count the quantity of digits that two numbers have in common regardless of position.
   int[] a = toArray(numberA);
   int[] b = toArray(numberB);
   int count = 0; 
   for(int i = 0; i <a.length; i++)
    {
      for(int y = 0; y <a.length; y++)
      {
         if(a[i] == b[y])
         {
            count++; 
         }
      }
    }
    return count;

 }
  
}