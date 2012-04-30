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
    
    //private Station[] ligne;
    private Date jour;
    private boolean enCours;
    
    public Perturbation(){
        jour=new Date();
        enCours=false;
    }
    
    
    public Perturbation(Station[] ligne,Date jour,boolean enCours){
        this.jour=jour;
        this.enCours=enCours;
    }
    
    
    public Perturbation(Station[] stations){
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
  
    
}
