package genielogiciel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 *
 * classe qui permet de retrouver le chemin entre 2 stations
 */
public class Parcours {

    /**
     * Station de départ
     */
    private Station depart;
    /**
     * Station d'arrivée
     */
    private Station arrivee;
    /**
     * le métro
     */
    private Metro m;
    /**
     * Temps de parcours
     */
    private int temps;
    /**
     * Nombre de correspondance
     */
    private int correspondance;
    /**
     * Liste des stations empruntées
     */
    private ArrayList<Station> res;

    /**
     * Permet de calculer un parcours
     *
     * @param depart Station de départ
     * @param arrivee Station d'arrivée
     */
    public Parcours(Station depart, Station arrivee) {
        this.depart = depart;
        this.arrivee = arrivee;
        this.temps = 0;
        this.m = new Metro();
        this.correspondance = 0;
        res = new ArrayList();
    }

    /**
     * permet de retrouver le chemin optimal entre 2 stations
     */
    public ArrayList dijkstra(Station depart, Station arrivee) {
        ArrayList stations = m.getStation();     //la liste des stations existantes
        ArrayList<Boolean> parcouru = new ArrayList();     //un bool qui donnent les sommets visités
        ArrayList resultat = new ArrayList();
        Station actuelle = arrivee;
        int changement = 0;

        if (isDepartPerturbe()) {
            System.out.println("il y des perturbations sur la station de départ");
            System.out.println("Veuillez choisir une autre station de départ!");
            return null;
        }
        if (isArriveePerturbee()) {
            System.out.println("il y des perturbations sur la station d'arrivée");
            return null;
        }
        Iterator ii = m.getStation().iterator();
        while (ii.hasNext()) {
            parcouru.add(Boolean.FALSE);
            ii.next();
        }
        parcouru.set(m.getPositionStation(arrivee), Boolean.TRUE);
        //    resultat.add(m.getMinDistance(depart,depart));
        int i = 0, j = 0;


        //  if(this.depart.getLigne() == this.arrivee.getLigne()){   //si les 2 stations appartiennent à la meme ligne
        if (m.containsStation(depart.getLigne().getNum(), arrivee)) {
            Itineraire itin = new Itineraire(this.depart, this.arrivee);
            this.temps += itin.getTemps();
            resultat.add(depart);
            resultat.add(arrivee);
            return resultat;

        } else {     //si les 2 stations n'appartiennent pas à la meme ligne   
            Iterator iter = m.getStation().iterator();
            iter = m.getStation().iterator();
            while (iter.hasNext()) {
                Station temp = (Station) iter.next();
                i = m.getPositionStation(actuelle);
                j = 0;
                ArrayList<Arete> aretes = m.getAretesArriveeStation(actuelle);
                while ((!(actuelle.getNom().equalsIgnoreCase(depart.getNom()) && (actuelle.getAbscisse() == depart.getAbscisse() && actuelle.getOrdonnée() == depart.getOrdonnée()))) && actuelle.isPerturbation() == false && j < aretes.size() && !(actuelle.getNom().equalsIgnoreCase(arrivee.getNom()))) {   //       
                    if (temp == null) {
                        break;
                    }
                    parcouru.set(m.getPositionStation(actuelle), true);
                    Arete a = m.getMinDistance(actuelle, depart);                          //on récupère l'arete avec distance min pour le sommet arrivee actuelle                    

                    if (aretes.isEmpty()) {
                        return null;
                    }
                    if (actuelle.getNom().equalsIgnoreCase(temp.getNom())) {
                        break;
                    }
                    if (m.containsStation(actuelle.getLigne().getNum(), depart) || (m.containsStation(depart.getLigne().getNum(), actuelle))) {   // si la station actuelle est dans la ligne de la station de départ
                        //                                dijkstra(depart,temp);
                        //  resultat.add(this.getMinCorrespondance(depart, temp));
                        resultat.add(arrivee);
                        resultat.add(actuelle);
                        // resultat.add(temp);
                        // resultat.add(depart);
                        if (m.containsStation(actuelle.getLigne().getNum(), depart)) {
                            resultat.add(m.getStationsIdentiques(depart, actuelle.getLigne().getNum()));
                        }
                        if (m.containsStation(depart.getLigne().getNum(), actuelle)) {
                            resultat.add(m.getStationsIdentiques(actuelle, depart.getLigne().getNum()));
                        }
                        resultat.add(depart);
                        Collections.reverse(resultat);
                        return resultat;

//                        if(temp != null){
//                            Itineraire it = new Itineraire(actuelle, temp);
//                            this.temps += it.getTemps();
//                            Collections.reverse(resultat);
//                            return resultat;
//                        }
//                        else {
//                            break;
//                        }

                    }
                    //   Arete a=aretes.get(j);
                    if ((parcouru.get(m.getPositionStation(a.getSommetDepart())) == false)) {
                        if (temp.getLigne() != actuelle.getLigne()) {
                            changement++;
                        }
                        temp = m.getStationsIdentiques(temp, actuelle.getLigne().getNum());
                        if (a.isArrivee(actuelle) || actuelle.compareTo(temp) == 0 || temp != null) {
                            //     resultat.add(a); // on ajoute cette arete au resultat du chemin                     
                            //   parcouru.set(i,true); 
                            actuelle = a.getSommetDepart();
                        } else {
                            if (!m.getStationsIdentiques(actuelle).isEmpty()) {
                                if (a.isArrivee(m.getStationsIdentiques(actuelle).get(0))) {
                                    // resultat.add(a);
                                    resultat.add(m.getStationsIdentiques(actuelle).get(0));
                                    this.temps += actuelle.getTempsArret() + actuelle.getDistance(m.getMinDistance(actuelle, depart).getSommetDepart()) * Ligne.vitesse;
                                    actuelle = m.getMinDistance(actuelle, depart).getSommetDepart();
                                    // actuelle = m.getStationsIdentiques(actuelle).get(0);
                                }
                            }
                        }
                    } else {
                        j++;
                    }
                }
            }


            this.correspondance += changement;
            if (resultat.isEmpty()) {
                return this.getMinCorrespondance(depart, arrivee);
            }
        }
        this.correspondance += changement;
        Collections.reverse(resultat);
        return resultat;
    }


