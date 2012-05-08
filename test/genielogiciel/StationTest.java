/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package genielogiciel;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class StationTest {
    
    public StationTest() {
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
     * Test of compareTo method, of class Station.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Metro m=new Metro();
        Object s = null;
        Station instance = m.getStation(0);
        int expResult = 0;
        int result = instance.compareTo(m.getStation(0));
        assertEquals(expResult, result);
    }

   

    /**
     * Test of toString method, of class Station.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
       Metro m=new Metro();
        Station instance = m.getStation(0);
        String expResult = (instance.getNom() + " " + instance.getAbscisse() + " " + instance.getOrdonnée() + " " + "\n" + " de la ligne"  + instance.getLigne().getNom() + "\n" + " perturbations : " + instance.isPerturbation() + "\n" + "ascenseur: " + instance.isAscenseur() + "\n" + "accès handicapés: " + instance.isHandicape() );
        String result = instance.toString();
        assertEquals(expResult, result);
    }
}
