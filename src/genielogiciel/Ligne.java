/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package genielogiciel;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author User
 */
public class Ligne {
    
    private String nom;
    private LinkedList<Station> stations;
    private boolean perturbations;
    private ArrayList<Station> stationPerturbees;
    
    /**
     * Constructeur de ligne
     * @param nom 
     */
    public Ligne(String nom)
    {
       this.nom=nom;
       stations = new LinkedList<>();
       stationPerturbees = new ArrayList<>();
       perturbations=false;

    }
   
    
    public void ajouterStation(Station s)
    {
        stations.add(s);
    }

    public boolean isPerturbations() {
        return perturbations;
    }

    public void setPerturbations(boolean perturbations) {
        this.perturbations = perturbations;
    }

    public ArrayList<Station> getStationPerturbees() {
        return stationPerturbees;
    }

    public void setStationPerturbees(ArrayList<Station> stationPerturbees) {
        this.stationPerturbees = stationPerturbees;
    }

    public ArrayList<Station> getStations() {
        return stations;
    }
  
    public void ajouterStationPerturbees(Station s)
    {
        this.perturbations=true;
        stationPerturbees.add(s);
    }
    public void enleverStationPerturbees(Station s)
    {
        stationPerturbees.remove(s);
    }
    public int getNbrStations(){
        return stations.size();
    }
    
    public LinkedList getStation(){
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
        if(this.perturbations){
            res += "\n *** Il y a des perturbations sur les stations : ***";
            for(int i=0;i<this.stationPerturbees.size();i++){
                res += "\n" +this.stationPerturbees.get(i).getNom() + " ";
            }
        }
        else{
            System.out.println("Pas de perturbations signalées sur cette ligne.");
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
