// Creates student object.
// Name: Miguel Lavarinhas
// Student Number: LVRMIG001
// Date: 31/07/23

import java.util.Scanner;

class Student
{
   private String firstName;
   private String middleName;
   private String lastName;
   
   //SetMethod
   public void setNames(String first, String middle, String last){
      // Set the first, middle and last names of this Student object.
      firstName = first;
      middleName = middle;
      lastName = last;
   }
   
   //GetMethod
   public String getFullName(){
      // Obtain the full name of this Student with the middle name converted to an initial only.
      String line = firstName +" "+ middleName.charAt(0) +". "+ lastName;
      return line;
   }

//public static void main (String [] args )
//{
//}
}