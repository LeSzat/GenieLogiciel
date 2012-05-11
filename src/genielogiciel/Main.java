
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package genielogiciel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Main du programme
 *
 */
public class Main {

    private static Metro m = new Metro();
    private static Scanner sc;

    public static int demanderLigne() {
        System.out.println("***D'une station de quelle ligne?***");
        int i = 0, lignee = 0;
        Iterator iter = m.getLignes().iterator();
        do {
            System.out.println("-" + i + "-" + " ligne " + m.getLigne(i).getNom());
            lignee = i;
            i++;
        } while (iter.hasNext() && i < m.getLignes().size());
        Scanner sce = new Scanner(System.in);
        int lign;
        while ((!sce.hasNextInt()) || ((lign = sce.nextInt()) >= m.getLignes().size())) {
            System.out.println("Choix erroné!Veuillez recommencer!");
            System.out.println("***D'une station de quelle ligne?***");
            iter = m.getLignes().iterator();
            i = 0;
            while (iter.hasNext() && i < m.getLignes().size()) {
                System.out.println("-" + i + "-" + " ligne " + m.getLigne(i).getNom());
                lignee = i;
                i++;
            }
            sce = new Scanner(System.in);
        }
        // int lign=sce.nextInt();
        return lign;
    }

    public static int demanderStation(int lign) {
        int lignee = lign;
        int nbreStations = m.getStationsLigne(lignee).size();
        System.out.println("**Quelle station de  " + m.getLigne(lignee).getNom() + "?**");
        Iterator it = m.getStationsLigne(lignee).iterator();
        int i = 0;
        while (it.hasNext() && i < nbreStations) {
            System.out.println(" - " + i + " - " + m.getStationLigne(lignee, i).getNom());
            i++;
        }
        sc = new Scanner(System.in);
        int next = 0;
        while ((!sc.hasNextInt()) || ((next = sc.nextInt()) >= nbreStations)) {
            System.out.println("Choix erroné!Veuillez recommencer!");
            System.out.println("**Quelle station de  " + m.getLigne(lignee).getNom() + "?**");
            Iterator itt = m.getStationsLigne(lignee).iterator();
            i = 0;
            while (itt.hasNext() && i < nbreStations) {
                System.out.println(" - " + i + " " + m.getStationLigne(lignee, i).getNom());
                i++;
            }
            sc = new Scanner(System.in);
        }
        //     next=sc.nextInt();
        return next;
    }

    /**
     * vérifie si le départ et l'arrivée ne sont pas la même station
     */
    public static boolean verifierDepartArrivee(Station s, Station a) {
        return (s.getNom() != a.getNom());
    }
    
