import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Piscine {
    private int longueur;
    private Nageur[] nageurs;
    private int nbNageurs;
    private int trajets;
    private Course course;
    Nageur[] podium = new Nageur[3];

    public Piscine(int longueur, int nbNageurs, Nageur[] nageurs, Course course) {
        this.longueur = longueur;
        this.nbNageurs = nbNageurs;
        this.nageurs = nageurs;
        this.course = course;
    }

    public int getCourse() {
        return course.getNbTrajet();
    }

    public void afficher() {
        int tailleNomMax = 0;
        trajets = getCourse();
        int[] compteur = new int[3];

        for (Nageur n : nageurs) {
            if (n.getNom().length() > tailleNomMax) {
                tailleNomMax = n.getNom().length() + 1;
            }
        }
        if (compteur[2] < longueur * trajets) {
        System.out.printf("%s╔%s╗\n", bords(tailleNomMax, " "), bords(longueur + 2, "═"));
        for (int i = 0; i < nbNageurs; i++) {
            if (nageurs[i].getEmplacement() < longueur) {
                System.out.printf("%s%s ║%s=#o%s║ %d/%d\n",
                        bords((tailleNomMax - 1) - nageurs[i].getNom().length(), " "),
                        nageurs[i].getNom(),
                        bords(nageurs[i].getEmplacement(), " "),
                        bords(longueur - (nageurs[i].getEmplacement() + 1), " "),
                        nageurs[i].getEmplacement(), longueur * trajets);
            } else if (nageurs[i].getEmplacement() < longueur * trajets) {
                System.out.printf("%s%s ║%so#=%s║ %d/%d\n",
                        bords((tailleNomMax - 1) - nageurs[i].getNom().length(), " "),
                        nageurs[i].getNom(),
                        bords(longueur - (nageurs[i].getEmplacement() - longueur + 1), " "),
                        bords(nageurs[i].getEmplacement() - longueur, " "),
                        nageurs[i].getEmplacement(), longueur * trajets);
            }
            if (nageurs[i].getEmplacement() >= longueur * trajets) {
                podium[i] = nageurs[i];
                compteur[i] = podium[i].getEmplacement();
                System.out.printf("%s%s ║%so#=%s║ %d/%d\n",
                        bords((tailleNomMax - 1) - nageurs[i].getNom().length(), " "),
                        nageurs[i].getNom(),
                        bords(0, " "),
                        bords(longueur - 1, " "),
                        longueur * trajets, longueur * trajets);
            }
        }
        System.out.printf("%s╚%s╝\n", bords(tailleNomMax, " "), bords(longueur + 2, "═"));
        }

        if(compteur[2] >= longueur*trajets) {
            resultat();
        }
    }

    public String bords(int taille, String caractere) {
        return String.valueOf(caractere).repeat(Math.max(0, taille));
    }

    public void resultat() {
        for(int i = 0; i< podium.length; i++) {
            System.out.println((i+1) + " " + podium[i].getNom() + " couloir n°" + podium[i].getCouloir());
        }
    }
}