    /*
     * parcours optimal en passant par un point choisi par l'utilisateur
     */
    public ArrayList dijkstraParPoint(Station s) {
        Parcours p = new Parcours(this.depart, s);
        
        Parcours p2 = new Parcours(s, this.arrivee);
        
        ArrayList res = new ArrayList();
        ArrayList res2 = new ArrayList();
        res = p.dijkstra(depart, s);
        System.out.println("parcours 1 : temps " + p.getTemps()+ " min");
        res2 = p2.dijkstra(s, arrivee);
        System.out.println("parcours 2 : temps " + p2.getTemps() + " min");
        this.correspondance = p.getCorrespondance() + p2.getCorrespondance();
        res.addAll(res2);
        return res;
    }

    public boolean isDepartPerturbe() {
        return this.depart.isPerturbation();
    }

    public boolean isArriveePerturbee() {
        return this.arrivee.isPerturbation();
    }

    public Station getArrivee() {
        return arrivee;
    }

    public void setArrivee(Station arrivee) {
        this.arrivee = arrivee;
    }

    public int getCorrespondance() {
        return correspondance;
    }

    public void setCorrespondance(int correspondance) {
        this.correspondance = correspondance;
    }

    public int getTemps() {
        return temps;
    }

    public void setTemps(int temps) {
        this.temps = temps;
    }

    public Station getDepart() {
        return depart;
    }

    public void setDepart(Station depart) {
        this.depart = depart;
    }

