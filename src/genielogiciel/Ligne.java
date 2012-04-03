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
    private boolean perturbations;
    private ArrayList<Station> stationPerturbees;
    
    public Ligne(String nom)
    {
       this.nom=nom;
       stations = new ArrayList<>();
       stationPerturbees = new ArrayList<>();
       perturbations=false;
    }
   
    
    public void ajouterStation(Station s)
    {
        stations.add(s);
    }
  
    public void ajouterStationPerturbees(Station s)
    {
        stationPerturbees.add(s);
    }
    public void enleverStationPerturbees(Station s)
    {
        stationPerturbees.remove(s);
    }
    public int getNbrStations(){
        return stations.size();
    }
    
    public ArrayList getStation(){
        return this.stations;
    }

    public Station getStation(int i){
        return stations.get(i);
    }
    
    public void setStations(ArrayList stations) {
        for(int i=0;i<this.stations.size();i++)  this.stations.set(i,(Station)stations.get(i));
    }
    
    
    @Override
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
