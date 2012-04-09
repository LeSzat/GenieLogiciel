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

    private ArrayList<Ligne> lignes;
    private HashMap<String, Station> station;
    private LinkedList<NoeudReseau> metro;

    public Metro() {
        lignes = new ArrayList<>();
        station = new HashMap<>();
        metro =  new LinkedList<>();
        importerInfoStations();
        importerStations();
        creerReseau();

    }

    private void creerReseau() {
        metro.addLast( new NoeudReseau(new Station("Départ", 0, 0)));
        NoeudReseau fin = new NoeudReseau(new Station("Fin",10,10));
        for (int i = 0; i < lignes.size(); i++) {
           NoeudReseau prem = new NoeudReseau(lignes.get(i).getStation(0));
            for(int j=0;j<lignes.get(i).getNbrStations();j++)
            {
                prem.ajouterSuivant(new NoeudReseau(lignes.get(i).getStation(j)));
            }
            prem.ajouterSuivant(fin);
            metro.add(prem);
        }
        System.out.println("NbLigne : "+lignes.size()+"\t"+metro.size());
        System.out.println(metro);

    }

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
                    this.station.put(tokens[0], new Station(tokens[0], Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2])));
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println(e.toString());
        }
    }

    public void ajouterLigne(Ligne l) {
        lignes.add(l);
    }

    public ArrayList<Ligne> getLignes() {
        return this.lignes;
    }

    public Ligne getLigne(int i) {
        return (Ligne) lignes.get(i);
    }

    public int getNbLignes() {
        return lignes.size();
    }
    
        public LinkedList<NoeudReseau> getMetro() {
        return metro;
    }
    
    public NoeudReseau getMetro(int i){
        return this.metro.get(i);
    }

    public void setMetro(LinkedList<NoeudReseau> metro) {
        this.metro = metro;
    }

    public HashMap<String, Station> getStation() {
        return station;
    }
    
    public Station getStation(String i){
        return this.station.get(i);
    }

    public void setStation(HashMap<String, Station> station) {
        this.station = station;
    }
    
    
}
