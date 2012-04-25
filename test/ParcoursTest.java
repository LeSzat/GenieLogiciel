import genielogiciel.Metro;
import junit.framework.TestCase;


public class ParcoursTest extends TestCase{
    
    Metro m=new Metro();
    
    public void testdjikstra(){
      int lignes=  m.getNombreLignes();
        assertEquals(3,lignes);
    }
    
}
