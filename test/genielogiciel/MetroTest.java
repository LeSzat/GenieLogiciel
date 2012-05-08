/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package genielogiciel;

import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;
import sun.awt.geom.AreaOp;

/**
 *
 * @author User
 */
public class MetroTest {
    
  
    public MetroTest() {
        
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
     * Test of rechercherStationProche method, of class Metro.
     */
    @Test
    public void testRechercherStationProche() {
        System.out.println("rechercherStationProche");
        double x = 0.0;
        double y = 0.0;
        Metro instance = new Metro();
        int expResult = 0;
        int result = instance.rechercherStationProche(x, y);
        assertEquals(expResult, result);
    }

    /**
     * Test of calculerDistance method, of class Metro.
     */
    @Test
    public void testCalculerDistance() {
        System.out.println("calculerDistance");
        double x = 0.0;
        double y = 0.0;
        double x2 = 10.0;
        double y2 = 10.0;
        Metro instance = new Metro();
        double expResult = Math.sqrt(200);
        double result = instance.calculerDistance(x, y, x2, y2);
        assertEquals(expResult, result, 0.0);
    }




    /**
     * Test of getStationLigne method, of class Metro.
     */
    @Test
    public void testGetStationLigne() {
        System.out.println("getStationLigne");
        Metro instance = new Metro();
        
        Station expResult = instance.getStation(0);
        Station result = instance.getStationLigne(0,0);
        assertEquals(expResult, result);
    }

    /**
     * Test of getPositionStation method, of class Metro.
     */
    @Test
    public void testGetPositionStation_String() {
        System.out.println("getPositionStation");
        Metro instance = new Metro();
        int expResult = 0;
        String s = instance.getStation(0).getNom();
        int result = instance.getPositionStation(s);
        assertEquals(expResult, result);
    }

    /**
     * Test of getPositionStation method, of class Metro.
     */
    @Test
    public void testGetPositionStation_Station() {
        System.out.println("getPositionStation");
   
        Metro instance = new Metro();
        Station s = instance.getStation(0);
        int expResult = 0;
        int result = instance.getPositionStation(s);
        assertEquals(expResult, result);
    }

    /**
     * Test of getStationsMultiLignes method, of class Metro.
     */
    @Test
    public void testGetStationsMultiLignes() {
        System.out.println("getStationsMultiLignes");
        int ligne = 0;
        Metro instance = new Metro();
        ArrayList expResultat=new ArrayList();
        expResultat.add(instance.getStationsLigne(3).get(4));
        ArrayList result = instance.getStationsMultiLignes(3);
        assertEquals(expResultat, result);
    }



    /**
     * Test of getAretesArriveeStation method, of class Metro.
     */
    @Test
    public void testGetAretesArriveeStation() {
        System.out.println("getAretesArriveeStation");
        Metro instance = new Metro();
        Station s=instance.getStation(0);
        ArrayList expResult = new ArrayList();
        expResult.add(instance.getArete(0));
        ArrayList result = instance.getAretesArriveeStation(s);
        assertEquals(expResult, result);
    }




    /**
     * Test of isLignePerturbee method, of class Metro.
     */
    @Test
    public void testIsLignePerturbee() {
        System.out.println("isLignePerturbee");
        Metro instance = new Metro();
        Ligne i = instance.getLigne(1);
        boolean expResult = false;
        boolean result = instance.isLignePerturbee(i);
        assertEquals(result, false);
    }


    /**
     * Test of isTerminus method, of class Metro.
     */
    @Test
    public void testIsTerminus() {
        System.out.println("isTerminus");
        Metro instance = new Metro();
        Station s=instance.getStation(instance.getStation().size()-1);
        boolean result = instance.isTerminus(s);
        assertEquals(result, true);
    }





    /**
     * Test of existeStation method, of class Metro.
     */
    @Test
    public void testExisteStation() {
        System.out.println("existeStation");
        String s = "Avron";
        Metro instance = new Metro();
        int result = instance.existeStation(s);
        assertEquals(36, result);
    }
}
