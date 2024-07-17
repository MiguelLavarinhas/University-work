import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class TestOfTime {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   /** A test that checks if the time object stores the time correctly. **/
   @Test public void TimeStorage() {
      Time t = new Time("03:25");
      Assert.assertEquals("The time object did not store the time correctly", "03:25:00", t.toString());
      }
      
    /** A test that checks if the time subtracts correctly from another. **/
   @Test public void TimeSubtract() {
      Time t1 = new Time("03:25");
      Time t2 = new Time("03:30");
      Duration d = t2.subtract(t1);
      Assert.assertEquals("The time object did not subtract correctly.", 5, d.intValue("minute"));
      }
      
    /** A test that checks if the time subtraced from itself is 0. **/
   @Test public void TimeSubtractItself() {
      Time t1 = new Time("03:25");
      Time t2 = new Time("03:25");
      Duration d = t2.subtract(t1);
      Assert.assertEquals("The time object did not subtract the same time correctly.", 0, d.intValue("minute"));
      }
      
    /** A test that checks if the Duration object works with milliseconds. **/
   @Test public void MillisecondsDuration() {
      Time t1 = new Time("03:25");
      Time t2 = new Time("03:25:01");
      Duration d = t2.subtract(t1);
      Assert.assertEquals("The duration object did not work in milliseconds.", 1000, d.intValue("millisecond"));
      }

   /** A test that checks if the Duration object works with seconds. **/
   @Test public void SecondsDuration() {
      Time t1 = new Time("03:25");
      Time t2 = new Time("03:25:01");
      Duration d = t2.subtract(t1);
      Assert.assertEquals("The duration object did not work in seconds.", 1, d.intValue("second"));
      }

   /** A test that checks if the Duration object works with mintues. **/
   @Test public void MinutesDuration() {
      Time t1 = new Time("03:25");
      Time t2 = new Time("03:26");
      Duration d = t2.subtract(t1);
      Assert.assertEquals("The duration object did not work in minutes.", 1, d.intValue("minutes"));
      }
      
    /** A test that checks if the Duration object works with hours. **/
   @Test public void HoursDuration() {
      Time t1 = new Time("03:25");
      Time t2 = new Time("04:25");
      Duration d = t2.subtract(t1);
      Assert.assertEquals("The duration object did not work in hours.", 1, d.intValue("hour"));
      }


}
