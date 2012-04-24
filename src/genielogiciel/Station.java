package genielogiciel;

import java.util.ArrayList;
import java.util.HashMap;


public class Station {
    
 
    private String nom;
    private int ligne;
    private int position;
    private boolean handicape;
    private boolean ascenseur;
//    private Zone  zone;
    private double abscisse;
    private double ordonnée;
    private boolean perturbation;
    private int tempsArret;
    
   
     public Station(){
        this.nom="";
        this.handicape=false;
        this.abscisse=0;
        this.ordonnée=0;
        this.ascenseur=false;
        this.perturbation=false;
        this.ligne=0;
        this.position=0;
    }
    
    public Station(String nom, double x, double y){
        this.nom=nom;
        this.abscisse=x;
        this.ordonnée=y;       
        this.perturbation=false;
       this.ligne=0;
        this.position=0;

    }
    
     
     
    public Station(String nom,int ligne,boolean handicape,boolean ascenseur,Zone zone){
        this.nom=nom;
        this.ascenseur=ascenseur;
        this.handicape=handicape;
//        this.zone=new Zone(zone);
       this.perturbation=false;
       this.ligne=ligne;
        this.position=0;
    }
    
    
    public Station(String nom,boolean handicape,boolean ascenseur){
        this.nom=nom;
        this.ascenseur=ascenseur;
        this.handicape=handicape;
//        this.zone=zone;
        this.perturbation=false;
        this.ligne=0;
        this.position=0;
       
    }
    
    public double getAbscisse()
    {
        return this.abscisse;
    }

    public double getOrdonnée()
    {
        return this.ordonnée;
    }
    
    public boolean isAscenseur() {
        return ascenseur;
    }

    public void setAscenseur(boolean ascenseur) {
        this.ascenseur = ascenseur;
    }

    public boolean isPerturbation() {
        return perturbation;
    }

    public void setPerturbation(boolean perturbation) {
        this.perturbation = perturbation;
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

    public int getLigne() {
        return ligne;
    }

    public void setLigne(int ligne) {
        this.ligne = ligne;
    }
    
    public int getPostionLigne() {
        return this.position;
    }

    public void setPositionLigne(int pos) {
        this.position=pos;
    }



    public int getTempsArret() {
        return tempsArret;
    }

    public void setTempsArret(int tempsArret) {
        this.tempsArret = tempsArret;
    }
    
    

//    public Zone getZone() {
//        return zone;
//    }
//
//    public void setZone(Zone zone) {
//        this.zone = zone;
//    }
//     
    
    
    /*
     * renvoie la distance entre 2 arrêts voisins (sans prendre en compte les arretes intermédiaires)
     */
    public double getDistance(Station s){
        double distance;
        distance=Math.sqrt((s.getAbscisse()-this.getAbscisse())* (s.getAbscisse()-this.getAbscisse()) + (s.getOrdonnée()-this.getOrdonnée())*(s.getOrdonnée()-this.getOrdonnée()));
       return distance;
    }
    
    
    @Override
    public String toString(){

   return (  this.nom +" "+this.abscisse+" "+this.ordonnée+"\n" + " de la ligne" + this.ligne+ "\n" + "ascenseur: " + this.isAscenseur() + "\n" + "accès handicapés: " + this.handicape );

    }
    
    
    
    
}
