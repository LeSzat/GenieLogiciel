/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package genielogiciel;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author User
 */
public class Ligne {
    
    
    private int num;
    private String nom;
    public static double vitesse=26;   //vitesse moy 26km/h

    public Ligne(int num, String nom) {
        this.num = num;
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
    
    
    
    /*
     * renvoie le temps qu'il faut pour parcourir toutes les stations de la ligne (de terminus à terminus)
     */
    public int getTempsTotalParcours(){
        Metro m=new Metro();
        double distance=0;
        int temps=0,index=0,attente=0;
        ArrayList<Station> stations = m.getStationsLigne(this.num);
        Iterator it= stations.iterator();
        while(it.hasNext() && (index<stations.size()-1)){
            Station s= (Station)it.next();
            Station s2= (Station)it.next();
            distance= s.getDistance(s2);
            index +=2;
            attente += s2.getTempsArret();
        }
        
        
        distance = (distance/1000) * (Ligne.vitesse);         
        temps = (int)(distance*60) + attente;

        return temps;
    }
}
