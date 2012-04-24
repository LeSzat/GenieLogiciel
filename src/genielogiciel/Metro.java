/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package genielogiciel;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author User
 */
public class Metro {

    private ArrayList<Arete> aretes;
    private ArrayList<Station> station;
   // private LinkedList metro;

    public Metro() {
        aretes = new ArrayList<>();
        station = new ArrayList<>();
    //    metro =  new LinkedList<>();
    //    importerInfoStations();
      //  importerStations();
       
       creerReseau();

    }

   public void creerReseau() {
       /* metro.addLast( new NoeudReseau(new Station("Départ", 0, 0)));
        NoeudReseau fin = new NoeudReseau(new Station("Fin",10,10));
        for (int i = 0; i < lignes.size(); i++) {
           NoeudReseau prem = new NoeudReseau(lignes.get(i).getStation(0));
            for(int j=0;j<lignes.get(i).getNbrStations();j++)
            {
                prem.ajouterSuivant(new NoeudReseau(lignes.get(i).getStation(j)));
            }
            prem.ajouterSuivant(fin);
            metro.add(prem);
        }  */
       
  
     
       
       Station s= new Station("S2",10,20);
       Station ss=new Station("S3",10,30);
       Station sss=new Station("S4",50,20);
       Station ssss=new Station("S5",30,40);
       
       this.station.add(s);
       this.station.add(ss);
       this.station.add(sss);
       this.station.add(ssss);
       this.aretes.add(new Arete("S2-S3",1,s,ss));
       this.aretes.add(new Arete("S3-S4",1,ss,sss));
       this.aretes.add(new Arete("S4-S5",1,sss,ssss));
       int a=0;
       for(int i=0;i<4;i++){
           this.station.get(i).setLigne(1);
           this.station.get(i).setPositionLigne(i);
           this.station.get(i).setTempsArret(1 );
           a++;
           if(a<3){
           this.aretes.get(i).setDistance(5);}
       }
       
       
       s=new Station("SS1",25,10);
       
   //    sss=new Station("SS3",30,40);
       ss= new Station("SS2",50,40);
       ssss=new Station("SS4",60,50);
       this.station.add(s);
       this.station.add(ss);
       this.station.add(sss);
       this.station.add(ssss);
       int j=0;
        this.aretes.add(new Arete("SS1-S4",2,s,sss));
       this.aretes.add(new Arete("S-S4",2,sss,ss));
       this.aretes.add(new Arete("SS2-SS4",2,ss,ssss));
       a=4;
        for(int i=4;i<8;i++){
            
           this.station.get(i).setLigne(2);
            this.station.get(i).setPositionLigne(j);
            this.station.get(i).setTempsArret(1);
            a++;
            if(a<6){
            this.aretes.get(i).setDistance(10); }
            j++;
       }
       
       
       s=new Station("SSS1",10,30);
       ss=new Station("SSS2",20,30);
       sss=new Station("SSS3",30,50);
       ssss=new Station("SSS4",40,60);
        this.station.add(s);
       this.station.add(ss);
       this.station.add(sss);
       this.station.add(ssss);
       j=0;
        for(int i=8;i<12;i++){
           this.station.get(i).setLigne(3);
            this.station.get(i).setPositionLigne(j);
            this.station.get(i).setTempsArret(1);
            j++;
       }
    }
/*
    private void importerStations() {
        String fichier = "listeStationParLigne.txt";

        //lecture du fichier texte	
        try {
            InputStream ips = new FileInputStream(fichier);
            InputStreamReader ipsr = new InputStreamReader(ips);
            try (BufferedReader br = new BufferedReader(ipsr)) {
                String ligne;
                int i = -1;
                while ((ligne = br.readLine()) != null) {
                    String[] tokens = ligne.split(":");
                    if (tokens[0].contains("####")) {
                        i++;
                        lignes.add(new Ligne(tokens[0].substring(5)));
                    } else if (tokens.length == 2) {
                        lignes.get(i).ajouterStation(station.get(tokens[1]));
                    }
                }
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    
    private void importerInfoStations() {
        String fichier = "stationLOc.txt";

        //lecture du fichier texte	
        try {
            InputStream ips = new FileInputStream(fichier);
            InputStreamReader ipsr = new InputStreamReader(ips);
            try (BufferedReader br = new BufferedReader(ipsr)) {
                String ligne;
                int i = -1;
                while ((ligne = br.readLine()) != null) {
                    String[] tokens = ligne.split("\t");                
                    this.station.put(tokens[0], new Station(tokens[0], Double.parseDouble(tokens[1])*3, Double.parseDouble(tokens[2])*150));
              //   this.station.put(tokens[2], new Station(tokens[2], Double.parseDouble(tokens[0]), Double.parseDouble(tokens[1])));
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println(e.toString());
        }
    }  */

    
    
    /*     public LinkedList<NoeudReseau> getMetro() {
        return metro;
    }*/
    
