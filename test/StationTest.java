import genielogiciel.Metro;
import junit.framework.TestCase;

public class StationTest  extends TestCase {
    
    
       private Metro m;
    
    
    public void testgetDistance(){
        m=new Metro();
        m.creerReseau();
        double res= m.getStation(0).getDistance(m.getStation(1));
        assertEquals(Math.sqrt(800),res);
       
       
   /*    this.station.add(new Station("S4",30,30,l));
       this.station.add(new Station("S5",40,40,l));
       
       this.station.add(new Station("SS1",10,20,l2));
      Station s= new Station("SS2",20,30,l2);
       this.station.add(s);
       this.station.add(new Station("SS3",30,40,l2));
       this.station.add(new Station("SS4",40,50,l2));
       
        this.station.add(new Station("SSS1",10,30,l3));
       this.station.add(new Station("SSS2",20,30,l3));
       this.station.add(new Station("SSS3",30,50,l3));
       this.station.add(new Station("SSS4",40,60,l3));   */
       
    }
    
    
}
