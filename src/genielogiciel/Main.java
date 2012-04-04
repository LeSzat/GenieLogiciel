/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package genielogiciel;

import java.util.ArrayList;
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
       
        Zone zone=new Zone(1,2);
        Ligne ligne=new Ligne("Ligne 1"); 
        ligne.ajouterStation(new Station("Station la défense grande arche",false,true,zone));
        ligne.ajouterStation(new Station("Station argentine",true,true,zone));
        ligne.ajouterStation(new Station("Station george V" , true,false,zone));
        ligne.ajouterStation(new Station("Station porte de vincennes",true,false,zone));
        Metro m = new Metro();
        m.ajouterLigne(ligne);
        
        
        System.out.println("Bonjour!");
        System.out.println("Quelle opération voulez-vous effectuer?");
        System.out.println("Veuillez choisir le chiffre correspondant dans la liste");
        
        System.out.println("-1- consulter les infos d'une station");
        System.out.println("-2- consulter les infos d'une ligne");
        System.out.println("-3- consulter les perturbations d'une ligne");
        System.out.println("-4- consulter les stations accessibles aux personnes à mobilité réduite");
        System.out.println("-5- afficher les zones d'une ligne");
        
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
           int i;
                
                
               
            //    System.out.println(lignes.get(0).toString());
                for( i=0;i<m.getNbLignes();i++){
                     System.out.println("-" + i + "-" + m.getLigne(i).getNom());
                }
                
           /*     Scanner sce=new Scanner(System.in);
                       
                while(! sce.hasNextInt()){
                    System.out.println("Choix erroné!Veuillez recommencer!");
                    System.out.println("***Les informations d'une station de quelle ligne voulez-vous consulter?***");
                    for( i=1;i<lignes.size();i++){
                         System.out.println("-" + i + "-" + lignes.get(i).getNom());
                     }
                    sce=new Scanner(System.in);
                    
              /*  for(int i=0;i<m.getLignes().length;i++){
                     System.out.println(m.getLigne(i).getNom());
                    for(int j=0;j<m.getLigne(i).getStations();j++){
                       int somme=i+j;
                        System.out.println(" - " + somme + " " + m.getLigne(i).getStation(j).getNom());
                    }
                }
            
               int ligne=sce.nextInt();
               System.out.println("**Quelle station de la ligne" + m.getLigne(i) + "voulez-vous consulter?**");
               for(int j=0;j<lignes.get(i).getStation().size();j++){
                  System.out.println("-" + j + "-" + m.getLigne(i).getStation(j));
               }           
         
               
               
                int station=sce.nextInt();
                
                */
               
                break;
            
            case 2:
                 m.getLigne(0).toString();
                
            break;
            
            case 3:
                
            break;
                
            case 4:
                
             break;
            case 5:
                
            break;
            
        }
        
        
        
    }
}

