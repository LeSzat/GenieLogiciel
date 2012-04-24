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
        System.out.println("num de la ligne:" + ligneIdent());
      //  this.resultat=new HashMap();
        
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
    
    
    /*
     * teste si les stations d'arrivee et de départ appartiennent à la même ligne
     * @return le numero de la ligne
     * -1 si les stations n'appartiennent pas à la même ligne
     */
    public int ligneIdent(){
                
               //System.out.println("temps de parcours:" + it.getTemps() + " min");
        return -1;
    }
    
    
    
    // a changer
    public ArrayList djikstra(){
        ArrayList stations=new ArrayList();     //la liste des stations existantes
        ArrayList poids=new ArrayList();        //le poids de chaque liaison entre les stations
        ArrayList parcouru=new ArrayList();     //un bool qui donnent les stations parcourues
        ArrayList antecedants=new ArrayList();  //l'antécédant de chaque noeud pour avoir le chemin min     
        
        for(int i=0;i<10;i++){
            int ligne=ligneIdent();
            if(ligne != -1){        //si les 2 stations n'appartiennent pas à la meme ligne
                
           
         //   stations.addAll(this.m.getLigne(i).getStations());
            poids.set(i,0);
            parcouru.set(i,false);
            antecedants.set(i,new Station());
             }
            else {          //si les 2 stations appartiennent à la meme ligne
                Itineraire itin=new Itineraire(this.depart,this.arrivee);
                itin.calculerDistance();
              //  itin.getTemps();
            }
         }
        
        return stations;
        
    }
    
    
    
     

}
