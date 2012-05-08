
import genielogiciel.*;
import junit.framework.TestCase;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class MetroTest extends TestCase{
    
    Metro m=new Metro();
    
//    public void testgetNombreLignes(){
//      int lignes=  m.getNombreLignes();
//        assertEquals(3,lignes);
//        
//    }
    
    public void testgetMinDistance(){
    //   double res= m.getMinDistance(m.getStation(6)).getDistance();
        Metro m=new Metro();
        Station s=m.getStation(0);
        Station ss=m.getStation(1);
        Arete a=new Arete(s.getLigne().getNom(),s.getLigne().getNum(),s,ss);
       double res = m.getMinDistance(ss,s).getDistance();    
        assertEquals(a.getDistance(),res);    
    }
    
    
    public void testgetHorairedePassage(){
       // Station s= new Station("S3",10,30);
         Station s= new Station("S2",10,20);
        s.setLigne(1);
        s.setPositionLigne(1);
        String res=m.getHorairedePassage(s,1);
        assertEquals("le prochain passage est à 22h12",res);
    }
    
    
    public void testgetAretesStation(){
        
       Station s= new Station("S2",10,20);
       s.setLigne(1);
       Station ss=new Station("S3",10,30);
       ss.setLigne(1);
      Arete a=new Arete("S2-S3",1,s,ss);
      
      
      Arete res = m.getAretesStation(m.getStation(5)).get(0);
      assertEquals(a.getSommetDepart().getNom(),res.getSommetDepart().getNom());
      //assertEquals(a.getSommetArrivee(),res.getSommetArrivee());
      
    }

    
    
}
