/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package genielogiciel;

/**
 *
 * @author User
 */
public class Arete {
    
    private String nom;
    private int num;
    private Station sommetDepart;
    private Station sommetArrivee;
    private double distance;      //la distance de parcours
    
    
    public Arete(String nom,int num,Station depart,Station arrivee){
        this.nom=nom;
        this.num=num;
        this.sommetArrivee=arrivee;
        this.sommetDepart=depart;
        distance=this.sommetDepart.getDistance(this.sommetArrivee);
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Station getSommetArrivee() {
        return sommetArrivee;
    }

    public void setSommetArrivee(Station sommetArrivee) {
        this.sommetArrivee = sommetArrivee;
    }

    public Station getSommetDepart() {
        return sommetDepart;
    }

    public void setSommetDepart(Station sommetDepart) {
        this.sommetDepart = sommetDepart;
    }
    
    
    public boolean isDepart(Station s){
        return this.sommetDepart.getNom().equalsIgnoreCase(s.getNom());
    }
    
    public boolean isArrivee(Station s){
        return this.sommetArrivee.getNom().equalsIgnoreCase(s.getNom());
    }
    
    
}
