// Creates a Vehicle class.
// Name: Miguel Lavarinhas
// Student Number: LVRMIG001
// Date: 19/09/23

public class Vehicle
{
   public int cylinders;
   public String manufacturer;
   public Student owner;
   
   public Vehicle(int cylinders, String manufacturer, Student owner){
   //Constructor
      this.cylinders = cylinders;
      this.manufacturer = manufacturer;
      this.owner = owner;
   }
   
   public Vehicle(Vehicle other){
      this(other.cylinders, other.manufacturer, other.owner);
   }
   
   public String toString(){
   //To string method
      return manufacturer + ", "+cylinders+" cylinders, owned by "+ owner.getName()+", a "+owner.getAge() +"-year old "+ owner.getGender()+ " studying "+owner.getProgramOfStudy()+ " at "+owner.getNameOfInstitution()+ ". "+owner.getName() + " likes "+owner.getHobbies()+".";
   }
}
