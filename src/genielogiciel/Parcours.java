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

    /**
     * 
     * @param dep la station de départ
     * @param arr la station de départ
     * @param s la station intermédiaire demandée
     * @param m l'ensemble des lignes
     * @return 
     */

    public static Station[] passePar(Station dep, Station arr,Station s, Metro m)

    {
        Station []tab_station = null ;
        int i=0, k=0;     
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
                   
                    //if(m.getLigne(i).getNom().compareTo())                           
                    
                    
                    
                    while(tab_station[k] !=null)
                    {
                    
                            
                    }
                    tab_station[k] = s;
                }
                    
            }
        }
        return tab_station;
    }
    

}
