// Creates a person class.
// Name: Miguel Lavarinhas
// Student Number: LVRMIG001
// Date: 19/09/23

public class Person
{
   private String name;
   private String gender;
   private int age;
   
   public Person(String name, int age, String gender){
   //Constructor
      this.name = name;
      this.gender = gender;
      this.age = age;
   }
   
   public Person(Person other){
      this(other.name,other.age,other.gender);
   }
   //Get methods
   public String getName(){
      return name;
   }
   
   public String getGender(){
      return gender;
   }
   
   public int getAge(){
      return age;
   }
   //Set methods
   public void setAge(int age){
      this.age = age;
   }
   
   public void setGender(String gender){
      this.gender = gender;
   }
   
   public void setName(String name){
      this.name = name;
   }


}