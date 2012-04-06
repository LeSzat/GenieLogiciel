/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package genielogiciel;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author User
 */
public class Metro {

    public ArrayList<Ligne> lignes;
    public HashMap<String,Station> station;

    public Metro() {
        lignes = new ArrayList<>();
        station = new HashMap<>();
        importerInfoStations();
        importerStations();
        
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
    private void importerInfoStations()
    {
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
                   this.station.put(tokens[0],new Station(tokens[0],Double.parseDouble(tokens[1]),Double.parseDouble(tokens[2])));
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
}
