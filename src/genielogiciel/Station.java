package genielogiciel;

/**
 * Modélise une station du métro
 */
public class Station implements java.lang.Comparable {

    private String nom;
    private Ligne ligne;
    private int position;
    private boolean handicape;
    private boolean ascenseur;
    private double abscisse;
    private double ordonnée;
    private boolean perturbation;
    private int tempsArret;

    /**
     * Constructeur d'une station de metro
     *
     * @param nom Nom de la station
     * @param x abscisse
     * @param y ordonnée
     */
    public Station(String nom, double x, double y) {
        this.nom = nom;
        this.abscisse = x;
        this.ordonnée = y;
        this.perturbation = false;
        this.ligne = new Ligne(0, "0");
        this.position = 0;

    }

    public double getAbscisse() {
        return this.abscisse;
    }

    public double getOrdonnée() {
        return this.ordonnée;
    }

    public boolean isAscenseur() {
        return ascenseur;
    }

    public void setAscenseur(boolean ascenseur) {
        this.ascenseur = ascenseur;
    }

    public boolean isPerturbation() {
        return perturbation;
    }

    public void setPerturbation(boolean perturbation) {
        this.perturbation = perturbation;
    }

    public boolean isHandicape() {
        return handicape;
    }

    public void setHandicape(boolean handicape) {
        this.handicape = handicape;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Ligne getLigne() {
        return ligne;
    }

    public void setLigne(Ligne ligne) {
        this.ligne = ligne;
    }

    public void setLigne(int ligne) {
        this.ligne = new Ligne(ligne, "" + ligne);
    }

    public int getPostionLigne() {
        return this.position;
    }

    public void setPositionLigne(int pos) {
        this.position = pos;
    }

//    public int compare(Station s,Station ss){
//        return(s.ligne.getNum() - ss.getLigne().getNum());
//    }
    @Override
    public int compareTo(Object s) {
        if (this.getAbscisse() == ((Station) s).getAbscisse() && this.getOrdonnée() == ((Station) s).getOrdonnée()) {
            return 0;
        }
        if (((this.getAbscisse() - ((Station) s).getAbscisse()) + (this.getOrdonnée() - ((Station) s).getOrdonnée())) > 0) {
            return 1;
        } else {
            return -1;
        }

    }

    public int getTempsArret() {
        return tempsArret;
    }

    public void setTempsArret(int tempsArret) {
        this.tempsArret = tempsArret;
    }

    /**
     * renvoie la distance entre 2 arrêts voisins
     */
    public double getDistance(Station s) {           //distance euclidienne
        return Math.sqrt((s.getAbscisse() - this.getAbscisse()) * (s.getAbscisse() - this.getAbscisse()) + (s.getOrdonnée() - this.getOrdonnée()) * (s.getOrdonnée() - this.getOrdonnée()));
    }

    @Override
    public String toString() {

        return (this.nom + " " + this.abscisse + " " + this.ordonnée + "\n" + " de la ligne" + this.ligne.getNom() + "\n" + " perturbations : " + this.perturbation + "\n" + "ascenseur: " + this.isAscenseur() + "\n" + "accès handicapés: " + this.handicape);

    }
}
