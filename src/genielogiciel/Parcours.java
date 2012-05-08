package genielogiciel;

import java.util.*;

/**
 *
 * classe qui permet de retrouver le chemin entre 2 stations 
 */
public class Parcours {
    
    
    /**
     * Station de départ
     */
    private Station depart;
    /**
     * Station d'arrivée
     */
    private Station arrivee;
    /**
     * le métro
     */
    private Metro m;
    private int temps;
    private int correspondance;
    private ArrayList<Station> res;
    
    
    public Parcours(Station depart,Station arrivee){
        this.depart=depart;
        this.arrivee=arrivee;
        this.temps=0;
        this.m=new Metro();  
        this.correspondance=0;
        res=new ArrayList();
    }
      
    
    /*
     * permet de retrouver le chemin optimal entre 2 stations
     */
    
    public ArrayList dijkstra(Station depart,Station arrivee){
        ArrayList stations= m.getStation();     //la liste des stations existantes
        ArrayList<Boolean> parcouru=new ArrayList();     //un bool qui donnent les sommets visités
        ArrayList resultat=new ArrayList();
        Station actuelle = arrivee;
        int changement=0;
        
        if( isDepartPerturbe()){
            System.out.println("il y des perturbations sur la station de départ");
            System.out.println("Veuillez choisir une autre station de départ!");
            return null;
        }
         if( isArriveePerturbee()){
            System.out.println("il y des perturbations sur la station d'arrivée");
            return null;
        }
        Iterator ii= m.getStation().iterator();
        while(ii.hasNext()){
            parcouru.add(Boolean.FALSE);
            ii.next();
        }
        parcouru.set(m.getPositionStation(arrivee), Boolean.TRUE);
    //    resultat.add(m.getMinDistance(depart,depart));
        int i=0,j=0;
    
      //  if(this.depart.getLigne() == this.arrivee.getLigne()){   //si les 2 stations appartiennent à la meme ligne
                if(m.containsStation(depart.getLigne().getNum(), arrivee)){
                Itineraire itin=new Itineraire(this.depart,this.arrivee);                          
                this.temps += itin.getTemps();
                resultat.add(depart);
                resultat.add(arrivee);
                return resultat;
        }
        else{     //si les 2 stations n'appartiennent pas à la meme ligne   
          Iterator iter= m.getStation().iterator();
          iter= m.getStation().iterator();
          while(iter.hasNext()){  
               Station temp= (Station)iter.next();
               i= m.getPositionStation(actuelle);
               j=0;
               ArrayList<Arete> aretes=m.getAretesArriveeStation(actuelle);
                while((  !(actuelle.getNom().equalsIgnoreCase(depart.getNom() ) && ( actuelle.getAbscisse()==depart.getAbscisse() && actuelle.getOrdonnée()==depart.getOrdonnée())))  && actuelle.isPerturbation()==false && j<aretes.size()){   //       
                  parcouru.set(m.getPositionStation(actuelle),true);
                     Arete a= m.getMinDistance(actuelle,depart);                          //on récupère l'arete avec distance min pour le sommet arrivee actuelle                    
                      
                      if(aretes.isEmpty()) return  null;
                     if(m.containsStation(actuelle.getLigne().getNum(),temp)) {   // si la station actuelle est dans la ligne de la station de départ
            //                                dijkstra(depart,temp);
                       //  resultat.add(this.getMinCorrespondance(depart, temp));
                        resultat.add(arrivee);
                         resultat.add(temp);
                        // resultat.add(depart);
                         temp=m.getStationsIdentiques(temp,actuelle.getLigne().getNum());
                         Itineraire it=new Itineraire(actuelle,temp);
                         this.temps  += it.getTemps();
                         Collections.reverse(resultat);
                         return resultat;
                     } 
                   //   Arete a=aretes.get(j);
                     if((parcouru.get(m.getPositionStation(a.getSommetDepart())) == false)){
                        if(temp.getLigne() != actuelle.getLigne()) changement ++;
                        if(a.isArrivee(actuelle) || actuelle.isIdentiqueStation(temp)){
                            // resultat.add(a); // on ajoute cette arete au resultat du chemin
                            //   parcouru.set(i,true); 
                             actuelle= a.getSommetDepart();  //m.getMinDistance(actuelle).getSommetDepart();         
                         }
                        else{
                            if( ! m.getStationsIdentiques(actuelle).isEmpty()){
                              if(a.isArrivee(m.getStationsIdentiques(actuelle).get(0))){
                                // resultat.add(a);
                                 actuelle=m.getMinDistance(actuelle,depart).getSommetDepart(); 
                                 }
                            }
                        }
                          }
                     else {
                         j++;
                     }
                   }
          }
        }
     this.correspondance +=changement;
     Collections.reverse(resultat);
     return resultat;     
    }   
    
    
    /*
     * parcours optimal en passant par un point choisi par l'utilisateur
     */
    public ArrayList dijkstraParPoint(Station s){
        Parcours p=new Parcours(this.depart,s);
        Parcours p2=new Parcours(s,this.arrivee);      
        ArrayList res=new ArrayList();
        ArrayList res2=new ArrayList();
        res=p.dijkstra(depart,s);
        res2=p2.dijkstra(s,arrivee);
        this.correspondance=p.getCorrespondance() + p2.getCorrespondance();
        res.addAll(res2);    
        return res;
    }
    
    
    
