/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package genielogiciel;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Metro {

    public ArrayList<Ligne> lignes;

    public Metro() {
        lignes = new ArrayList<Ligne>();
    }

    public void ajouterLigne(Ligne L) {
        lignes.add(L);
    }

    public ArrayList<Ligne> getLignes() {
        return this.lignes;
    }

    public Ligne getLigne(int i) {
        return (Ligne) lignes.get(i);
    }

    public int getNbLignes() {
        return lignes.size();
    }
}
