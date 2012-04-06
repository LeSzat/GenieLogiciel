/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package genielogiciel;

import java.util.ArrayList;

/**
 *
 * @author mathias
 */
public class NoeudReseau {
    private Station station;
    private ArrayList<NoeudReseau> suivant;

    public NoeudReseau(Station s) {
        station=s;
        suivant = new ArrayList<>();
    }
    
    public void ajouterSuivant(NoeudReseau s)
    {
        suivant.add(s);
    }

    public Station getStation() {
        return station;
    }

    public ArrayList<NoeudReseau> getSuivant() {
        return suivant;
    }

    
    
    
}
