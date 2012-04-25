import genielogiciel.*;
import java.util.ArrayList;
import junit.framework.TestCase;


public class ParcoursTest extends TestCase{
    
    Metro m=new Metro();
    
    public void testdijkstra(){
        Parcours p=new Parcours(m.getStation(0),m.getStation(7));
        ArrayList a=p.dijkstra();
       // int lignes=  m.getNombreLignes();
        ArrayList res=new ArrayList();
         Station s= new Station("S2",200,230);
       Station ss=new Station("S3",220,250);
       Station sss=new Station("S4",260,270);
       // Station ss2=new Station("SS3",30,40);
       //Station sss3=new Station("SS4",40,50);
        Station ssss=new Station("SS4",60,50);
        
        res.add(new Arete("S2-S3",1,s,ss));
        res.add(new Arete("S3-S4",1,ss,sss));
        res.add(new Arete("S4-SS4",2,sss,ssss));
        
        assertEquals(res,a);
    }
    
}
