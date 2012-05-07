/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package genielogiciel;

/**
 * Classe qui modélise les liens entre deux stations d'une ligne
 */
public class Arete implements java.lang.Comparable {

    /**
     * Nom de la ligne
     */
    private String nom;
    /**
     * Numéro de la ligne
     */
    private int num;
    /**
     * Station de départ
     */
    private Station sommetDepart;
    /**
     * Station d'arrivée
     */
    private Station sommetArrivee;
    /**
     * Distance entre la station départ et la station d'arrivée en mètre
     */
    private double distance;
    /**
     * vrai si il y a une perturbation sur ce morceau de la ligne
     */
    private boolean accident;

    /**
     * Constructeur d'une arete
     *
     * @param nom Nom de la ligne
     * @param num Numero de la ligne
     * @param depart Station de départ
     * @param arrivee Station d'arrivée
     */
    public Arete(String nom, int num, Station depart, Station arrivee) {
        this.nom = nom;
        this.num = num;
        this.sommetArrivee = arrivee;
        this.sommetDepart = depart;
        distance = this.sommetDepart.getDistance(this.sommetArrivee);
        this.accident = false;
    }

    /**
     * Rédéfintion de la fonction compareTo pour pouvoir comparer 2 aretes
     *
     * @param o Arete à comparer
     * @return
     */
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

    /**
     * Retourne la distance de cette arete
     * @return la distance entre l'arrivée et le départ
     */
    public double getDistance() {
        return distance;
    }

    /**
     * Affecte la distance entre 2 stations
     * @param distance la distance entre les deux stations
     */
    public void setDistance(double distance) {
        this.distance = distance;
    }
 

    /**
     *
     * @return La station d'arrivée
     */
    public Station getSommetArrivee() {
        return sommetArrivee;
    }

    /**
     *
     * @return La station de départ
     */
    public Station getSommetDepart() {
        return sommetDepart;
    }

    /**
     *
     * @param s Station à comparer
     * @return Vrai si cette station est la sation de départ
     */
    public boolean isDepart(Station s) {
        return this.sommetDepart.getNom().equalsIgnoreCase(s.getNom());
    }

    /**
     *
     * @param s Station à comparer
     * @return Vrai si cette station est la sation d'arrivée
     */
    public boolean isArrivee(Station s) {
        return this.sommetArrivee.getNom().equalsIgnoreCase(s.getNom());
    }

    /**
     * 
     * @return Vrai s'il y a un accident sur cette arete
     */
    public boolean isAccident() {
        return accident;
    }

    /**
     * Active ou désactive un accident
     * @param accident Booléen vrai si accident/ faux sinon
     */
    public void setAccident(boolean accident) {
        this.accident = accident;
    }

    /**
     * 
     * @return Le nom de la ligne
     */
    public String getNom() {
        return nom;
    }

   /**
    * 
    * @return Le numéro de la station
    */
    public int getNum() {
        return num;
    }

}
