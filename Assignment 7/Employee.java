// Creates an employee object.
// Name: Miguel Lavarinhas
// Student Number: LVRMIG001
// Date: 13/09/23

import java.util.*;

public class Employee
{
  private String name;
  private String uid;
  private Shift[] shifts;
  private int count;
  private int in;
  private int out;
  
  public Employee(String name, String uid){
   // Create an Employee representing the employee with given name and UID   
      this.name = name;
      this.uid = uid;
      this.count = 0;
      shifts = new Shift[100];
      in = 0;
      out = 0;
   }

   public String name(){
   // Obtain this employees name.
      return this.name;
   }
   
   public String UID(){
   // Obtain this employees uid.
      return this.uid;
   }
   
   public void signIn(Date d, Time t){
   // Record that this employee has begun a shift on the given date and at the given time
      CalendarTime c = new CalendarTime(d,t);
      this.shifts[count] = new Shift(c,c);
      in++;
   }
   
   public void signOut(Date d, Time t){
   // Record that this employee has completed a shift on the given date and at the given time
      CalendarTime c = new CalendarTime(d,t);
      this.shifts[count] = new Shift(shifts[count].start(),c);
      count++;
      out++;
   }
   
   public boolean present(){
   // Determine whether this employee is present i.e. has signed-in and not yet signed out.
      if(in>out ){
         return true;
      }
      return false;
   }
   
   public boolean worked(Date d){
   // Determine whether this employee worked a shift that at least partly occurred on the given date.
   for(int i = 0; i<count; i++){
      if(shifts[i].includesDate(d)){
         return true;
      }
   }
   return false;
   }
   
   public boolean worked(Week w){
   // Determine whether this employee worked at least one shift during the given week.
      for(int i = 0; i<count; i++){
        if(shifts[i].inWeek(w)){
         return true;
      }
   }
   return false;
   }
   
   public List<Shift> get(Date d){
   // Obtain the shift(s) worked by this employee that at least partly occur on the given date
      List<Shift> s = new ArrayList<Shift>();
      for(int i = 0; i<count; i++){
           if(shifts[i].includesDate(d)){
           s.add(shifts[i]);
          }
         }
         return s;
      }

   public List<Shift> get(Week w){
   // Obtain a list of the shifts worked by this employee during the given week.
      List<Shift> s = new ArrayList<Shift>();
      for(int i = 0; i<count; i++){
         if(shifts[i].inWeek(w)){
            s.add(shifts[i]);
          }
         }
         return s;
      }
    
   public Duration hours(Week w){
   // Returns the total time (hours and minutes) worked during the given week.
      Duration d = new Duration("minute",0);
      ListIterator<Shift> s = get(w).listIterator();
     while(s.hasNext()){  
         d= d.add(s.next().length());
              
         }
      return  d;

   }
   
   }