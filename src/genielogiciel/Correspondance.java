/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package genielogiciel;

/**
 *
 * @author User
 */
public class Correspondance {
    
    
    private int ligne1;
    private int ligne2;
    private Station s;

    public Correspondance(int ligne1, int ligne2) {
        this.ligne1 = ligne1;
        this.ligne2 = ligne2;
    }

    public int getLigne1() {
        return ligne1;
    }

    public void setLigne1(int ligne1) {
        this.ligne1 = ligne1;
    }

    public int getLigne2() {
        return ligne2;
    }

    public void setLigne2(int ligne2) {
        this.ligne2 = ligne2;
    }

    public Station getS() {
        return s;
    }

    public void setS(Station s) {
        this.s = s;
    }
    
    
    
    
}
