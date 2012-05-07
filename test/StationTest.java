import genielogiciel.Metro;
import genielogiciel.Station;
import junit.framework.TestCase;

public class StationTest  extends TestCase {
    
    
       private Metro m;
    
    
             
    public void testgetDistance(){
        m = new Metro();
        Station s1 = new Station("S1",40,40);
        Station s2 = new Station("S2",80,80);
        m.setStation(0,s1);
        m.setStation(1,s2);
       
        double res= s1.getDistance(s2);
        assertEquals(Math.sqrt(3200),res);
    }
    
    public void testCompareTo()
    {
        
        Station s1 = new Station("S1",40,40);
        Station s2 = new Station("S2",40,40);
        
       
       assertTrue(s1.compareTo(s2) ==0);
       
        
        
       
       //assertTrue(s1.compareTo(s2) ==0);
    }
    
    
}
