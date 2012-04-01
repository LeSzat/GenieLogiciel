/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package genielogiciel;

import java.util.Date;

/**
 *
 * @author User
 */
public class Perturbation {
    
    private Station[] ligne;
    private Date jour;
    private boolean enCours;
    
    public Perturbation(){
        ligne= null;
        jour=new Date();
        enCours=false;
    }
    
    
    public Perturbation(Station[] ligne,Date jour,boolean enCours){
        this.ligne=new Station[ligne.length];
        for(int i=ligne.length-1;i>=0;i--){
            this.ligne[i]=ligne[i];
        }
       
        this.jour=jour;
        this.enCours=enCours;
    }
    
    
    public Perturbation(Station[] stations){
         this.ligne=new Station[stations.length];
        for(int i=stations.length-1;i>=0;i--){
            this.ligne[i]=stations[i];
        }
        jour=new Date();
        enCours=false;
    }

    public boolean isEnCours() {
        return enCours;
    }

    public void setEnCours(boolean enCours) {
        this.enCours = enCours;
    }

    public Date getJour() {
        return jour;
    }

    public void setJour(Date jour) {
        this.jour = jour;
    }

    public Station[] getLigne() {
        return ligne;
    }

    public Station getStation(int i){
        return ligne[i];
    }
    
    public void setLigne(Station[] ligne) {
        this.ligne = ligne;
    }
    
    
    
    public void ajoutStation(Station s){
        Station[] lignetmp=new Station[this.ligne.length +1];
        for(int i=this.ligne.length-1;i>=0;i--){
            lignetmp[i]=this.ligne[i];
        }
        lignetmp[this.ligne.length]=s;
        this.ligne=new Station[lignetmp.length];
        for(int i=lignetmp.length-1;i>=0;i--){
            this.ligne[i]=lignetmp[i];
        }
    }
    
    
}
