/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package genielogiciel;

/**
 *
 * @author User
 */
public class Arete implements java.lang.Comparable {

    private String nom;
    private int num;
    private Station sommetDepart;
    private Station sommetArrivee;
    private double distance;      //la distance de parcours
    private boolean accident;

    public Arete(String nom, int num, Station depart, Station arrivee) {
        this.nom = nom;
        this.num = num;
        this.sommetArrivee = arrivee;
        this.sommetDepart = depart;
        distance = this.sommetDepart.getDistance(this.sommetArrivee);
        this.accident = false;
    }

    @Override
    public int compareTo(Object o) {
        double dist = ((Arete) o).getDistance();
        if (dist > this.getDistance()) {
            return -1;
        } else if (dist == this.getDistance()) {
            return 0;
        } else {
            return 1;
        }
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

    public boolean isDepart(Station s) {
        return this.sommetDepart.getNom().equalsIgnoreCase(s.getNom());
    }

    public boolean isArrivee(Station s) {
        return this.sommetArrivee.getNom().equalsIgnoreCase(s.getNom());
    }

    public boolean isAccident() {
        return accident;
    }

    public void setAccident(boolean accident) {
        this.accident = accident;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
