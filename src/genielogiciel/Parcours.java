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
    

 /*

    public static void passePar(Station dep, Station arr,Station s, Metro m)

    {
       
        int i=0, tps=0;     
        while( i<m.getLignes().size())
        {
            int j=0;
            while(j<m.getLigne(i).getStation().size())
            {
                if(m.getLigne(i).getStation(j).getNom().compareTo(s.getNom()) == 0)
                {          
                    //"calc_tps" à remplacer par la focntion de calcul du temps
                    //tps = calc_tps(dep,m.getLigne(i).getStation(j)) + calc_tps(m.getLigne(i).getStation(j),arr);
                   
                }
                    
            }
        }
        System.out.println("Il vous faudra au mieux " + tps + "pour aller de la station " + dep.getNom() + " à la station "+ arr.getNom() + "en passant par la station " + s.getNom());
    }
   */ 
    
    
 
    
    
    
    
    // a changer
    public ArrayList djikstra(){
        ArrayList stations= m.getStation();     //la liste des stations existantes
        ArrayList poids= m.getAretes();        //le poids de chaque liaison entre les stations
        ArrayList parcouru=new ArrayList();     //un bool qui donnent les stations parcourues
        ArrayList<Arete> antecedants=m.getMinDistanceTous();  //l'antécédant de chaque noeud pour avoir le chemin min 
        ArrayList resultat=new ArrayList();
        
        for(int i=0;i<m.getStation().size();i++){
            parcouru.set(i,false);
        }
        
        for(int i=0;i<10;i++){
            if(this.depart.getLigne() != this.arrivee.getLigne()){        //si les 2 stations n'appartiennent pas à la meme ligne
 
            
            
             }
            else {          //si les 2 stations appartiennent à la meme ligne
                Itineraire itin=new Itineraire(this.depart,this.arrivee);
                this.temps=(int)itin.calculerDistance();
            }
         }
        
        return resultat;
        
    }
    
    
    
     

}