    public static void main(String[] args) {    
        boolean continu=true;
            while(continu){
        System.out.println("Bonjour!");
        System.out.println("Quelle opération voulez-vous effectuer?");
        System.out.println("Veuillez choisir le chiffre correspondant dans la liste");
        
        System.out.println("-1- consulter les infos d'une station");
        System.out.println("-2- consulter les infos d'une ligne");
        System.out.println("-3- consulter les perturbations actuelles");
        System.out.println("-4- afficher le prochain passage d'une ligne");
        System.out.println("-5- trouver le parcours optimal");
        System.out.println("-6- afficher la station la plus proche");
        System.out.println("-7- afficher le parcours optimal en passant par un point");
        System.out.println("-8- afficher le parcours avec le moins de correspondances");
        
        System.out.println("-100- Quitter");
        
        
        Scanner sc=new Scanner(System.in);
        int choix=0;   
            while ((! sc.hasNextInt()) || (choix=sc.nextInt())>9 && choix !=100){
                 System.out.println("Choix erroné!Veuillez recommencer");
                 System.out.println("Bonjour!");
                  System.out.println("Quelle opération voulez-vous effectuer?");
                  System.out.println("Veuillez choisir le chiffre correspondant dans la liste");
                  System.out.println("-1- consulter les infos d'une station");
                  System.out.println("-2- consulter les infos d'une ligne");
                  System.out.println("-3- consulter les perturbations actuelles");
                  System.out.println("-4- afficher le prochain passage d'une ligne");
                  System.out.println("-5- trouver le parcours optimal");
                  System.out.println("-6- afficher la station la plus proche");
                  System.out.println("-7- afficher le parcours optimal en passant par un point");
                  System.out.println("-8- afficher le parcours avec le moins de correspondances");
                  System.out.println("-100- Quitter");
                  sc=new Scanner(System.in);
            }
        switch(choix ){
            case 1:             
                int lig=demanderLigne();
                int statio=demanderStation(lig);
                int lignee=m.getStation(statio).getLigne().getNum();
               System.out.println(m.getStationLigne(m.getLigne(lig).getNum(),statio));            
            break;
           
            case 2:          // -2- consulter les infos d'une ligne"          
              int ligne=demanderLigne();
              System.out.println(m.toString(m.getLigne(ligne))); 
            break;  
            case 3:         //-3- consulter les perturbations d'une ligne                     
                ArrayList t=m.getToutesPerturbations();
                if(t.isEmpty()) {
                    System.out.println("Il n'y a pas de perturbations sur le réseau.");
                    break;
                }
                 Iterator a=t.iterator();
                 System.out.println("Actuellement, il y des perturbations sur les stations suivantes :");
                while(a.hasNext()){
                    Station s=(Station)a.next();
                    System.out.println("station " + s.getNom() + " de la ligne " + s.getLigne().getNum());
                }
            break;
//                
            case 4:
               int line=demanderLigne();
               int stati= demanderStation(line);       
               System.out.println(" - 1 - à l'aller");
               System.out.println(" - 2 - au retour");
               sc=new Scanner(System.in);
               int sens=0;
               while(!sc.hasNextInt() && sens<3){
                   System.out.println("Voulez-vous voir les horaires à l'aller ou au retour?");
                   System.out.println(" - 1 - à l'aller");
                   System.out.println(" - 2 - au retour");
                   sc=new Scanner(System.in);
               }
               sens=sc.nextInt();   
              System.out.println(m.getHorairedePassage(m.getStationLigne(m.getLigne(line).getNum(),stati),sens));  
             break;
            case 5:
                int numLine=demanderLigne();
                System.out.println("Station de départ?");
                int depart=demanderStation(numLine);
                Station dep=m.getStationLigne(numLine,depart);
                
                int numLine2=demanderLigne();
                System.out.println("Station d'arrivée?");
                int arrivee=demanderStation(numLine2);
                Station arr=m.getStationLigne(numLine2,arrivee);

                if(verifierDepartArrivee(dep,arr)){             
                    Parcours par=new Parcours(dep,arr);
                     // par.getDepart().setPerturbation(true);
                    ArrayList parcours=par.dijkstra(dep,arr);
                    if(parcours != null){                 
                         //System.out.println(" - " + par.getDepart().getNom() + " ( ligne " + par.getDepart().getLigne().getNom() +" )");
                         Iterator ite=parcours.iterator();
                         while(ite.hasNext()){
                              Object res=ite.next();           
                             Station arete=((Station)res);
                             System.out.println(" - " + arete.getNom() + " ( ligne " + arete.getLigne().getNom() +" )");
                        }
                          System.out.println(" - " + arr.getNom() + " ( ligne " + arr.getLigne().getNom() +" )"); 
                    }
                    System.out.println("temps : " + par.getTemps() +" min");
                }
                else{
                    System.out.println("Votre station de départ et la même que la station d'arrivée.");
                }
            break;              
            case 6:
                System.out.println("Quelle est votre position?Position X?");
                Scanner s=new Scanner(System.in);   
                int x=0,y=0;
                  while (!s.hasNextInt()) {
                    System.out.println("Quelle est votre position?Position X?");
                    s = new Scanner(System.in);
                   }
                   
                   
                   while (!s.hasNextInt()) {
                    System.out.println("Quelle est votre position?Position Y?");
                    s = new Scanner(System.in);
                   }
                   y = s.nextInt();
                    System.out.println("Position Y?");
                    s=new Scanner(System.in);
    
                y=s.nextInt(); 
                int resu= m.rechercherStationProche(x, y);
                System.out.println("La station la plus proche est la station " + m.getStation(resu));      
            break;         
            case 7:
                ArrayList parcour=null;
                System.out.println("Départ?");
                ligne= demanderLigne();
                int station=demanderStation(ligne);
                Station departS=m.getStationLigne(ligne,station);
                
                System.out.println("Arrivée?");
                int ligne2=demanderLigne();
                int stationA=demanderStation(ligne2);
                Station arriveeS=m.getStationLigne(ligne2,stationA);
                
                System.out.println("En passant par quelle station?");
                int ligne3=demanderLigne();
                int stationInter=demanderStation(ligne3);
                Station interm=m.getStationLigne(ligne3,stationInter);
                
                Parcours p=new Parcours(departS,arriveeS);
                parcour=p.dijkstraParPoint(interm);
                if(parcour != null){
                     Iterator ite=parcour.iterator();
                     while(ite.hasNext()){
                         Station arete=((Station)ite.next());
                        System.out.println("--> " + arete.getNom() +  " ( ligne " + arete.getLigne().getNom() +" )");
                    }
                }
                 System.out.println(" à " + p.getArrivee().getNom() + " ( ligne" + p.getArrivee().getLigne().getNom() + ") ");
             //   System.out.println("temps : " + p.getTemps() + " min");
            break;
            case 8:        
                 int lineD=demanderLigne();
                int stat= demanderStation(lineD);
                Station depar=m.getStationLigne(lineD,stat);
                
                int lineA =demanderLigne();
                stat= demanderStation(lineA);
                Station arriv=m.getStationLigne(lineA,stat);
                 
                 p=new Parcours(depar,arriv);            
                ArrayList<Station> st=p.getMinCorrespondance(p.getDepart(),p.getArrivee());
                if(st == null){
                    break;
                }
                
                if(st.isEmpty()){
                    System.out.println("Les stations sont dans la même ligne.");
                    System.out.println("De " + p.getDepart().getNom() + " à " + p.getArrivee().getNom() + " ligne " + p.getDepart().getLigne().getNom());
                    break;
                }
                System.out.println("Le minumum de correspondances est :" + p.getCorrespondance());
               Iterator sta=st.iterator();
             //  System.out.print("De " + p.getDepart().getNom());
               System.out.println("Votre parcours est : ");
               while(sta.hasNext()){
                   Station sp=(Station)sta.next();
                    System.out.print(" -> " + sp.getNom());
                    System.out.print(" ( ligne"+ sp.getLigne().getNom() + ") " );
               }
              System.out.println(" à " + p.getArrivee().getNom() + " ( ligne" + p.getArrivee().getLigne().getNom() + ") ");
              System.out.println(" \n temps de parcours : " + p.getTemps() + " min");
             //   }
            break;
                
            case 100:
                System.out.println("Au revoir!");
                System.out.println("Merci d'avoir utilisé MiageMetro.");
                System.exit(0);
             break;
        }      
      }
    }
}
   