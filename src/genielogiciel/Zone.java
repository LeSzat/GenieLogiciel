/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package genielogiciel;

/**
 *
 * une zone tarifaire
 */
public class Zone {

   
    
    private int zone;
    private double prix;
    
    
    public Zone(int zone,double prix){
        this.prix=prix;
        this.zone=zone;
    }
    
    public Zone(Zone z){
        this.prix=z.getPrix();
        this.zone=z.getZone();
    }
    
    
     public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getZone() {
        return zone;
    }

    public void setZone(int zone) {
        if (zone > 7 || zone <1) {
            System.out.println("cette zone est erronnée!");
        }
        else {
        this.zone = zone;
          }
    }
    
    
    
}
