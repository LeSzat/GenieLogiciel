/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package genielogiciel;

import java.io.*;
import java.util.*;

/**
 *
 * @author User
 */
public class Metro {

    private ArrayList<Arete> aretes;
    private ArrayList<Station> station;
    private ArrayList<Perturbation> perturbations;


    public Metro() {
        aretes = new ArrayList<>();
        station = new ArrayList<>();      
        this.perturbations=new ArrayList();
 
       // importerInfoStations();
      //importerStations();
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
     //  Station interm=new Station("")
       
       this.station.add(s);
       this.station.add(ss);
       this.station.add(sss);
       this.station.add(ssss);
       this.aretes.add(new Arete("S2-S3",1,s,ss));
       this.aretes.add(new Arete("S3-S4",1,ss,sss));
       this.aretes.add(new Arete("S4-S5",1,sss,ssss));
       this.aretes.add(new Arete("S3-S2",1,ss,s));
       this.aretes.add(new Arete("S4-S3",1,sss,ss));
       this.aretes.add(new Arete("S5-S4",1,ssss,sss));
       Ligne l=new Ligne(1,"ligne 1");
       
       int a=0;
       for(int i=0;i<4;i++){
           this.station.get(i).setLigne(l);
           this.station.get(i).setPositionLigne(i);
           this.station.get(i).setTempsArret(1 );
           a++;
           if(a<3){
           this.aretes.get(i).setDistance(5);}
       }
       
       
       s=new Station("SS1",25,10);
       
       sss=new Station("SS3",50,20);
       ss= new Station("SS2",50,15);
       ssss=new Station("SS4",60,50);
       this.station.add(s);
       this.station.add(ss);
       this.station.add(sss);
       this.station.add(ssss);
       int j=0;
        this.aretes.add(new Arete("SS1-SS2",2,s,ss));
       this.aretes.add(new Arete("SS2-S4",2,ss,sss));
       this.aretes.add(new Arete("SS3-SS4",2,sss,ssss));
        this.aretes.add(new Arete("SS2-SS1",2,ss,s));
       this.aretes.add(new Arete("S4-SS2",2,sss,ss));
       this.aretes.add(new Arete("SS4-S4",2,ssss,sss));
       Ligne l2=new Ligne(2,"ligne 2");
       
       a=4;
        for(int i=4;i<8;i++){
            
           this.station.get(i).setLigne(l2);
            this.station.get(i).setPositionLigne(j);
            this.station.get(i).setTempsArret(1);
            a++;
            if(a<6){
            this.aretes.get(i).setDistance(10); }
            j++;
       }
       
       
       s=new Station("SSS1",50,60);
       ss=new Station("SSS2",50,70);
       sss=new Station("SSS3",60,50);
       Station sss2=new Station("SSS4", 60,60);
        this.station.add(s);
       this.station.add(ss);
       this.station.add(sss);
       this.station.add(sss2);
       this.aretes.add(new Arete("SSS1-SSS2",2,s,ss));       //ok
       this.aretes.add(new Arete("SSS2-SS4(SSS3)",2,ss,sss));    //ok
       this.aretes.add(new Arete("SS3-SS4",2,sss,ssss));
        this.aretes.add(new Arete("SSS2-SSS1",2,ss,s));       //ok
       this.aretes.add(new Arete("SS4(SSS3)-SSS4",2,sss,ss));    //ok
       this.aretes.add(new Arete("SSS4-SSS3(SS4)",2,ssss,sss));
       Ligne l3=new Ligne(3,"ligne 3");
       j=0;
        for(int i=8;i<12;i++){
           this.station.get(i).setLigne(l3);
            this.station.get(i).setPositionLigne(j);
            this.station.get(i).setTempsArret(1);
            this.aretes.get(i).setDistance(5);
            j++;
       }
        
    }

   
    private void importerStations() {
        String fichier = "listeStationParLigne.txt";
        //lecture du fichier texte	
        try {
            InputStream ips = new FileInputStream(fichier);
            InputStreamReader ipsr = new InputStreamReader(ips);
            try (BufferedReader br = new BufferedReader(ipsr)) {
                String ligne,ligneApres;
                int i = -1;
                String nomligne = br.readLine();
                nomligne = nomligne.substring(5);
                ligne=br.readLine();
                while (((ligne = br.readLine()) != null) && ((ligneApres = br.readLine()) != null)){
                   // ligneApres=br.readLine();
                    String[] tokens = ligne.split(":");
                    String[] tokens2 = ligneApres.split(":");
                    if (tokens[0].contains("####")) {
                        i++;
                        nomligne=tokens[0].substring(5);
                      //  lignes.add(new Ligne(tokens[0].substring(5)));
                    } else if (tokens.length == 2 && tokens2.length==2) {
                      //  lignes.get(i).ajouterStation(station.get(tokens[1]));
                        this.station.get(i).setLigne(i);
                        this.station.get(i+1).setLigne(i);
                        Arete a= new Arete(nomligne,i,this.station.get(this.getPositionStation(tokens[0])),this.station.get(this.getPositionStation(tokens2[0])));
                        this.aretes.add(a);
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
               // int i = -1;
                while ((ligne = br.readLine()) != null) {
                    String[] tokens = ligne.split("\t");                
                    this.station.add( new Station(tokens[0], Double.parseDouble(tokens[1])*10, Double.parseDouble(tokens[2])*10));
              //   this.station.put(tokens[2], new Station(tokens[2], Double.parseDouble(tokens[0]), Double.parseDouble(tokens[1])));
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println(e.toString());
        }
    }  
   
  //    rechercher la station la plus proche des coordonnées
//
//    public int[] rechercherStationProche(double x,double y){
//        int index=0;            //la ligne
//        int stationn=0;         // la station
//     //   double distancemin= calculerDistance(this.getLigne(0).getStation(0).getAbscisse(),this.getLigne(0).getStation(0).getOrdonnée(),x,y);
//        double distance=0;
//        
//        for(int i=0;i<this.getNbLignes();i++){       
//            for(int j=0;j<this.getLigne(i).getNbrStations();j++){
//                distance= calculerDistance(this.getLigne(i).getStation(j).getAbscisse(),this.getLigne(i).getStation(j).getOrdonnée(),x,y);
//                if(distance < distancemin){
//                    distancemin=distance;
//                    index=i;
//                    stationn=j;
//                }
//            }
//        }
//        int[] res={index,stationn};
//        return res;
//    }
    

//   //  * calcule la distance entre 2 points avec coordonnées (x,y) et (x2,y2)
//  
//    public double calculerDistance(double x,double y,double x2,double y2){
//       double distance = Math.sqrt(((x2-x)*(x2-x)) + ((y2 - y)*(y2 - y)));   
//       return distance;
//    }
    
    
   

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
    
    /*
     * permet de trouver le prochain passage d'une ligne à la station s
     */
    public String getHorairedePassage(Station s,int sens){
       GregorianCalendar d = new GregorianCalendar();
        //Permet de récolter les données (heure,minute,seconde) de la classe GregorianCalendar!
        int heure = d.get(Calendar.HOUR),i=0;
        int min = d.get(Calendar.MINUTE);
        int sec = d.get(Calendar.SECOND); 
        
        int[] horaires=Horaire.horaire;
        Iterator iter=this.getStationsLigne(s.getLigne().getNum()).iterator();          // on récupère toutes les stations de cette ligne
        while(iter.hasNext()){
            
        }
        while(i<horaires.length && horaires[i]<min){
            i++;
        }
        min=horaires[i];
        if( (heure < Horaire.debut) || (heure> Horaire.fin)){
            return( "le premier passage de cette ligne est à " + Horaire.debut + "\n" + " et le dernier est à" + Horaire.fin);
        }
        else return ("le prochain passage est à " + heure + " h" + min);
    }
    
       
    public ArrayList<Station> getStationsLigne(int ligne){
        ArrayList<Station> tab=new ArrayList();
        Iterator it=this.station.iterator();
        while(it.hasNext()){
            Station s= (Station)it.next();
            if(s.getLigne().getNum() == ligne){
                tab.add(s);
            }
        }
        return tab;
    }
    
    public Station  getStationLigne(int ligne,int pos){
        return getStationsLigne(ligne).get(pos);
    }
    
     public int getPositionStation(String s){
        for(int i=0;i<this.station.size();i++){
            if(this.station.get(i).getNom().equalsIgnoreCase(s)){
                return i;
            }
        }
        return -1;
    }
    
    public int getPositionStation(Station s){
        for(int i=0;i<this.station.size();i++){
            if(this.station.get(i).getNom().equalsIgnoreCase(s.getNom()) && (this.station.get(i).getLigne() ==s.getLigne())){
                return i;
            }
        }
        return -1;
    }
    
    
   /* 
    // on obtient toutes les stations d'une ligne entre la pos et pos2
    public ArrayList getStations(int ligne,int pos,int pos2){
        ArrayList res=new ArrayList();
         ArrayList reste=new ArrayList();
        res = getStationsLigne(ligne);
        
        for(int i=pos;i<pos2;i++){
             reste.add(res.get(i));
        }   
        return reste;
    }*/
    
    
    /*
     * renvoie les aretes qui partent d'une station 
     */
    public ArrayList<Arete> getAretesStation(Station s){
        ArrayList<Arete> tab=new ArrayList();
        int i=0;
        Iterator ii= this.aretes.iterator();      
        while(ii.hasNext()){
            Arete a= (Arete)ii.next();
            i++;
            if(a.getSommetDepart().getNom().equalsIgnoreCase(s.getNom())  ){
                tab.add(a);
            }         
        }
        return tab;
    }
        
    
    
    /*
     * renvoie les aretes qui arrivent à une station 
     */
    public ArrayList<Arete> getAretesArriveeStation(Station s){
        ArrayList<Arete> tab=new ArrayList();
        ArrayList<Station> ident = getStationsIdentiques(s);
        
        
        if(s.isPerturbation()){   // si la station de départ est perturbée,on ne peut pas y arriver
            System.out.println("il y des perturbations liées à cette station");
            return null;
        }
        
        
        Iterator ii= this.aretes.iterator();      
        while(ii.hasNext()){
            int i=0;
           Arete a= (Arete)ii.next();
              if(a.getSommetArrivee().getNom().equalsIgnoreCase(s.getNom()) ){
                   tab.add(a);               
              }
              else{
                  if(i<ident.size()){
                     if(a.getSommetArrivee().getNom().equalsIgnoreCase(ident.get(i).getNom()) && !(a.getSommetDepart().isPerturbation())){  // on n'ajoute pas les aretes qui ont des perturbations sur leur station de départ
                        tab.add(a);
                        i++;
                    }
                  }
                  
              }
        }

        Collections.sort(tab);
        return tab;
    }
    
    
    /*
     * le nombre total des lignes du réseau
     */
    public int getNombreLignes(){
        int compt=0;
        ArrayList tab=new ArrayList();
        Iterator i = this.station.iterator();
        while(i.hasNext()){
            Station temp=(Station)i.next();
           if(! tab.contains(temp.getLigne())){
                tab.add(temp.getLigne());
                compt++;
            }
           }   
        return compt;
    }
    
    
    /*
     * renvoie les stations qui correspondent a cette station (mais pour les autres lignes)
     */
    public ArrayList<Station>  getStationsIdentiques(Station s){
        ArrayList a=new ArrayList();
        Iterator i=  this.station.iterator();
        while(i.hasNext()){
            Station ss= (Station)i.next();
            if(ss.isIdentiqueStation(s) && ss.getLigne()!= s.getLigne()){
                a.add(ss);
            }
        }
        return a;
    }
    
    
    
    /*
    * calcule l'arete avec la distance min pour arriver à la station s
    */
    public Arete getMinDistance(Station s){
        double min=9990;
        ArrayList<Station> a= this.getStationsIdentiques(s);
        Arete amin=null;//this.aretes.get(0);
        
        Iterator i=this.aretes.iterator();
        while(i.hasNext()){
            int nbreIdent =a.size();
            Arete aa=(Arete)i.next();
            if(nbreIdent == 0){         // si cette station ne concerne qu'une ligne
                   if(((aa.isArrivee(s)) && (aa.getDistance() < min)) && (aa.isAccident()==false)){
                        //nbreIdent--;              
                    min = aa.getDistance();
                    amin=aa;
                    }
            }
            else{
                if(((aa.isArrivee(a.get(nbreIdent-1)) && (aa.getDistance() < min)) || ((aa.isArrivee(s)) && (aa.getDistance() < min)))){
                    if(((aa.isArrivee(a.get(nbreIdent-1))) && (aa.getDistance() < min) && aa.isAccident()==false)){
                        nbreIdent--;
                    }
                    min = aa.getDistance();
                    amin=aa;
                }
            }
        }
        return amin;
    }
    
       /*
    * calcule l'arete avec le min de correspondance
    */
    public Arete getMinCorrespondance(Station s){
        double min=9990;
        ArrayList<Station> a= this.getStationsIdentiques(s);
        Arete amin=null;//this.aretes.get(0);
        
        Iterator i=this.aretes.iterator();
        while(i.hasNext()){
            int nbreIdent =a.size();
            Arete aa=(Arete)i.next();
            if(nbreIdent == 0){         // si cette station ne concerne qu'une ligne
                   if(((aa.isArrivee(s)) && (aa.getDistance() < min)) && (aa.isAccident()==false)){
                        //nbreIdent--;              
                    min = aa.getDistance();
                    amin=aa;
                    }
            }
            else{
                if(((aa.isArrivee(a.get(nbreIdent-1)) && (aa.getDistance() < min)) || ((aa.isArrivee(s)) && (aa.getDistance() < min))) && aa.getSommetDepart().getLigne()==aa.getSommetArrivee().getLigne()){
                    if(((aa.isArrivee(a.get(nbreIdent-1))) && (aa.getDistance() < min) && aa.isAccident()==false) ){
                        nbreIdent--;
                    }
                    min = aa.getDistance();
                    amin=aa;
                }
            }
        }
        return amin;
    }
    
    
    
    
    /*
     * calcule les antécédents optimaux(distance) pour arriver a chaque station
     
    public ArrayList<Arete> getMinDistanceTous(){
        ArrayList a=new ArrayList();
        for(int i=0;i< this.station.size();i++){
           Arete aa= this.getMinDistance(this.getStation(i));
            a.add(aa);
        }
        return a;
    }
    */

    public ArrayList<Perturbation> getPerturbations() {
        return perturbations;
    }
    
    
    public Perturbation getPerturbation(int position){
        return this.perturbations.get(position);
    }

    public void setPerturbations(ArrayList<Perturbation> perturbations) {
        this.perturbations = perturbations;
    }
    
    public void setPerturbation(int position,Perturbation p){
        this.perturbations.set(position, p);
    }
    
    
}
