// Creates a student class.
// Name: Miguel Lavarinhas
// Student Number: LVRMIG001
// Date: 19/09/23

public class Student extends Person
{
   private String nameOfInstitution;
   private String programOfStudy;
   private String hobbies;
   private int yearOfStudy;
   
   public Student(String name, int age, String gender, String nameOfInstitution,String programOfStudy, int yearOfStudy, String hobbies){
   //Constructor
      super(name,age, gender);
      this.nameOfInstitution = nameOfInstitution;
      this.programOfStudy = programOfStudy;
      this.hobbies = hobbies;
      this.yearOfStudy = yearOfStudy;
   }
   
   public Student(Student other){
      this(other.getName(),other.getAge(),other.getGender(),other.nameOfInstitution,other.programOfStudy,other.yearOfStudy,other.hobbies);
   }
   //Get methods
   public int getYearOfStudy(){
      return yearOfStudy;
   }
   
   public String getNameOfInstitution(){
      return nameOfInstitution;
   }
   
   public String getProgramOfStudy(){
      return programOfStudy;
   }
   
   public String getHobbies(){
      return hobbies;
   }
   //Set methods
   public void setYearOfStudy(int year){
      yearOfStudy= year;
   }
   
   public void setNameOfInstitution(String i){
      nameOfInstitution= i;
   }
   
   public void setProgramOfStudy(String p){
      programOfStudy= p;
   }
   
   public void setHobbies(String h){
      hobbies= h;
   }




}