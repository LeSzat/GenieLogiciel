/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp6_java;

/**
 *
 * @author User
 */
public class Place {
    
    private int place;
    private boolean reserve;
    
    
    public Place(int place){
        this.place=place;
        this.reserve=false;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public boolean isReserve() {
        return reserve;
    }

    public void setReserve(boolean reserve) {
        this.reserve = reserve;
    }
    
    
    
    
}