    public boolean isDepartPerturbe(){
        return this.depart.isPerturbation();
    }
    
    public boolean isArriveePerturbee(){
        return this.arrivee.isPerturbation();
    }

    public Station getArrivee() {
        return arrivee;
    }

    public void setArrivee(Station arrivee) {
        this.arrivee = arrivee;
    }

    public int getCorrespondance() {
        return correspondance;
    }

    public void setCorrespondance(int correspondance) {
        this.correspondance = correspondance;
    }

    public int getTemps() {
        return temps;
    }

    public void setTemps(int temps) {
        this.temps = temps;
    }

    public Station getDepart() {
        return depart;
    }

    public void setDepart(Station depart) {
        this.depart = depart;
    }
    
   /*
    * calcule le changement avec le min de correspondances
    */
    public ArrayList<Station> getMinCorrespondance(Station depart,Station arrivee){
        //correspondance=0;
       ArrayList<Station> stationsDepart= m.getStationsLigne(depart.getLigne().getNum());
       ArrayList<Station> stationInterm=new ArrayList();    
       ArrayList<Station> stationsArrivee= m.getStationsLigne(arrivee.getLigne().getNum());
       Iterator it= stationsDepart.iterator();
       while(it.hasNext()){
           Station dep= (Station)it.next();
           if(depart.getLigne().getNum() == arrivee.getLigne().getNum()) {          //sans changement de ligne
               return res;
           }
           if (!(m.getStationsIdentiques(dep).isEmpty())){                          
               stationInterm.addAll(m.getStationsIdentiques(dep));
               for(int j=0;j<m.getStationsIdentiques(dep).size();j++){
                  Station actuelle= m.getStationsIdentiques(dep).get(j);
                    if(stationsArrivee.contains(actuelle)){  //avec 1 changement de ligne
                          // res.add(stationInterm.get(0));
                       // stationInterm.add(m.getStationsIdentiques(dep).get(j));
                        res.add(depart);
                        res.add(actuelle);
                        this.correspondance++;
                        Itineraire itin=new Itineraire(actuelle,arrivee);                    
                        this.temps += itin.getTemps();
                        return res;
                    }
               }
             }
        }
        Iterator ite= stationsArrivee.iterator();
       while(it.hasNext()){
           Station dep= (Station)it.next();
           if (!(m.getStationsIdentiques(dep).isEmpty())){                          
               stationInterm.addAll(m.getStationsIdentiques(dep));
               for(int j=0;j<m.getStationsIdentiques(dep).size();j++){
                   Station actuelle=m.getStationsIdentiques(dep).get(j);
                    if(stationsDepart.contains(actuelle)){  //avec 1 changement de ligne
                          // res.add(stationInterm.get(0));
                       // stationInterm.add(m.getStationsIdentiques(dep).get(j));
                        res.add(depart);
                        res.add(actuelle);
                        this.correspondance++;
                        return res;
                    }
               }
             }
        }    
        this.correspondance++;
       return getMinCorrespondance(stationInterm.get(0),arrivee);                   //avec plusieurs changements de ligne
      // return res;
    }
    
 
    
     

}
