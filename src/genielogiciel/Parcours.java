package genielogiciel;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Parcours {
    
    
    private Station depart;
    private Station arrivee;
    private Metro m;
   // private Itineraire resultat;
    private int temps;
    
    
    
    public Parcours(Station depart,Station arrivee){
        this.depart=depart;
        this.arrivee=arrivee;
        temps=0;
        this.m=new Metro();        
    }
      
    
    
    // a changer
    public ArrayList dijkstra(){
        ArrayList stations= m.getStation();     //la liste des stations existantes
        ArrayList poids= m.getAretes();        //le poids de chaque liaison entre les stations
        ArrayList<Boolean> parcouru=new ArrayList();     //un bool qui donnent les stations parcourues
      //  ArrayList<Arete> antecedants=m.getMinDistanceTous();  //l'antécédant de chaque noeud pour avoir le chemin min 
        ArrayList resultat=new ArrayList();
        Station actuelle = arrivee;
        for(int i=0;i<m.getStation().size();i++){
            parcouru.add(Boolean.FALSE);
        }
        
        if(this.depart.getLigne() == this.arrivee.getLigne()){
                  //si les 2 stations appartiennent à la meme ligne
                Itineraire itin=new Itineraire(this.depart,this.arrivee);
                this.temps=(int)itin.calculerDistance();
        }
        else{     //si les 2 stations n'appartiennent pas à la meme ligne   
            while(( !(actuelle.getNom().equalsIgnoreCase(depart.getNom()) && actuelle.getAbscisse()==depart.getAbscisse() && actuelle.getOrdonnée()==depart.getOrdonnée()))){
             for(int i=0;i<m.getStation().size();i++){
                  Arete a= m.getMinDistance(actuelle);                                              
                 if(m.getMinDistance(actuelle).isArrivee(actuelle) || actuelle.isIdentiqueStation(m.getStation(i))){
                   resultat.add(m.getMinDistance(actuelle)); // on ajoute cette arete au resultat du chemin
                   parcouru.set(i,true); 
                   actuelle=m.getMinDistance(actuelle).getSommetDepart();
                   i=0;
                  }          
              }    
            }
        } 
     //   System.out.println(resultat);
        ArrayList res=resultat;
        return resultat;
        
    }
    
    
    
     

}
