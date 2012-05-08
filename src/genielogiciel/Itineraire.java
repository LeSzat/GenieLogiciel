/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package genielogiciel;

/**
 * Itinéraire entre 2 stations de la même ligne
 */
public class Itineraire {

    /**
     * Station de départ
     */
    private Station depart;
    /**
     * Station d'arrivée
     */
    private Station arrivee;
    /**
     * Réseau entier
     */
    private Metro m;
    /**
     * Temps en les deux stations
     */
    private int temps;

    /**
     * Constructeur d'un itinéraire
     *
     * @param d Station de départ
     * @param a Station d'arrivée
     */
    public Itineraire(Station d, Station a) {
        this.depart = d;
        this.arrivee = a;
        this.m = new Metro();
      //  this.calculTemps();
    }

    /**
     *
     * @return La station d'arrivée
     */
    public Station getArrivee() {
        return arrivee;
    }

    /**
     *
     * @return La station de départ
     */
    public Station getDepart() {
        return depart;
    }

    /**
     *
     * @return le temps de parcours
     */
    public int getTemps() {
        return temps;
    }

    /**
     * Calcule le temps de parcours de l'iténeraire
     */
    @Deprecated
    private void calculTemps() {
        int res = 0;          
        
        if ((this.depart.getLigne().getNum()) == this.arrivee.getLigne().getNum()) {
            int arrets;
            int d, a;
            if (m.getPositionStation(depart) < m.getPositionStation(arrivee)) {
                int posd = m.getPositionStation(depart);
                int posa = m.getPositionStation(arrivee);
                for (int i = posd; i < posa; i++) {
                    res += m.getStation(i).getTempsArret();
                }
                m.getStationsLigne(this.arrivee.getLigne().getNum());
                arrets = posa-posd;
            } else {
                arrets = (m.getPositionStation(depart) - m.getPositionStation(arrivee));
            }
            this.temps = arrets * 5 + res;
        }
    }
}
