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
public class ItineraireTest extends TestCase {
    
    Metro m=new Metro();
    
    public void testSetgetTemps(){
        m.creerReseau();
        Itineraire i =new Itineraire(m.getStation(0),m.getStation(2));
       // i.setTemps();
        assertEquals(12,i.getTemps());
    }
    
    
}
