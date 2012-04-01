/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package genielogiciel;

/**
 *
 * @author User
 */
public class CreerMetro {
    
    private Ligne[] lignes;
    
    public CreerMetro(){
        
        lignes=new Ligne[1];
        Station[] stations=new Station[5];
        Zone zone=new Zone(1,2);
        stations[0]=new Station("Station la défense grande arche",false,true,zone);
        stations[1]=new Station("Station esplanade de la défense",true,true,zone); 
        stations[2]= new Station("Station argentine",true,true,zone); 
        stations[3]=new Station("Station george V" , true,false,zone);
        stations[4]= new Station("Station porte de vincennes",true,false,zone);
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
