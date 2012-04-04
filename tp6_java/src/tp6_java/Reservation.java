/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp6_java;

/**
 *
 * @author User
 */
public class Reservation {
    
    
    private Place place;
    private Agent agent;
    
    
    public Reservation(Place place,Agent agent){
        this.place=place;
        this.agent=agent;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }
    
    
    
    
    
    
}