  /*  public NoeudReseau getMetro(int i){
        return this.metro.get(i);
    }

    public void setMetro(LinkedList<NoeudReseau> metro) {
        this.metro = metro;
    }
*/
 /*   public HashMap<String, Station> getStation() {
        return station;
    }
    
    public Station getStation(String i){
        return this.station.get(i);
    }

    public void setStation(HashMap<String, Station> station) {
        this.station = station;
    }
    
    

  //    rechercher la station la plus proche des coordonnées

    public int[] rechercherStationProche(double x,double y){
        int index=0;            //la ligne
        int stationn=0;         // la station
        double distancemin= calculerDistance(this.getLigne(0).getStation(0).getAbscisse(),this.getLigne(0).getStation(0).getOrdonnée(),x,y);
        double distance=0;
        
        for(int i=0;i<this.getNbLignes();i++){       
            for(int j=0;j<this.getLigne(i).getNbrStations();j++){
                distance= calculerDistance(this.getLigne(i).getStation(j).getAbscisse(),this.getLigne(i).getStation(j).getOrdonnée(),x,y);
                if(distance < distancemin){
                    distancemin=distance;
                    index=i;
                    stationn=j;
                }
            }
        }

        
        int[] res={index,stationn};
        return res;
    }
    
    * 
   //  * calcule la distance entre 2 points avec coordonnées (x,y) et (x2,y2)
  
    public double calculerDistance(double x,double y,double x2,double y2){
       double distance = Math.sqrt(((x2-x)*(x2-x)) + ((y2 - y)*(y2 - y)));   
       return distance;
    }
    
    
    */

    public ArrayList<Arete> getAretes() {
        return aretes;
    }
    
    public Arete getArete(int i){
        return this.aretes.get(i);
    }

    public void setAretes(ArrayList<Arete> aretes) {
        this.aretes = aretes;
    }
    
    public void setArete(int i,Arete a){
        this.aretes.set(i, a);
    }

    public ArrayList<Station> getStation() {
        return station;
    }
    
    public Station getStation(int i){
        return this.station.get(i);
    }

    public void setStation(ArrayList<Station> station) {
        this.station = station;
    }
    
    public void setStation(int i,Station s){
        this.station.set(i, s);
    }
       
    public ArrayList<Station> getStationsLigne(int ligne){
        ArrayList<Station> tab=new ArrayList();
        for(int i=0;i<this.station.size();i++){
            if(this.station.get(i).getLigne() == ligne){
                tab.add(this.station.get(i));
            }
        }
        return tab;
    }
    
    public Station  getStationLigne(int ligne,int pos){
        return getStationsLigne(ligne).get(pos);
    }
    
    
    public int getPositionStation(Station s){
        for(int i=0;i<this.station.size();i++){
            if(this.station.get(i).getNom().equalsIgnoreCase(s.getNom()) && (this.station.get(i).getLigne() ==s.getLigne())){
                return i;
            }
        }
        return -1;
    }
    
    
    
    // on obtient toutes les stations d'une ligne entre la pos et pos2
    public ArrayList getStations(int ligne,int pos,int pos2){
        ArrayList res=new ArrayList();
         ArrayList reste=new ArrayList();
        res = getStationsLigne(ligne);
        
        for(int i=pos;i<pos2;i++){
             reste.add(res.get(i));
        }   
        return reste;
    }
    
    
    
    public ArrayList<Arete> getAretesStation(Station s){
        ArrayList<Arete> tab=new ArrayList();
        for(int i=0;i<this.aretes.size();i++){
            if(this.aretes.get(i).getSommetDepart().getNom().equalsIgnoreCase(s.toString())){
                tab.add(this.aretes.get(i));
            }
        }
        return tab;
    }
    
    public int getNombreLignes(){
        int compt=0;
        ArrayList tab=new ArrayList();
        for(int i=0;i<this.station.size();i++){
           if((i == this.station.size()-1) && (! tab.contains(this.station.get(i).getLigne()))) {
                tab.add(this.station.get(i).getLigne());
                compt++;
            }
           else {
            if((this.station.get(i).getLigne() != this.station.get(i+1).getLigne()) && (! tab.contains(this.station.get(i).getLigne()))){
                  tab.add(this.station.get(i).getLigne());
                  compt++;  
            }
           }
        }
        return compt;
    }
    
    
    
    /*
    * calcule l'arete avec distance min pour arriver à la station s
    */
    public Arete getMinDistance(Station s){
        double min=9990;
        Arete amin= this.aretes.get(0);
        for(int i=0;i<this.aretes.size();i++){
            if(this.aretes.get(i).isArrivee(s)){
                if(this.aretes.get(i).getDistance() < min){
                    min = this.aretes.get(i).getDistance();
                    amin=this.aretes.get(i);
                }
            }
        }
        return amin;
    }
    
    
    /*
     * calcule les antécédents optimaux pour arriver a chaque station
     */
    public ArrayList<Arete> getMinDistanceTous(){
        ArrayList a=new ArrayList();
        for(int i=0;i< this.station.size();i++){
           Arete aa= this.getMinDistance(this.getStation(i));
            a.add(aa);
        }
        return a;
    }
    
    
}
