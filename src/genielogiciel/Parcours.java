/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package genielogiciel;

/**
 *
 * @author User
 */
public class Parcours {
    
    
    private Station depart;
    private Station arrivee;
    private Metro m;

    
    
    
    public Parcours(Station depart,Station arrivee){
        this.depart=depart;
        this.arrivee=arrivee;
        this.m=new Metro();
    }
    

    /**
     * 
     * @param dep la station de départ
     * @param arr la station de départ
     * @param s la station intermédiaire demandée
     * @param m l'ensemble des lignes
     * @return 
     */

    public static void passePar(Station dep, Station arr,Station s, Metro m)

    {
       
        int i=0, tps=0;     
        /**
         * Pour toutes les lignes
         */
        while( i<m.getLignes().size())
        {
            int j=0;
            /**
             * on parcourt les stations de la ligne
             */
            while(j<m.getLigne(i).getStation().size())
            {
                /**
                 * Si la station est la même que celle demandée
                 */
                if(m.getLigne(i).getStation(j).getNom().compareTo(s.getNom()) == 0)
                {          
                    //"calc_tps" à remplacer par la focntion de calcul du temps
                    //tps = calc_tps(dep,m.getLigne(i).getStation(j)) + calc_tps(m.getLigne(i).getStation(j),arr);
                   
                }
                    
            }
        }
        System.out.println("Il vous faudra au mieux " + tps + "pour aller de la station " + dep.getNom() + " à la station "+ arr.getNom() + "en passant par la station " + s.getNom());
    }
    

}
