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
public class Ligne {
    
    private String nom;
    private ArrayList<Station> stations;
    private boolean[] perturbations;
    private Perturbation[] perturbationsListe;
    
    
    public Ligne(String nom,ArrayList station){
        this.nom=nom;
        stations = new ArrayList(station);
        perturbations=new boolean[station.size()];
        for(int i=0;i<stations.size();i++){
            perturbations[i]=false;
        }
        
        perturbationsListe=new Perturbation[5];
        for(int i=0;i<perturbationsListe.length;i++){
            
            
            // a changer
            perturbationsListe[i]=new Perturbation();
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

    
    public int getStations(){
        return stations.size();
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

  

    public Station getStation(int i){
        return stations.get(i);
    }
    
    public void setStations(ArrayList stations) {
        for(int i=0;i<this.stations.size();i++)  this.stations.set(i,(Station)stations.get(i));
    }
    
    
    public String toString(){
        String res=  this.nom + " passe par les stations: ";
        for (int i=0;i<this.stations.size();i++){
                 res +=  "\n" + "-" + i + "- " + this.stations.get(i).toString();
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
