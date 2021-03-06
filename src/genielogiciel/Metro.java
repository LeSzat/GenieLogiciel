/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package genielogiciel;

import java.io.BufferedReader;
import java.io.*;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Permet de creer le reseau du metro
 */
public class Metro {

    private ArrayList<Arete> aretes;
    private ArrayList<Station> station;
    private ArrayList<Ligne> lignes;

    public Metro() {
        aretes = new ArrayList<>();
        station = new ArrayList<>();
        lignes = new ArrayList<>();
        importerStations();
        creerAretes();

    }

    @Deprecated
    public void creerReseau() {
        Station s = new Station("S2", 10, 20);
        Station ss = new Station("S3", 10, 30);
        Station sss = new Station("S4", 50, 20);
        Station ssss = new Station("S5", 30, 40);
        s.setPerturbation(true);
        this.station.add(s);
        this.station.add(ss);
        this.station.add(sss);
        this.station.add(ssss);
        this.aretes.add(new Arete("S2-S3", 1, s, ss));
        this.aretes.add(new Arete("S3-S4", 1, ss, sss));
        this.aretes.add(new Arete("S4-S5", 1, sss, ssss));
        this.aretes.add(new Arete("S3-S2", 1, ss, s));
        this.aretes.add(new Arete("S4-S3", 1, sss, ss));
        this.aretes.add(new Arete("S5-S4", 1, ssss, sss));
        Ligne l = new Ligne(0, "0");
        this.lignes.add(l);
        int a = 0;
        for (int i = 0; i < 4; i++) {
            this.station.get(i).setLigne(l);
            this.station.get(i).setPositionLigne(i);
            this.station.get(i).setTempsArret(1);
            a++;
            if (a < 3) {
                this.aretes.get(i).setDistance(5);
            }
        }
        this.station.get(0).setPerturbation(true);

        s = new Station("SS1", 25, 10);

        sss = new Station("SS3", 50, 20);
        ss = new Station("SS2", 50, 15);
        ssss = new Station("SS4", 60, 50);
        this.station.add(s);
        this.station.add(ss);
        this.station.add(sss);
        this.station.add(ssss);
        int j = 0;
        this.aretes.add(new Arete("SS1-SS2", 2, s, ss));
        this.aretes.add(new Arete("SS2-S4", 2, ss, sss));
        this.aretes.add(new Arete("SS3-SS4", 2, sss, ssss));
        this.aretes.add(new Arete("SS2-SS1", 2, ss, s));
        this.aretes.add(new Arete("S4-SS2", 2, sss, ss));
        this.aretes.add(new Arete("SS4-SS3", 2, ssss, sss));
        Ligne l2 = new Ligne(1, "1");
        this.lignes.add(l2);
        a = 4;
        for (int i = 4; i < 8; i++) {

            this.station.get(i).setLigne(l2);
            this.station.get(i).setPositionLigne(j);
            this.station.get(i).setTempsArret(1);
            a++;
            if (a < 6) {
                this.aretes.get(i).setDistance(10);
            }
            j++;
        }


        s = new Station("SSS1", 50, 60);
        ss = new Station("SSS2", 50, 70);
        sss = new Station("SSS3", 60, 50);
        Station sss2 = new Station("SSS4", 60, 60);
        this.station.add(s);
        this.station.add(ss);
        this.station.add(sss);
        this.station.add(sss2);
        this.aretes.add(new Arete("SSS1-SSS2", 2, s, ss));       //ok
        this.aretes.add(new Arete("SSS2-SS4(SSS3)", 2, ss, sss));    //ok
        //   this.aretes.add(new Arete("SS3-SS4",2,sss,ssss));
        this.aretes.add(new Arete("SSS2-SSS1", 2, ss, s));       //ok
        this.aretes.add(new Arete("SS4(SSS3)-SSS4", 2, sss, ss));    //ok
        this.aretes.add(new Arete("SSS4-SSS3(SS4)", 2, ssss, sss));
        Ligne l3 = new Ligne(2, "2");
        this.lignes.add(l3);
        j = 0;
        for (int i = 8; i < 12; i++) {
            this.station.get(i).setLigne(l3);
            this.station.get(i).setPositionLigne(j);
            this.station.get(i).setTempsArret(1);
            this.aretes.get(i).setDistance(5);
            j++;
        }

    }

