/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package genielogiciel;

/**
 *
 * @author User
 */
public class Parcours {
    
    
    private Station depart;
    private Station arrivee;
    
     public int getDistance(Station s1, Station s2)
    {
        return (int) Math.sqrt((int)Math.pow(s1.getAbscisse()-s2.getAbscisse(),2) +(Math.pow(s1.getOrdonnée()-s2.getOrdonnée(),2)));
    }
    
    
   
       
}
