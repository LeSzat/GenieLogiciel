/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package genielogiciel;

/**
 *
 * @author User
 */
public class Parcours {
    
    
    private Station depart;
    private Station arrivee;
    private int nbreChangements;
    private Ligne[] lignes;
    private Station[] intermediaires;
    private int temps_parcours;
    
    
    public Parcours(int nbchangements, int tps_parcours){
        this.depart=new Station();
        this.arrivee=new Station();
        nbreChangements=nbchangements;
        lignes=null;
        intermediaires=null;
        temps_parcours = tps_parcours;
        
    }

    public Station getArrivee() {
        return arrivee;
    }

    public void setArrivee(Station arrivee) {
        this.arrivee = arrivee;
    }

    public Station getDepart() {
        return depart;
    }

    public void setDepart(Station depart) {
        this.depart = depart;
    }

    public Station[] getIntermediaires() {
        return intermediaires;
    }
    
    public Station getIntermediaires(int i){
        return intermediaires[i];
    }

    public void setIntermediaires(Station[] intermediaires) {
        for(int i=0;i<intermediaires.length;i++){
             this.intermediaires[i] = intermediaires[i];
        }
       
    }

    public Ligne[] getLignes() {
        return lignes;
    }
    
    public Ligne getLignes(int i){
        return lignes[i];
    }
    

    public void setLignes(Ligne[] lignes) {
        for(int i=lignes.length;i>=0;i--){
             this.lignes[i] = lignes[i];
        }
       
    }

    public int getNbreChangements() {
        return nbreChangements;
    }

    //
    public void setNbreChangements(int nbreChangements) {
        this.nbreChangements = nbreChangements;
    }
    
    public int getDistance(Station s1, Station s2)
    {
        return (int) Math.sqrt((int)Math.pow(s1.getAbscisse()-s2.getAbscisse(),2) +(Math.pow(s1.getOrdonnée()-s2.getOrdonnée(),2)));
    }
    
    
    
}