    /**
     * on importe les stations,lignes et coordonnées à partir d'un fichier
     */
    private void importerStations() {
        File fichier = new File("listeStationParLigne2.txt");
        //lecture du fichier texte	
        try {
            if(!fichier.canRead()){
                System.out.println("Le fichier des données ne peut pas être lu!");
                System.exit(1);
            }
            if(fichier.exists()){
            InputStream ips = new FileInputStream(fichier);
            InputStreamReader ipsr = new InputStreamReader(ips);        
            try (BufferedReader br = new BufferedReader(ipsr)) {
                String ligne;
                int i = 0, j = 0;
                String nomligne;
                while ((ligne = br.readLine()) != null) {
                    String[] tokens = ligne.split(":");
                    String[] nom;
                    Ligne l;
                    if (tokens[0].contains("####")) {
                        nomligne = tokens[1];//.substring(5);
                        l = new Ligne(i, nomligne);
                        l.setNum(j);
                        this.lignes.add(l);
                        j++;
                        //  lignes.add(new Ligne(tokens[0].substring(5)));
                    } else if (tokens.length == 2) {
                        //  lignes.get(i).ajouterStation(station.get(tokens[1]));
                        tokens = ligne.split("\t");
                        nom = tokens[0].split(":");
                        Station s = new Station(nom[1], Double.parseDouble(tokens[1]) * 10, Double.parseDouble(tokens[2]) * 10);
                        s.setLigne(this.lignes.get(j - 1));
                        this.station.add(s);
                    }
                }
            }
            }
            else{
                System.out.println("Le fichier avec les données n'existe pas!");
                System.exit(1);
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    /**
     * on crée automatiquement les arêtes à partir de la liste des stations
     */
    public boolean creerAretes() {
        Iterator it = this.lignes.iterator();
        ArrayList<Station> stations = new ArrayList();
        while (it.hasNext()) {
            stations = getStationsLigne(((Ligne) it.next()).getNum());
            int j = 0;
            for (int i = 0; i < stations.size(); i++) {
                if (i != 0) {
                    Arete a = new Arete(stations.get(i).getLigne().getNom(), stations.get(i).getLigne().getNum(), stations.get(j), stations.get(i));
                    Arete a2 = new Arete("", stations.get(i).getLigne().getNum(), stations.get(i), stations.get(j));
                    this.aretes.add(a2);
                    this.aretes.add(a);
                    j++;
                } else {
                }
            }
        }
        return (!this.aretes.isEmpty());
    }

    /**
     * rechercher la station la plus proche des coordonnées
     */
    public int rechercherStationProche(double x, double y) {
        int stationn = 0, j = 0;         // la station
        double distance = 0, distancemin = 100000;
        Iterator i = this.station.iterator();
        while (i.hasNext()) {
            Station s = (Station) i.next();
            distance = calculerDistance(s.getAbscisse(), s.getOrdonnée(), x, y);
           
            if (distance < distancemin) {
                distancemin = distance;
                stationn = j;
            }
             j++;
        }
        return stationn;
    }

    /**
     * calcule la distance entre 2 points avec coordonnées (x,y) et (x2,y2)
     */
    public double calculerDistance(double x, double y, double x2, double y2) {
        double distance = Math.sqrt(((x2 - x) * (x2 - x)) + ((y2 - y) * (y2 - y)));
        return distance;
    }

    public ArrayList<Ligne> getLignes() {
        return lignes;
    }

    public Ligne getLigne(int i) {
        return this.lignes.get(i);
    }

    public ArrayList<Arete> getAretes() {
        return aretes;
    }

    public Arete getArete(int i) {
        return this.aretes.get(i);
    }

    public void setAretes(ArrayList<Arete> aretes) {
        this.aretes = aretes;
    }

    public void setArete(int i, Arete a) {
        this.aretes.set(i, a);
    }

    public ArrayList<Station> getStation() {
        return station;
    }

    public Station getStation(int i) {
        return this.station.get(i);
    }

    public void setStation(ArrayList<Station> station) {
        this.station = station;
    }

    public void setStation(int i, Station s) {
        this.station.set(i, s);
    }

    /**
     * permet de trouver le prochain passage(horaire) d'une ligne à la station s
     * si sens=1, c'est le sens aller sinon les horaires dans l'autre sens
     */
    public String getHorairedePassage(Station s, int sens) {
        GregorianCalendar d = new GregorianCalendar();
        //Permet de trouver le time actuel
        int heure = d.get(Calendar.HOUR_OF_DAY), i = 0, attente = 0, index = 0;
        int min = d.get(Calendar.MINUTE);
        int sec = d.get(Calendar.SECOND);
        double distance=0;
        int total=0;
        int tempsDeTerminus = 0;
        int[] horaires = Horaire.horaire;
        Horaire h = new Horaire();
        Station station, station2;
        ArrayList<Station> stations = this.getStationsLigne(s.getLigne().getNum());
        Collections.sort(stations);

         if(sens != 1){     // si c'est dans le sens retour
                   Collections.reverse(stations);
                    total = s.getLigne().getTempsTotalParcours();           // on regarde le temps nécesaire à la rame d'arriver au terminus
                    for(int ii=0;ii<horaires.length;ii++){
                   //     horaires[ii] = (Horaire.horaire[ii]+ total + 5)%60;
                        h.horaireRet[ii]=(Horaire.horaire[ii]+ total + 5)%60;                   
                    }
                    
                    tempsDeTerminus = this.getTempsDeTerminus(s,2);
                    for(int j=0;j<h.horaireRet.length;j++){
                        h.horaireRet[j] = (h.horaireRet[j]+tempsDeTerminus)%60;
                    }
                    Arrays.sort(horaires);
                    
                    Arrays.sort(h.horaireRet);
                    i=0;
                    while(i<h.horaireRet.length && h.horaireRet[i]<min){
                        i++;
                     }
                 if(h.horaireRet[h.horaireRet.length-1] <min){
                       heure=heure+1;
                       min= h.horaireRet[0];
                }
                else {
                 min=h.horaireRet[i];
                }
        }
        distance += stations.get(index).getDistance(s);

        if (sens != 1) {     // si c'est dans le sens retour
            Collections.reverse(stations);
            total = s.getLigne().getTempsTotalParcours();           // on regarde le temps nécesaire à la rame d'arriver au terminus
            for (int ii = 0; ii < horaires.length; ii++) {
                //     horaires[ii] = (Horaire.horaire[ii]+ total + 5)%60;
                h.horaireRet[ii] = (Horaire.horaire[ii] + total + 5) % 60;
            }

            tempsDeTerminus = this.getTempsDeTerminus(s, 2);
            for (int j = 0; j < h.horaireRet.length; j++) {
                h.horaireRet[j] = (h.horaireRet[j] + tempsDeTerminus) % 60;
            }
            Arrays.sort(horaires);

            Arrays.sort(h.horaireRet);
            for (int ii = 0; ii < h.horaireRet.length; ii++) {
                System.out.println(h.horaireRet[ii]);
            }
            i = 0;
            while (i < h.horaireRet.length && h.horaireRet[i] < min) {
                i++;
            }
            if (h.horaireRet[h.horaireRet.length - 1] < min) {
                heure = heure + 1;
                min = h.horaireRet[0];
            } else {
                min = h.horaireRet[i];
            }
        } else {                      // si c'est à l'aller
            tempsDeTerminus = this.getTempsDeTerminus(s, 1);
            for (int j = 0; j < horaires.length; j++) {
                horaires[j] = (horaires[j] + tempsDeTerminus) % 60;
            }
            Arrays.sort(horaires);
            while (i < horaires.length && horaires[i] < min) {
                i++;
            }

            if (horaires[horaires.length - 1] < min) {
                heure = heure + 1;
                min = horaires[0];
            } else {
                min = horaires[i];
            }
        }
        if (index == 0) {
            String res = "le prochain passage est à " + heure + "h" + min;
            return res;
        }
        if ((heure < Horaire.debut) || (heure > Horaire.fin)) {
            return ("le premier passage de cette ligne est à " + Horaire.debut + " h" + "\n" + " et le dernier est à" + Horaire.fin + " h");
        } else {
            distance = (distance / 1000) * (Ligne.vitesse);           //le temps de parcours = vitesse*distance
            distance = (distance * 60) + attente;
            return ("le prochain passage est à " + heure + " h" + min);
        }


    }

    /**
     * retourne toutes les stations d'une ligne
     */
    public ArrayList<Station> getStationsLigne(int ligne) {
        ArrayList<Station> tab = new ArrayList();
        Iterator it = this.station.iterator();
        while (it.hasNext()) {
            Station s = (Station) it.next();
            if (s.getLigne().getNum() == ligne) {
                tab.add(s);
            }
        }
        return tab;
    }

    public Station getStationLigne(int ligne, int pos) {
        return getStationsLigne(ligne).get(pos);
    }

    /**
     * retrouve la position d'une station
     */
    public int getPositionStation(String s) {
        for (int i = 0; i < this.station.size(); i++) {
            if (this.station.get(i).getNom().equalsIgnoreCase(s)) {
                return i;
            }
        }
        return -1;
    }

    public int getPositionStation(Station s) {
        for (int i = 0; i < this.station.size(); i++) {
            if (this.station.get(i).getNom().equalsIgnoreCase(s.getNom()) && (this.station.get(i).getLigne().getNum() == s.getLigne().getNum())) {
                return i;
            }
        }
        return -1;
    }

    /**
     * retourne les stations d'une ligne qui appartiennent à d'autres lignes
     */
    public ArrayList<Station> getStationsMultiLignes(int ligne) {
        Iterator it = this.getStationsLigne(ligne).iterator();
        ArrayList<Station> temp, res = new ArrayList();
        while (it.hasNext()) {
            Station station = (Station) it.next();
            temp = this.getStationsIdentiques(station);
            if (!temp.isEmpty()) {
                res.add(station);
            }
        }
        return res;
    }

    /**
     * renvoie les aretes qui partent d'une station
     */
    public ArrayList<Arete> getAretesStation(Station s) {
        ArrayList<Arete> tab = new ArrayList();
        int i = 0;
        Iterator ii = this.aretes.iterator();
        while (ii.hasNext()) {
            Arete a = (Arete) ii.next();
            i++;
            if (a.getSommetDepart().getNom().equalsIgnoreCase(s.getNom())) {
                tab.add(a);
            }
        }
        return tab;
    }

    /**
     * renvoie les aretes qui arrivent à une station
     */
    public ArrayList<Arete> getAretesArriveeStation(Station s) {
        ArrayList<Arete> tab = new ArrayList();
        ArrayList<Station> ident = getStationsIdentiques(s);
        if (s.isPerturbation()) {   // si la station de départ est perturbée,on ne peut pas y arriver
            System.out.println("il y des perturbations liées à cette station");
            return null;
        }
        Iterator ii = this.aretes.iterator();
        while (ii.hasNext()) {
            int i = 0;
            Arete a = (Arete) ii.next();
            if (a.getSommetArrivee().getNom().equalsIgnoreCase(s.getNom())) {
                tab.add(a);
            } else {
                if (i < ident.size()) {
                    if (a.getSommetArrivee().getNom().equalsIgnoreCase(ident.get(i).getNom()) && !(a.getSommetDepart().isPerturbation()) && !(a.isAccident())) {  // on n'ajoute pas les aretes qui ont des perturbations sur leur station de départ
                        tab.add(a);
                        i++;
                    }
                }
            }
        }
        Collections.sort(tab);
        return tab;
    }

    /**
     * le nombre total des lignes du réseau
     */
    public void creerLignes() {
        int compt = 0;
        ArrayList tab = new ArrayList();
        Iterator i = this.station.iterator();
        while (i.hasNext()) {
            Station temp = (Station) i.next();
            if (!tab.contains(temp.getLigne())) {
                tab.add(temp.getLigne());
                compt++;
            }
        }
        this.lignes = tab;
    }

    /**
     * renvoie les stations qui correspondent a cette station (mais pour les
     * autres lignes)
     */
    public ArrayList<Station> getStationsIdentiques(Station s) {
        ArrayList a = new ArrayList();
        Iterator i = this.station.iterator();
        while (i.hasNext()) {
            Station ss = (Station) i.next();
            if (ss.compareTo((Station) s) == 0 && ss.getLigne() != s.getLigne() && (ss.getLigne().getNum() != s.getLigne().getNum())) {
                a.add(ss);
            }
        }
        return a;
    }

    /**
     * renvoie les stations qui correspondent a cette station (mais pour la
     * ligne l)
     */
    public Station getStationsIdentiques(Station s, int ligne) {
        Iterator i = this.station.iterator();
        while (i.hasNext()) {
            Station ss = (Station) i.next();
            if (ss.compareTo(s) == 0 && ss.getLigne() != s.getLigne() && (ss.getLigne().getNum() != s.getLigne().getNum()) && ss.getLigne().getNum() == ligne) {
                return ss;
            }
        }
        return null;

    }

    /**
     * calcule l'arete avec la distance min pour arriver à la station s
     */
    public Arete getMinDistance(Station s, Station depart) {
        double min = 9990;
        ArrayList<Station> a = this.getStationsIdentiques(s);
        Arete amin = null;//this.aretes.get(0);

        Iterator i = this.aretes.iterator();
        while (i.hasNext()) {
            int nbreIdent = a.size();
            Arete aa = (Arete) i.next();
            if (nbreIdent == 0) {         // si cette station ne concerne qu'une ligne
                if (((aa.isArrivee(s)) && ((aa.getDistance() + aa.getSommetDepart().getDistance(depart)) < min)) && (aa.isAccident() == false)) {
                    //nbreIdent--;              
                    min = aa.getDistance() + aa.getSommetDepart().getDistance(depart);
                    amin = aa;
                }
            } else {
                if (((aa.isArrivee(a.get(nbreIdent - 1)) && (aa.getDistance() + aa.getSommetDepart().getDistance(depart) < min)) || ((aa.isArrivee(s)) && (aa.getDistance() < min)))) {
                    if (((aa.isArrivee(a.get(nbreIdent - 1))) && (aa.getDistance() < min) && !(aa.isAccident()))) {
                        nbreIdent--;
                    }
                    min = aa.getDistance() + aa.getSommetDepart().getDistance(depart);
                    amin = aa;
                }
            }
        }
        return amin;
    }

    /**
     * on teste si une station est contenue dans cette ligne
     */
    public boolean containsStation(int ligne,Station s){
        ArrayList<Station> stations=this.getStationsLigne(ligne);
        Iterator it= stations.iterator();
        while(it.hasNext()){
            if(((Station)it.next()).getNom().equals(s.getNom())) {
                return true;
            }
        }
        return false;
    }

    /**
     * teste s'ils existent des perturbations sur cette ligne
     */
    public boolean isLignePerturbee(Ligne i) {
        ArrayList a = this.getStationsLigne(i.getNum());
        boolean perturbe = false;
        Iterator it = a.iterator();
        while (it.hasNext()) {
            if (((Station) it.next()).isPerturbation()) {
                perturbe = true;
            }
        }
        return perturbe;
    }

    public String toString(Ligne l) {
        ArrayList<Station> stations = this.getStationsLigne(l.getNum());
        String res = "La ligne " + l.getNom() + " passe par les stations : ";
        Iterator i = stations.iterator();
        while (i.hasNext()) {
            res += " \n " + (((Station) i.next()).getNom());
        }
        if (this.isLignePerturbee(l)) {
            res += " \n Il y a des perturbations sur cette ligne";
        } else {
            res += " \n Il n'y a pas de perturbations sur cette ligne";
        }
        return res;
    }

    /*
     * teste si une station est le terminus de sa ligne
     */
    public boolean isTerminus(Station s) {
        ArrayList<Station> a = this.getStationsLigne(s.getLigne().getNum());
        return ((((Station) a.get(0)).compareTo(s) == 0) || (((Station) a.get(a.size() - 1)).compareTo(s) == 0));
    }

    /*
     * on calcule le temps nécessaire d'aller du terminus à cette station
     */
    public int getTempsDeTerminus(Station s, int sens) {
        double distance = 0;
        int temps = 0;
        if (sens == 1) {              //si c'est l'aller
            ArrayList<Station> stations = this.getStationsLigne(s.getLigne().getNum());
            Station precedente = null, terminus = stations.get(0);
            Station actuelle;
            for (int i = 0; i < stations.size(); i++) {
                if (precedente != s) {
                    actuelle = stations.get(i);
                    distance += terminus.getDistance(actuelle);
                    temps += (distance) * (Ligne.vitesse);
                    temps = (temps / 60) + terminus.getTempsArret();
                    precedente = actuelle;
                } else {
                    return temps;
                }
            }
        } else {                      //si c'est le retour
            ArrayList<Station> stations = this.getStationsLigne(s.getLigne().getNum());
            Station precedente = null, terminus = stations.get(stations.size() - 1);
            Station actuelle;
            for (int i = (stations.size() - 1); i >= 0; i--) {
                if (precedente != s) {
                    actuelle = stations.get(i);
                    distance += actuelle.getDistance(terminus);
                    temps += (distance) * (Ligne.vitesse);
                    temps = (temps / 60) + terminus.getTempsArret();
                    precedente = actuelle;
                } else {
                    return temps;
                }
            }
        }
        return temps;
    }

    public ArrayList<Station> getToutesPerturbations() {
        ArrayList<Station> res = new ArrayList();
        Iterator it = this.station.iterator();
        while (it.hasNext()) {
            if (((Station) it.next()).isPerturbation()) {
                res.add((Station) it.next());
            }
        }
        return res;
    }

    /*
     * vérifier si une station avec ce nom existe et renvoie so index
     */
    public int existeStation(String s) {
        int rang = 0;
        Iterator it = this.station.iterator();
        while (it.hasNext()) {
            if (((Station) it.next()).getNom().equals(s)) {
                return rang;
            } else {
                rang++;
            }
        }
//        System.out.println(this.station.get(rang));
        return -1;
    }
}
