class Test2
{
public static void main (String [] args )
{
   Register r = new Register();
   Ticket t = new Ticket(new Time("13:00"), "00001");
   String ID_One = t.ID();
   r.add(t);
   t = new Ticket(new Time("13:18"), "00002");
   String ID_Two = t.ID();
   r.add(t);
   System.out.println(r.contains(ID_One));
   System.out.println(r.contains("9236743"));
   System.out.println(r.retrieve(ID_Two).toString());
}
}