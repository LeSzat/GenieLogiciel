
package genielogiciel;

import java.util.ArrayList;
import java.util.Iterator;

/*
 * représente les lignes qui lient les stations
 */
public class Ligne {

    /**
     * Numéro de la ligne
     */
    private int num;
    /**
     * Nom de la ligne
     */
    private String nom;
    /**
     * Vi
     */
    public static final double vitesse = 18; 

    /**
     * Constructeur d'une ligne
     * @param num Numero de la ligne
     * @param nom Nom de la ligne
     */
    public Ligne(int num, String nom) {
        this.num = num;
        this.nom = nom;
    }

    /**
     * 
     * @return le temps total du parcours de la ligne
     */
    public int getTempsTotalParcours() {
        Metro m = new Metro();
        double distance = 0;
        int temps, index = 0, attente = 0;
        ArrayList<Station> stations = m.getStationsLigne(this.num);
        Iterator it = stations.iterator();
        while (it.hasNext() && (index < stations.size() - 1)) {
            Station s = (Station) it.next();
            Station s2 = (Station) it.next();
            distance = s.getDistance(s2);
            index += 2;
            attente += s2.getTempsArret();
        }
        distance = (distance / 1000) * (Ligne.vitesse);
        temps = (int) (distance * 60) + attente;
        return temps;
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
     * @return le numero de la ligne
     */
    public int getNum() {
        return num;
    }

    /**
     * Réaffecte le numéro de la ligne
     * @param num numero de la ligne
     */
    public void setNum(int num) {
        this.num = num;
    }
}
