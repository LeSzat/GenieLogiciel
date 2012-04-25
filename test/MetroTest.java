
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
    
    public void testgetNombreLignes(){
      int lignes=  m.getNombreLignes();
        assertEquals(3,lignes);
        
    }
    
    public void testgetMinDistance(){
       double res= m.getMinDistance(m.getStation(6)).getDistance();
        assertEquals(5.,res);
        
    }

    
    
}