    /**
     * calcule le changement avec le min de correspondances
     */
    public ArrayList<Station> getMinCorrespondance(Station depart, Station arrivee) {
        //correspondance=0;
        if (depart.isPerturbation()) {
            System.out.println("Il y des perturbations sur votre station de départ");
            System.out.println("Choisissez une autre station");
            return null;
        }
        if (arrivee.isPerturbation()) {
            System.out.println("Il y des perturbations sur votre station de départ");
            System.out.println("Choisissez une autre station");
            return null;
        }
        ArrayList<Station> stationsDepart = m.getStationsLigne(depart.getLigne().getNum());
        ArrayList<Station> stationInterm = new ArrayList();
        ArrayList<Station> stationsArrivee = m.getStationsLigne(arrivee.getLigne().getNum());
        Iterator it = stationsDepart.iterator();
        while (it.hasNext()) {
            Station dep = (Station) it.next();
            if (depart.getLigne().getNum() == arrivee.getLigne().getNum()) {          //sans changement de ligne
                return res;
            }
            if (!(m.getStationsIdentiques(dep).isEmpty())) {
                stationInterm.addAll(m.getStationsIdentiques(dep));
                for (int j = 0; j < m.getStationsIdentiques(dep).size(); j++) {
                    Station actuelle = m.getStationsIdentiques(dep).get(j);
                    if (stationsArrivee.contains(actuelle)) {  //avec 1 changement de ligne
                        // res.add(stationInterm.get(0));
                        // stationInterm.add(m.getStationsIdentiques(dep).get(j));
                        res.add(depart);
                        //    res.add(m.getStationsIdentiques(actuelle,arrivee.getLigne().getNum()));
                        res.add(actuelle);
                        this.correspondance++;
                        Itineraire itin = new Itineraire(actuelle, arrivee);
                        this.temps += itin.getTemps();
                        return res;
                    }
                }
            }
        }
        Iterator ite = stationsArrivee.iterator();
        while (it.hasNext()) {
            Station dep = (Station) it.next();
            if (!(m.getStationsIdentiques(dep).isEmpty())) {
                stationInterm.addAll(m.getStationsIdentiques(dep));
                for (int j = 0; j < m.getStationsIdentiques(dep).size(); j++) {
                    Station actuelle = m.getStationsIdentiques(dep).get(j);
                    if (stationsDepart.contains(actuelle)) {  //avec 1 changement de ligne
                        // res.add(stationInterm.get(0));
                        // stationInterm.add(m.getStationsIdentiques(dep).get(j));
                        res.add(depart);
                        res.add(actuelle);
                        res.add(stationInterm.get(j));
                        this.correspondance++;
                        this.temps += depart.getTemps(actuelle);
                        return res;
                    }
                }
            }
        }
    //    res.add(depart);
        this.temps += depart.getTemps(stationInterm.get(0));
        this.correspondance++;

        return getMinCorrespondance(stationInterm.get(0), arrivee);                   //avec plusieurs changements de ligne
        // return res;
    }
//    
//    public ArrayList dijkstraChangements(Station a, Station b) {
//        if (this.depart.getLigne() == this.arrivee.getLigne()) {
//            return dijkstra();
//        } else {
//            this.depart = a;
//            this.arrivee = b;
//            boolean bcorrespondance = true;
//            Station corresp;
//            ArrayList tab = new ArrayList();
//
//            ArrayList<Station> stationsD = m.getStationsLigne(this.depart.getLigne().getNum());
//            ArrayList<Station> stationsA = m.getStationsLigne(this.arrivee.getLigne().getNum());
//            // Iterator it= stationsD.iterator();
//            Station d = null;
//            //    if( bcorrespondance){
//            //  while(it.hasNext()){  
//            for (int j = 0; j < stationsD.size(); j++) {
//                d = stationsD.get(j);
//                ArrayList ident = m.getStationsIdentiques(d);
//                //    Iterator it2= stationsA.iterator();
//                for (int i = 0; i < stationsA.size(); i++) {
//                    // while(it2.hasNext()){                 
//                    if ((stationsA.get(i).compareTo(d) == 0) && !(stationsA.get(i).isPerturbation())) {
//                        bcorrespondance = false;
//                        correspondance++;
//                        corresp = d;
//                        tab.add(ident.get(0));
//                        tab.add(corresp);
//                        return tab;
//                        //  return corresp;
//                    }
//                }
//            }
//            //      }
//            //    else{              
//            correspondance++;
//            tab.add(d);
//            tab.addAll(this.dijkstraChangements(m.getStation(6), this.arrivee));
//            return tab;
//            //    }
//
//            //  return tab;
//        }
//    }
}
