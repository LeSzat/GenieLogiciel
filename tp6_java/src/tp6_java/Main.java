/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp6_java;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Main {
    
    public static void main(String[] argv) throws InterruptedException{
       /*   
            ArrayList <Place> places=new ArrayList();
            ArrayList <Agent> agents = new ArrayList();
                  for (int i=0;i<100;i++){
                places.add(new Place(i));
            }
            theatre t=new theatre(places);
          
            agents.add(new Agent("Bernard",t));
            agents.add(new Agent("Robert",t));
            agents.add(new Agent("Ferron",t));
            agents.add(new Agent("Martin",t));
         
          
            agents.get(1).start();
            agents.get(2).start();
            agents.get(3).start();
            agents.get(0).start();
            
            agents.get(1).join();
            agents.get(2).join();
            agents.get(3).join();
            agents.get(0).join();
//            agents.get(1).run();
          //  agents.get(2).run();

          //  t.reserver(t.getPlaces().get(3));
           // t.reserver(t.getPlaces().get(3));
            */
        
        int [] tab= {1,4,6,8,9};
        TrieurMono tr=new TrieurMono(tab);
        tr.trier();
        for(int i=0;i<tr.)
        System.out.println(tr);
            
    
    }
    
}
