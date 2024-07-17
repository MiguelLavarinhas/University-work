// Driver class for car class.
// Name: Miguel Lavarinhas
// Student Number: LVRMIG001
// Date: 19/09/23

import java.util.*;

public class Question3
{
   public static void main(String []args){
   //Retrieving information and assigning it to car object
      Scanner keyboard = new Scanner(System.in);
      System.out.println("Enter the vehicle manufacturer:");
      String maker = keyboard.nextLine();
      System.out.println("Enter the name of the vehicle owner:");
      String owner = keyboard.nextLine();
      System.out.println("Enter the owner's gender:");
      String gender = keyboard.nextLine();
      System.out.println("Enter the owner's programme of study:");
      String programme = keyboard.nextLine();
      System.out.println("Enter the owner's Institution name:");
      String institute = keyboard.nextLine();
      System.out.println("Enter the owner's hobbies:");
      String hobby = keyboard.nextLine();
      System.out.println("Enter the owner's age:");
      int age = keyboard.nextInt();
      Student student = new Student(owner ,age, gender, institute, programme,age, hobby);
      System.out.println("Enter the number of cylinders in the engine:");
      int cyls = keyboard.nextInt();
      System.out.println("Enter the car seating capacity:");
      int seats = keyboard.nextInt();
      System.out.println("Enter the weight of the car:");
      double weight = keyboard.nextDouble();
      Car car = new Car(cyls,maker,student, seats, weight);
      System.out.println(car);
      
   }
}