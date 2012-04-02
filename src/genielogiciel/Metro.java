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
public class Metro {
    
    public ArrayList<Ligne> lignes;
    
        public Metro(){
                lignes=new ArrayList<Ligne>();
    }
//à refaire
    public void creer(){
          Zone zone=new Zone(1,2);
        ArrayList <Station> stations=new ArrayList<Station>();
        
        stations.add(new Station("Station la défense grande arche",false,true,zone));
        stations.add(new Station("Station argentine",true,true,zone));
        stations.add(new Station("Station george V" , true,false,zone));
        stations.add(new Station("Station porte de vincennes",true,false,zone));
        Ligne ligne=new Ligne("Ligne 1",stations);  
        Ligne ligne2=new Ligne("Ligne 2",stations);
        lignes.add(ligne);
        lignes.add(ligne2);
       
    }
        
   /* public ArrayList<Ligne> getLignes() {
        return this.lignes;
    } */

    public Ligne getLigne(int i){
        return (Ligne)lignes.get(i);
    }
    
    
   
    
    public int getSize()
    {
        return lignes.size();
    }
    
    
    
    
    
}

