
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
        
        
        Scanner sc=new Scanner(System.in);
        
        if(! sc.hasNextInt() ) {
            System.out.println("Choix erroné!Veuillez recommencer");
            while (! sc.hasNextInt() ){
                 System.out.println("Bonjour!");
                  System.out.println("Quelle opération voulez-vous effectuer?");
                  System.out.println("Veuillez choisir le chiffre correspondant dans la liste");
                  System.out.println("-1- consulter les infos d'une station");
                  System.out.println("-2- consulter les infos d'une ligne");
                  System.out.println("-3- consulter les perturbations d'une ligne");
                  System.out.println("-4- consulter les stations accessibles aux personnes à mobilité réduite");
                  System.out.println("-5- afficher les zones d'une ligne");
                  sc=new Scanner(System.in);
            }
        }
        
        int choix= sc.nextInt();
        
       
        switch(choix ){
            case 1:
               System.out.println("***Les informations d'une station de quelle ligne voulez-vous consulter?***");
                int i=0,lignee=0;
                              
               Scanner sce=new Scanner(System.in);
                 
                while((! sce.hasNextInt()) || sce.nextInt()>=m.getNombreLignes()){
                    System.out.println("Choix erroné!Veuillez recommencer!");
                    System.out.println("***Les informations d'une station de quelle ligne voulez-vous consulter?***");      
                    Iterator iter= m.getLignes().iterator();
                    while( iter.hasNext()){
                         System.out.println("-" + i + "-" + m.getLigne(i).getNom());
                         lignee=i;
                         i++;
                     }
                    sce=new Scanner(System.in);  
                   
                }            
                lignee=sce.nextInt();
                System.out.println("**Quelle station de  " + m.getLigne(lignee).getNom() + " voulez-vous consulter?**");
               Iterator it= m.getStationsLigne(lignee).iterator();
               i=0; 
               while(it.hasNext()){    
                       System.out.println(" - " + i + " " + m.getStationLigne(lignee, i)); 
                       i++;
                    }
               sce=new Scanner(System.in);
               int next=sce.nextInt();
               while((! sce.hasNextInt()) || next>=m.getStationsLigne(lignee).size()){
                    System.out.println("Choix erroné!Veuillez recommencer!");
                       System.out.println("**Quelle station de  " + m.getLigne(lignee).getNom() + " voulez-vous consulter?**");
               Iterator itt= m.getStationsLigne(lignee).iterator();
               i=0; 
               while(itt.hasNext()){    
                       System.out.println(" - " + i + " " + m.getStationLigne(lignee, i)); 
                       i++;
                    }
                     sce=new Scanner(System.in);
                     next=sce.nextInt();
               }
           //    int station=sce.nextInt();
               
               System.out.println(m.getStationLigne(m.getLigne(lignee).getNum(),sce.nextInt()));
               
                break;
//            
////            case 2:
////              System.out.println("***Les informations de quelle ligne voulez-vous consulter?***");        
////                for( i=0;i<m.getNbLignes();i++){
////                    System.out.println("-" + i + "- " + m.getLigne(i).getNom());
////                    // System.out.println("-" + i + "-" + m.getLigne(i).getNom());
////                }  
////               Scanner lign=new Scanner(System.in);
////               
////               while((! lign.hasNextInt()) || lign.nextInt()>m.getNbLignes()){
////                   System.out.println("***Les informations de quelle ligne voulez-vous consulter?***");        
////                for( i=0;i<m.getNbLignes();i++){
////                    System.out.println("-" + i + "- " + m.getLigne(i).getNom());
////                    // System.out.println("-" + i + "-" + m.getLigne(i).getNom());
////                }  
////               
////               lign=new Scanner(System.in);
////               }
////               
////               
////               m.getLigne(lign.nextInt()).toString();
////            break;
////            
////            case 3:
////                for(int f=0;f<m.getNbLignes();f++){
////                    if(m.getLigne(f).isPerturbations()){
////                        System.out.println("Il y a des perturbations sur les lignes:");
////                        for(int n=0;n< m.getLigne(f).getStationPerturbees().size();n++){
////                              System.out.println(m.getLigne(f).getStationPerturbees().get(n).getNom());
////                        }
////                        }
////                }
////            break;
////                
////            case 4:
////                
////             break;
////            case 5:
////                
////            break;
////                
////            case 6:
////                System.out.println("Quelle est votre position?Position X?");
////                Scanner s=new Scanner(System.in);
////                
////                while(! s.hasNextInt()){
////                    System.out.println("Quelle est votre position?Position X?");
////                    s=new Scanner(System.in);
////                }
////                int x=s.nextInt();
////                System.out.println("Position Y?");
////                while(! s.hasNextInt()){
////                    System.out.println("Position Y?");
////                    s=new Scanner(System.in);
////                }
////                int y=s.nextInt();      
////                System.out.println("x: " + x + " y: "+ y );
////                
////            break;
////            
////        }      
//        
//   
//        
//        for(int i=0;i<m.getStation().size();i++){
//            System.out.println("station: " + m.getStation(i) + " de la ligne " + m.getStation(i).getLigne());
//          
//           
//        }
//          Itineraire ii=new Itineraire(m.getStation(0),m.getStation(3));
//          System.out.println(ii.calculerDistance());
//          ii.setTemps();
//         System.out.println(ii.getTemps());
        
  //     Station s=m.getLigne(1).getStation(1);
   //    Station s2=m.getLigne(1).getStation(2);
   //  Parcours p=new Parcours(s,s2);
        
   /*     System.out.println("Quelles sont vos coordonnées? X?");
        Scanner s=new Scanner(System.in);
        double x=s.nextDouble();
         System.out.println("Y?");
         double y=s.nextDouble();
        int[] res= m.rechercherStationProche(x, y);
        System.out.println("La station la plus proche est la station " + m.getLigne(res[0]).getStation(res[1]).getNom() + " de la ligne " + m.getLigne(res[0]).getNom());
   
        
        
        
      
        Itineraire i=new Itineraire(m.getLigne(0).getStation(0),m.getLigne(0).getStation(2),m.getLigne(0));
       Itineraire ii=new Itineraire(m.getLigne(0).getStation(0),m.getLigne(0).getStation(9),m.getLigne(0));
         System.out.println("distance " + ii.calculerDistance());
        System.out.println("distance " +i.calculerDistance());
      */   
        
        }
        }
}

