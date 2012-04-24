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
public class theatre {
    
    private ArrayList <Place> places;
   
   
    
    public theatre(ArrayList place){
       this.places=new ArrayList(place);     
    }
    
    public void ajouterPlace(Place place){
        places.add(place);
    }
    
    public synchronized boolean reserver(int place){ 
        if (! places.get(place).isReserve()){  
          
             places.get(place).setReserve(true);
             System.out.println("la place " + place + " a été reservée");
              return places.get(place).isReserve()   ;
        }
        else {
            System.out.println("la place est deja reservee");
            return false;
        }
    }
   


    public ArrayList<Place> getPlaces() {
        return places;
    }

    public void setPlaces(ArrayList<Place> places) {
        this.places = places;
    }

   
   
 
    
    
    
    
}
