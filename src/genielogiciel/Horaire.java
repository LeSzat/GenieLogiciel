/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package genielogiciel;

/**
 * les horaires de passage des lignes(les mêmes pour toutes les lignes) toutes
 * les 12min
 */
public class Horaire {

    /**
     * Heure du premier passage
     */
    public static final int debut = 6;
    /**
     * Heure du dernier passage
     */
    public static final int fin = 24;
    /**
     * Minute de chaque passage pour l'aller( identique pour chaqe heure)
     */
    public static final int[] horaire = {0, 12, 24, 36, 48};
    /**
     * Minute de chaque passage pour le retour( identique pour chaqe heure)
     */
    public int[] horaireRet;

    /**
     * Constructeur Horaire initilaise les horaires retours
     */
    public Horaire() {
        this.horaireRet = new int[5];
    }

    /**
     *
     * @return l'horaire du début de la ligne
     */
    public static int getDebut() {
        return debut;
    }

    /**
     *
     * @return Le dernier horaire de la ligne
     */
    public static int getFin() {
        return fin;
    }

    /**
     *
     * @return La liste des horaires
     */
    public static int[] getHoraire() {
        return horaire;
    }
}
