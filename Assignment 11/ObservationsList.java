// Creates a class of an observed vehicle.
// Name: Miguel Lavarinhas
// Student Number: LVRMIG001
// Date: 18/10/23

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ObservationsList implements Iterable<Observation>
{
   private List<Observation> observed;
   
   public ObservationsList(){
      observed = new ArrayList<Observation>();
   }
   
   public void record(Observation observation){
      observed.add(observation);
   }
   
   public void record(Registration reg, Time time){
      Observation o = new Observation(reg,time);
      observed.add(o);
   }
   
   public int getTotal(){
      return observed.size();
   }
   
   public List<Registration> getVehicles(){
      List<Registration> identifiers = new ArrayList<Registration>();
      for(Observation ob : observed){
         identifiers.add(ob.getIdentifier());
      }
      return identifiers;
   }
   
   public ObservationsList getObservations(final Registration identifer){
   ObservationsList ol = new ObservationsList();
      for(Observation ob: observed){
         if(ob.isFor(identifer)){
            ol.record(ob);
         }
      }
      return ol;
   }
   
   public ObservationsList getObservations(final Time s, final Time e){
      ObservationsList ol = new ObservationsList();
      for(Observation ob: observed){
         if(ob.inPeriod(s,e)){
            ol.record(ob);
         }
      }
      return ol;
   }
   
   public Iterator<Observation> iterator(){
      Iterator<Observation> iterator = observed.iterator();
      return iterator;
   }

}