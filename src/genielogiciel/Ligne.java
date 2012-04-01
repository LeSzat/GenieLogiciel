/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package genielogiciel;

/**
 *
 * @author User
 */
public class Ligne {
    
    private String nom;
    private Station[] stations;
    private boolean[] perturbations;
    private Perturbation[] perturbationsListe;
    
    
    public Ligne(String nom,Station[] station){
        this.nom=nom;
        stations=new Station[station.length];
        for (int i=0;i<station.length;i++){
            this.stations[i]=station[i];
        }
        perturbations=new boolean[station.length];
        for(int i=0;i<stations.length;i++){
            perturbations[i]=false;
        }
        
        perturbationsListe=new Perturbation[5];
        for(int i=0;i<perturbationsListe.length;i++){
            
            
            // a changer
            perturbationsListe[i]=new Perturbation(stations);
        }
    }

    public boolean[] getPerturbations() {
        return perturbations;
    }
    
    public boolean getPerturbation(int i){
        return perturbations[i];
    }
    

    public void setPerturbations(boolean[] perturbations) {
        for(int i=0;i<perturbations.length;i++){
              this.perturbations[i] = perturbations[i];
        }
      
    }

    public Perturbation[] getPerturbationsListe() {
        return perturbationsListe;
    }
    
    public Perturbation getPerturbationListe(int i){
        return perturbationsListe[i];
    }

    public void setPerturbationsListe(Perturbation[] perturbationsListe) {
        for (int i=0;i<perturbationsListe.length;i++){
            this.perturbationsListe[i] = perturbationsListe[i];
        }
        
    }

    public Station[] getStations() {
        return stations;
    }

    public Station getStation(int i){
        return stations[i];
    }
    
    public void setStations(Station[] stations) {
        for(int i=0;i<stations.length;i++)  this.stations[i] = stations[i];
    }
    
    
    public String toString(){
        String res=  this.nom + " passe par les stations: ";
        for (int i=0;i<this.getStations().length;i++){
                 res +=  "\n" + "-" + i + "- " + this.stations[i].toString();
         }
        System.out.println(res);
        return res;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    
    
    
    
    
}
