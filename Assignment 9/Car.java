// Creates a Vehicle class.
// Name: Miguel Lavarinhas
// Student Number: LVRMIG001
// Date: 19/09/23

public class Car extends Vehicle
{
   private int capacity;
   private double weight;
   
   public Car(int numCylinders, String maker, Student owner, int capacity, double weight){
   //Creates car object
      super(numCylinders,maker,owner);
      this.capacity= capacity;
      this.weight = weight;
   }
   
   public Car(Car C){
      this(C.cylinders,C.manufacturer,C.owner,C.capacity,C.weight);
   }
   
   public String toString(){
   //To string method
      return manufacturer + ", "+cylinders+" cylinders, owned by "+ owner.getName()+", a "+owner.getAge() +"-year old "+ owner.getGender()+ " studying "+owner.getProgramOfStudy()+ " at "+owner.getNameOfInstitution()+ ". "+owner.getName() + " likes "+owner.getHobbies()+".\nThe car is a "+ capacity+"-seater weighing "+weight+" kg";
   }
}