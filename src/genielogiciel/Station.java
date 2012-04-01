/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package genielogiciel;

/**
 *
 * @author User
 */
public class Station {
 
    private String nom;
    private boolean handicape;
    private boolean ascenseur;
    private String adresse;
    private Zone  zone;
    
    public Station(){
        
    }
    
    
    public Station(String nom,boolean handicape,boolean ascenseur,Zone zone){
        this.nom=nom;
        this.ascenseur=ascenseur;
        this.handicape=handicape;
        this.zone=new Zone(zone);
        this.adresse="";
    }
    
    
    public Station(String nom,boolean handicape,boolean ascenseur,String adresse,Zone zone){
        this.nom=nom;
        this.ascenseur=ascenseur;
        this.handicape=handicape;
        this.zone=zone;
        this.adresse=adresse;
    }
    
    
    
    
       public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public boolean isAscenseur() {
        return ascenseur;
    }

    public void setAscenseur(boolean ascenseur) {
        this.ascenseur = ascenseur;
    }

    public boolean isHandicape() {
        return handicape;
    }

    public void setHandicape(boolean handicape) {
        this.handicape = handicape;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }
    
    
    
    
    public String toString(){
        return (  this.nom + " est dans la zone " + this.getZone().getZone() + "\n" + "ascenseur: " + this.isAscenseur() + "\n" + "accès handicapés: " + this.handicape);
    }
    
}
