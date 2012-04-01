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
public class CreerMetro {
    
    private Ligne[] lignes;
    
    public CreerMetro(){
        
        lignes=new Ligne[1];
       
        Zone zone=new Zone(1,2);
        
        ArrayList <Station> stations=new ArrayList();
        stations.add(new Station("Station la défense grande arche",false,true,zone));
        stations.add(new Station("Station argentine",true,true,zone));
        stations.add(new Station("Station george V" , true,false,zone));
        stations.add(new Station("Station porte de vincennes",true,false,zone));
        lignes[0]= new Ligne("Ligne 1",stations);
        
        
    }

    public Ligne[] getLignes() {
        return lignes;
    }

    public Ligne getLigne(int i){
        return lignes[i];
    }
    
    
    public void setLignes(Ligne[] lignes) {
        for(int i=0;i<lignes.length;i++){
              this.lignes[i] = lignes[i];
          }
    }
    
    
    
    
    
    
}
