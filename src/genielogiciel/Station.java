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
    private Zone  zone;
    private int abscisse;
    private int ordonnée;
    
    
    public Station(){
        
    }
    
    
    public Station(String nom,boolean handicape,boolean ascenseur,Zone zone){
        this.nom=nom;
        this.ascenseur=ascenseur;
        this.handicape=handicape;
        this.zone=new Zone(zone);
       
    }
    
    
    public Station(String nom,boolean handicape,boolean ascenseur,String adresse,Zone zone){
        this.nom=nom;
        this.ascenseur=ascenseur;
        this.handicape=handicape;
        this.zone=zone;
       
    }
    
    public int getAbscisse()
    {
        return this.abscisse;
    }

    public int getOrdonnée()
    {
        return this.ordonnée;
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
     
    @Override
    public String toString(){
        return (  this.nom + " est dans la zone " + this.getZone().getZone() + "\n" + "ascenseur: " + this.isAscenseur() + "\n" + "accès handicapés: " + this.handicape);
    }
    
}
