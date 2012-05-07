package genielogiciel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;


public class Station implements java.lang.Comparable {
    
 
    private String nom;
    private Ligne ligne;
    private int position;
    private boolean handicape;
    private boolean ascenseur;
//    private Zone  zone;
    private double abscisse;
    private double ordonnée;
    private boolean perturbation;
    private int tempsArret;
    
   
    
    
    public Station(String nom, double x, double y){
        this.nom=nom;
        this.abscisse=x;
        this.ordonnée=y;       
        this.perturbation=false;
        this.ligne=new Ligne(0,"0");
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

    public Ligne getLigne() {
        return ligne;
    }

    public void setLigne(Ligne ligne) {
        this.ligne = ligne;
    }
     public void setLigne(int ligne) {
        this.ligne = new Ligne(ligne,"" +ligne);
    }
    
    
    public int getPostionLigne() {
        return this.position;
    }

    public void setPositionLigne(int pos) {
        this.position=pos;
    }

//    public int compare(Station s,Station ss){
//        return(s.ligne.getNum() - ss.getLigne().getNum());
//    }
    
    public int compareTo(Object s){
        if (((Station)s).position > this.position)  return -1; 
        else if(((Station)s).position == this.position) return 0; 
        else return 1;
   }  

    public int getTempsArret() {
        return tempsArret;
    }

    public void setTempsArret(int tempsArret) {
        this.tempsArret = tempsArret;
    }
    
   /*
    * teste si 2 stations sont identiques (le cas de lignes différentes)
    */
    public boolean isIdentiqueStation(Station s){
      //  Comparator<double,double> comp = new DoubleComparator();
        
        if(this.getAbscisse()== s.getAbscisse() && this.getOrdonnée()== s.getOrdonnée() ){
            return true;
        }
        return false;
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
     * renvoie la distance entre 2 arrêts voisins 
     */
    public double getDistance(Station s){           //distance euclidienne
        return Math.sqrt((s.getAbscisse()-this.getAbscisse())* (s.getAbscisse()-this.getAbscisse()) + (s.getOrdonnée()-this.getOrdonnée())*(s.getOrdonnée()-this.getOrdonnée()));
    }
    
    
    @Override
    public String toString(){

   return (  this.nom +" "+this.abscisse+" "+this.ordonnée+"\n" + " de la ligne" + this.ligne.getNom()+ "\n" + "ascenseur: " + this.isAscenseur() + "\n" + "accès handicapés: " + this.handicape );

    }

    
    
    
}
