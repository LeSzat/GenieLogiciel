/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package genielogiciel;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Metro {

    public ArrayList<Ligne> lignes;

    public Metro() {
        lignes = new ArrayList<>();
        importerStations();

    }

    private void importerStations() {
        String chaine = "";
        File f = new File("monficiher");
        try {
            f.createNewFile();
        } catch (Exception e) {
        }
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
                        Station s = new Station(tokens[1]);
                        lignes.get(i).ajouterStation(s);
                    }

                }
            }
        } catch (Exception e) {
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
