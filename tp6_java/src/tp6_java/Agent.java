/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp6_java;

/**
 *
 * @author User
 */
public class Agent extends Thread{
    
    private String nom;
    private theatre t;
    
    
    public Agent(String nom,theatre t){
        this.nom=nom;
        this.t=t;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
      
    @Override
    public void run(){
        for(int i=0;i<=5;i++){
        boolean res=t.reserver((int)(Math.random()*100));
          //  boolean res=t.reserver(3);
        System.out.println("agent" + this.getNom());
        }
    }
    
    
    
    
}
