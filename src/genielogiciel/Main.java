
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package genielogiciel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
     
             Metro m =new Metro();
        System.out.println("Bonjour!");
        System.out.println("Quelle opération voulez-vous effectuer?");
        System.out.println("Veuillez choisir le chiffre correspondant dans la liste");
        
        System.out.println("-1- consulter les infos d'une station");
        System.out.println("-2- consulter les infos d'une ligne");
        System.out.println("-3- consulter les perturbations actuelles");
     //   System.out.println("-4- consulter les stations accessibles aux personnes à mobilité réduite");
        System.out.println("-5- trouver le parcours optimal");
        System.out.println("-6- afficher la station la plus proche");
        System.out.println("-7- afficher le parcours optimal en passant par un point");
        System.out.println("-8- afficher le parcours avec le moins de correspondances");
        System.out.println("-9- afficher le prochain passage d'une ligne");
        System.out.println("-100- Quitter");
        
        
        Scanner sc=new Scanner(System.in);
        int choix=0;
        if(! sc.hasNextInt()  || ((choix=sc.nextInt())>9 && choix !=100) ) {
            System.out.println("Choix erroné!Veuillez recommencer");
            while ((! sc.hasNextInt()) || choix>9 ){
                 System.out.println("Bonjour!");
                  System.out.println("Quelle opération voulez-vous effectuer?");
                  System.out.println("Veuillez choisir le chiffre correspondant dans la liste");
                  System.out.println("-1- consulter les infos d'une station");
                  System.out.println("-2- consulter les infos d'une ligne");
                  System.out.println("-3- consulter les perturbations actuelles");
                //   System.out.println("-4- consulter les stations accessibles aux personnes à mobilité réduite");
                  System.out.println("-5- trouver le parcours optimal");
                    System.out.println("-6- afficher la station la plus proche");
                    System.out.println("-7- afficher le parcours optimal en passant par un point");
                    System.out.println("-8- afficher le parcours avec le moins de correspondances");
                    System.out.println("-9- afficher le prochain passage d'une ligne");
                    System.out.println("-100- Quitter");
                  sc=new Scanner(System.in);
                 // sc=new Scanner(System.in);
                if(sc.hasNextInt()) choix=sc.nextInt();
            }
        }
        
        switch(choix ){
            case 1:
               System.out.println("***Les informations d'une station de quelle ligne voulez-vous consulter?***");
                int i=0,lignee=0;
                 Iterator iter= m.getLignes().iterator();
                    do{
                         System.out.println("-" + i + "-" + " ligne " + m.getLigne(i).getNom());
                         lignee=i;
                         i++;
                     } while( iter.hasNext() && i<m.getLignes().size()) ;           
               Scanner sce=new Scanner(System.in);                
                while((! sce.hasNextInt()) || (sce.nextInt()>=m.getLignes().size())){
                    System.out.println("Choix erroné!Veuillez recommencer!");
                    System.out.println("***Les informations d'une station de quelle ligne voulez-vous consulter?***");      
                     iter= m.getLignes().iterator();
                     i=0;
                    while( iter.hasNext() && i<m.getLignes().size()){
                         System.out.println("-" + i + "-" + " ligne " +m.getLigne(i).getNom());
                         lignee=i;
                         i++;
                     }
                    sce=new Scanner(System.in);              
                }   
                
                lignee=sce.nextInt();
                int nbreStations=m.getStationsLigne(lignee).size();
                System.out.println("**Quelle station de  " + m.getLigne(lignee).getNom() + " voulez-vous consulter?**");
               Iterator it= m.getStationsLigne(lignee).iterator();
               i=0; 
               while(it.hasNext()&& i<nbreStations){    
                       System.out.println(" - " + i + " - " + m.getStationLigne(lignee, i).getNom()); 
                       i++;
                    }
               sce=new Scanner(System.in);
               int next=0;
               while((! sce.hasNextInt()) || next>= nbreStations){
                    System.out.println("Choix erroné!Veuillez recommencer!");
                       System.out.println("**Quelle station de  " + m.getLigne(lignee).getNom() + " voulez-vous consulter?**");
               Iterator itt= m.getStationsLigne(lignee).iterator();
               i=0; 
               while(itt.hasNext() && i<nbreStations){    
                       System.out.println(" - " + i + " " + m.getStationLigne(lignee, i).getNom()); 
                       i++;
                    }
                     sce=new Scanner(System.in);
                     
               }  
               next=sce.nextInt();
               System.out.println(m.getStationLigne(m.getLigne(lignee).getNum(),next));            
            break;
           
            case 2:          // -2- consulter les infos d'une ligne"
              System.out.println("***Les informations de quelle ligne voulez-vous consulter?***");    
              Iterator iterat=m.getLignes().iterator();
              int ligne=0;
               while(iterat.hasNext() && ligne<m.getLignes().size()){
                    System.out.println("-" + ligne + "- " + m.getLigne(ligne).getNom());
                    ligne++;
                }  
               Scanner lign=new Scanner(System.in);          
               while((! lign.hasNextInt()) || ((ligne=lign.nextInt())>=m.getLignes().size())){
                   System.out.println("Choix erronné! Veuillez choisir le nombre correspondant!");
                   System.out.println("***Les informations de quelle ligne voulez-vous consulter?***");    
                   ligne=0;
                    while(iterat.hasNext() && ligne<m.getLignes().size()){
                         System.out.println("-" + ligne + "- " + m.getLigne(ligne).getNom());
                         ligne++;
                    }               
                    lign=new Scanner(System.in);
               }
              System.out.println(m.toString(m.getLigne(ligne))); 
            break;  
            case 3:         //-3- consulter les perturbations d'une ligne       
                System.out.println("Actuellement, il y des perturbations sur les stations suivantes :");
                 Iterator a=m.getToutesPerturbations().iterator();
                while(a.hasNext()){
                    Station s=(Station)a.next();
                    System.out.println("station " + s.getNom() + " de la ligne " + s.getLigne().getNum());
                }
            break;
////                
////            case 4:
////                
////             break;
            case 5:
                ArrayList parcours=null;
             while(parcours == null){
                System.out.println("Quelle est votre station de départ?");
                String station= sc.next();             
                while( m.existeStation(station) == -1){
                    System.out.println("Cette station n'existe pas!");
                    System.out.println("Quelle est votre station de départ?");
                    station= sc.next(); 
                }
                int depart= m.existeStation(station);
                System.out.println("Quelle est votre station d'arrivée?");
                String arrivee= sc.next();             
                while( m.existeStation(arrivee) == -1){
                    System.out.println("Cette station n'existe pas!");
                    System.out.println("Quelle est votre station d'arrivée?");
                    arrivee= sc.next(); 
                }
                int arrive=m.existeStation(arrivee);
                Parcours p=new Parcours(m.getStation(depart),m.getStation(arrive));
                parcours=p.dijkstra();
                if(parcours != null){
                     Iterator ite=parcours.iterator();
                     while(ite.hasNext()){
                         Arete arete=((Arete)ite.next());
                        System.out.println("de " + arete.getSommetDepart().getNom() + " à "+ arete.getSommetArrivee().getNom() + " ( ligne " + arete.getSommetArrivee().getLigne().getNom() +" )");
                    }
                }
             }
                
            break;              
            case 6:
                System.out.println("Quelle est votre position?Position X?");
                Scanner s=new Scanner(System.in);           
                while(! s.hasNextInt()){
                    System.out.println("Quelle est votre position?Position X?");
                    s=new Scanner(System.in);
                }
                int x=s.nextInt();
                System.out.println("Position Y?");
                while(! s.hasNextInt()){
                    System.out.println("Position Y?");
                    s=new Scanner(System.in);
                }
                int y=s.nextInt(); 
                int res= m.rechercherStationProche(x, y);
                System.out.println("La station la plus proche est la station " + m.getStation(res));      
            break;         
            case 7:
                ArrayList parcour=null;
                while(parcour == null){
                System.out.println("Quelle est votre station de départ?");
                String station= sc.next();             
                while( m.existeStation(station) == -1){
                    System.out.println("Cette station n'existe pas!");
                    System.out.println("Quelle est votre station de départ?");
                    station= sc.next(); 
                }
                int depart= m.existeStation(station);
                System.out.println("Quelle est votre station d'arrivée?");
                String arrivee= sc.next();             
                while( m.existeStation(arrivee) == -1){
                    System.out.println("Cette station n'existe pas!");
                    System.out.println("Quelle est votre station d'arrivée?");
                    arrivee= sc.next(); 
                }
                int arrive=m.existeStation(arrivee);
                System.out.println("En passant par quelle station?");
                String inter= sc.next();             
                while( m.existeStation(inter) == -1){
                    System.out.println("Cette station n'existe pas!");
                    System.out.println("Quelle est votre station d'arrivée?");
                    inter= sc.next(); 
                }
                int interm=m.existeStation(arrivee);
                Parcours p=new Parcours(m.getStation(depart),m.getStation(arrive));
                parcour=p.dijkstraParPoint(m.getStation(interm));
                if(parcour != null){
                     Iterator ite=parcour.iterator();
                     while(ite.hasNext()){
                         Arete arete=((Arete)ite.next());
                        System.out.println("de " + arete.getSommetDepart().getNom() + " à "+ arete.getSommetArrivee().getNom() + " ( ligne " + arete.getSommetArrivee().getLigne().getNom() +" )");
                    }
                }
             }
                
            break;
            case 8:        
                parcours=null;
                while(parcours == null){
                System.out.println("Quelle est votre station de départ?");
                String station= sc.next();             
                while( m.existeStation(station) == -1){
                    System.out.println("Cette station n'existe pas!");
                    System.out.println("Quelle est votre station de départ?");
                    station= sc.next(); 
                }
                int depart= m.existeStation(station);
                System.out.println("Quelle est votre station d'arrivée?");
                String arrivee= sc.next();             
                while( m.existeStation(arrivee) == -1){
                    System.out.println("Cette station n'existe pas!");
                    System.out.println("Quelle est votre station d'arrivée?");
                    arrivee= sc.next(); 
                }
                int arrive=m.existeStation(arrivee);
                Parcours p=new Parcours(m.getStation(depart),m.getStation(arrive));            
                ArrayList<Station> st=p.getMinCorrespondance(p.getDepart(),p.getArrivee());
                System.out.println("Le minumum de correspondances est :" + p.getCorrespondance());
               Iterator stat=st.iterator();
               System.out.print("De " + p.getDepart().getNom());
               while(stat.hasNext()){
                    System.out.print(" -> " +((Station)stat.next()).getNom());
               }
               System.out.println(" à " + p.getArrivee().getNom());
                }
            break;
            case 9:
                System.out.println("Les horaires de quelle ligne voulez-vous consulter?");
                i=0;
                lignee=0;
                iter= m.getLignes().iterator();
                    do{
                         System.out.println("-" + i + "-" + " ligne " + m.getLigne(i).getNom());
                         lignee=i;
                         i++;
                     } while( iter.hasNext() && i<m.getLignes().size()) ;           
               sce=new Scanner(System.in);                
                while((! sce.hasNextInt()) || (sce.nextInt()>=m.getLignes().size())){
                    System.out.println("Choix erroné!Veuillez recommencer!");
                    System.out.println("***Les informations d'une station de quelle ligne voulez-vous consulter?***");      
                     iter= m.getLignes().iterator();
                     i=0;
                    while( iter.hasNext() && i<m.getLignes().size()){
                         System.out.println("-" + i + "-" + " ligne " +m.getLigne(i).getNom());
                         lignee=i;
                         i++;
                     }
                    sce=new Scanner(System.in);              
                }   
                
                lignee=sce.nextInt();
                nbreStations=m.getStationsLigne(lignee).size();
                System.out.println("**Quelle station de  " + m.getLigne(lignee).getNom() + " voulez-vous consulter?**");
               it= m.getStationsLigne(lignee).iterator();
               i=0; 
               while(it.hasNext()&& i<nbreStations){    
                       System.out.println(" - " + i + " - " + m.getStationLigne(lignee, i).getNom()); 
                       i++;
                    }
               sce=new Scanner(System.in);
               next=0;
               while((! sce.hasNextInt()) || next>= nbreStations){
                    System.out.println("Choix erroné!Veuillez recommencer!");
                    System.out.println("**Quelle station de  " + m.getLigne(lignee).getNom() + " voulez-vous consulter?**");
                    Iterator itt= m.getStationsLigne(lignee).iterator();
                    i=0; 
                    while(itt.hasNext() && i<nbreStations){    
                        System.out.println(" - " + i + " " + m.getStationLigne(lignee, i).getNom()); 
                        i++;
                    }
                    sce=new Scanner(System.in);
               }  
               int station=sce.nextInt();
               System.out.println(" - 1 - à l'aller");
               System.out.println(" - 2 - au retour");
               sce=new Scanner(System.in);
               while(!sce.hasNextInt()){
                   System.out.println("Voulez-vous voir les horaires à l'aller ou au retour?");
                   System.out.println(" - 1 - à l'aller");
                   System.out.println(" - 2 - au retour");
               }
               int sens=sce.nextInt();
               
        //       m.getTempsDeTerminus(m.getStation().get(2),2);
               
              System.out.println(m.getHorairedePassage(m.getStationLigne(m.getLigne(lignee).getNum(),station),sens));
            break;
                
            case 100:
                System.out.println("Au revoir!");
                System.exit(0);
             break;
        }
     
        
        
     }
}

