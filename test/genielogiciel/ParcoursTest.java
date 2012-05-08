/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package genielogiciel;

import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class ParcoursTest {
    
    public ParcoursTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of dijkstra method, of class Parcours.
     */
    @Test
    public void testDijkstra() {
        System.out.println("dijkstra");
       Metro m=new Metro();
        Station depart = m.getStation(0);
        Station arrivee = m.getStation(1);
        Parcours instance = new Parcours(depart,arrivee);
        ArrayList expResult = new ArrayList();
        expResult.add(depart);
        expResult.add(arrivee);
        ArrayList result = instance.dijkstra(depart, arrivee);
        assertEquals(expResult, result);
    }

    /**
     * Test of dijkstraParPoint method, of class Parcours.
     */
    @Test
    public void testDijkstraParPoint() {
      System.out.println("dijkstraParPoint");
       Metro m=new Metro();
        Station depart = m.getStation(0);
        Station inter = m.getStation(1);
        Station arrivee = m.getStation(2);
        Parcours instance = new Parcours(depart,arrivee);
        ArrayList expResult = new ArrayList();
        expResult.add(depart);
        expResult.add(inter);
        expResult.add(inter);
        expResult.add(arrivee);
       
        ArrayList result = instance.dijkstraParPoint(inter);
        assertEquals(expResult, result);

    }

  
}
