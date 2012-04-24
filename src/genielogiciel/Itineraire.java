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
public class Itineraire {
    /* itinéraire entre 2 stations de la meme ligne l pour calculer l temps de parcours */
    
    private Station depart;
    private Station arrivee;
    private Metro m;
    private int temps;
    
    
    public Itineraire(Station d,Station a){
        this.depart=d;
        this.arrivee=a;
        this.m=new Metro();
        setTemps();
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


    public int getTemps() {
        return temps;
    }

    public void setTemps(int temps) {
        this.temps = temps;
    }
  
   /*
    * calcule le temps de parcours entre 2 stations de la même ligne
    */
    public void setTemps(){
        int res=0,ligne;
        if((ligne=this.depart.getLigne()) == this.arrivee.getLigne()){
           int arrets=0;
           int d,a;
          if((d=this.depart.getPostionLigne()) > (a=this.arrivee.getPostionLigne())){ 
              for(int i=;i<a;i++){
                 res += m.getStation(i).getTempsArret();
              }
            arrets=(this.depart.getPostionLigne() - this.arrivee.getPostionLigne());
          }  
          else{
               arrets=(this.arrivee.getPostionLigne() - this.depart.getPostionLigne());
          }
        this.temps=arrets * 5;
        }
     }
    
    public double calculerDistance(){   
        
   //     d = R * (Pi/2 - ArcSin( sin(destLat) * sin(sourceLat) + cos(destLong - sourceLong) * cos(destLat) * cos(sourceLat)));      
    double earth = 6378;
    double dlat = Math.toRadians(depart.getAbscisse());
    double dlon = Math.toRadians(depart.getOrdonnée());
    
    double alat= Math.toRadians(arrivee.getAbscisse());
    double alon = Math.toRadians(arrivee.getOrdonnée());
   /* double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
               Math.cos(Math.toRadians(depart.getAbscisse())) * Math.cos(Math.toRadians(arrivee.getAbscisse())) *
               Math.sin(dLng/2) * Math.sin(dLng/2);
    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
    double dist = earthRadius * c;
    int meterConversion = 1609;
    return new Float(dist * meterConversion).floatValue();  */
    
    double res= earth*(Math.PI/2 - Math.asin(Math.sin(alat) * Math.sin(dlat) + Math.cos(alon - dlon)* Math.cos(alat) * Math.cos(dlat)) );
    return res;
    }

 
    
    
    
}
