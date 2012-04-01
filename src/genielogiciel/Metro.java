/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package genielogiciel;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class Metro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
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
        
        CreerMetro m=new CreerMetro();
        
        
        switch(choix ){
            case 1:
                System.out.println("Les informations de quelle station voulez-vous consulter?");
                for(int i=0;i<m.getLignes().length;i++){
                     System.out.println(m.getLigne(i).getNom());
                    for(int j=0;j<m.getLigne(i).getStations();j++){
                       
                        System.out.println(" - " + j + " " + m.getLigne(i).getStation(j).getNom());
                    }
                }
                Scanner sce=new Scanner(System.in);
                       
                while(! sce.hasNextInt()){
                    System.out.println("Choix erroné!Veuillez recommencer!");
                    System.out.println("Les informations de quelle station voulez-vous consulter?");
                for(int i=0;i<m.getLignes().length;i++){
                     System.out.println(m.getLigne(i).getNom());
                    for(int j=0;j<m.getLigne(i).getStations();j++){
                       int somme=i+j;
                        System.out.println(" - " + somme + " " + m.getLigne(i).getStation(j).getNom());
                    }
                }
                }
                int station=sce.nextInt();
                
                
               
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
