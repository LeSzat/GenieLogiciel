/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package genielogiciel;

import java.sql.Time;

/*
 * les horaires de passage des lignes(les mêmes pour toutes les lignes) toutes les 12min
 */
public class Horaire {
    public static int debut=6;      // l'heure du 1er passage
    public static int fin=24;        // l'heure de passage du dernier
    public static int[] horaire= {00,12,24,36,48};    // à quelle min passe la ligne
   // private int ligne;

    public Horaire() {
      //  this.ligne = ligne;
    }

/*
    public int getLigne() {
        return ligne;
    }

    public void setLigne(int ligne) {
        this.ligne = ligne;
    }
    
   */

    public static int getDebut() {
        return debut;
    }

    public static void setDebut(int debut) {
        Horaire.debut = debut;
    }

    public static int getFin() {
        return fin;
    }

    public static void setFin(int fin) {
        Horaire.fin = fin;
    }

    public static int[] getHoraire() {
        return horaire;
    }

    public static void setHoraire(int[] horaire) {
        Horaire.horaire = horaire;
    }
    
    
    
    
    
}
