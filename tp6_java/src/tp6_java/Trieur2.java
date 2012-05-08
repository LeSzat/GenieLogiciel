/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp6_java;
/**
 * Tri d'un tableau d'entiers multi-thread.
 * Version qui utilise join().
 */
public class Trieur2 extends Thread {

  private int[] t; // tableau � trier
  private int debut, fin; // tranche de ce tableau qu'il faut trier

  public Trieur2(int[] t) {
    this(t, 0, t.length - 1);
  }
  
  private Trieur2(int[] t, int debut, int fin) {
    this.t = t;
    this.debut = debut;
    this.fin = fin;
    // start();
    // Pas de start() pour permettre d'effectuer des traitements
    // sur le Trieur avant le lancement (plus souple pour les sous-classes
    // �ventuelles)
  }

  public void run() {
    if (fin - debut < 2) {
      if (t[debut] > t[fin]) {
        echanger(debut, fin);
      }
    }
    else {
      int milieu = debut + (fin - debut) / 2;
      Trieur2 trieur1 = new Trieur2(t, debut, milieu);
      trieur1.start();
      Trieur2 trieur2 = new Trieur2(t, milieu + 1, fin);
      trieur2.start();
      try {
        trieur1.join();
        trieur2.join();
      }
      catch(InterruptedException e) {}
      triFusion(debut, fin);
    }
  }

  /**
   * Echanger t[i] et t[j]
   */
  private void echanger(int i, int j) {
    int valeur = t[i];
    t[i] = t[j];
    t[j] = valeur;
  }

  /**
   * Fusionne 2 tranches d�j� tri�es du tableau t.
   *   - 1�re tranche : de debut � milieu
   *   - 2�me tranche : de milieu + 1 � fin
   * @param milieu indique le dernier indice de la 1�re tranche
   */
  private void triFusion(int debut, int fin) {
    // tableau o� va aller la fusion
    int[] tFusion = new int[fin - debut + 1];
    int milieu = (debut + fin) / 2;
    // Indices des �l�ments � comparer
    int i1 = debut, 
        i2 = milieu + 1;
    // indice de la prochaine case du tableau tFusion � remplir
    int iFusion = 0;
    while (i1 <= milieu && i2 <= fin) {
      if (t[i1] < t[i2]) {
        tFusion[iFusion++] = t[i1++];
      }
      else {
        tFusion[iFusion++] = t[i2++]; 
      }
    }
    if (i1 > milieu) {
      // la 1�re tranche est �puis�e
      for (int i = i2; i <= fin; ) {
        tFusion[iFusion++] = t[i++];
      }
    }
    else {
      // la 2�me tranche est �puis�e
      for (int i = i1; i <= milieu; ) {
        tFusion[iFusion++] = t[i++];
      }
    }
    // Copie tFusion dans t
    for (int i = 0, j = debut; i <= fin - debut; ) {
      t[j++] = tFusion[i++];
    }
  }
  public static void main(String[] args) {
    int[] t = {5, 8, 3, 2, 7, 10, 1};
    Trieur trieur = new Trieur(t);
    trieur.start();
    try {
      trieur.join();
    }
    catch(InterruptedException e) {}
    for (int i = 0; i <t.length; i++) {
      System.out.print(t[i] + " ; ");
    }
    System.out.println();
  }

}
