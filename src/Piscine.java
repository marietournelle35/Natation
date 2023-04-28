public class Piscine {
    private int longueur;
    private Nageur[] nageurs;
    private int nbNageurs;
    private int trajets;
    private Course course;
    String[] podium = new String[3];
    int couloir = 0;

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


        for (Nageur n : nageurs) {
            if (n.getNom().length() > tailleNomMax) {
                tailleNomMax = n.getNom().length() + 1;
            }
        }

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
                    podium[i] = nageurs[i].getNom();
                    if(podium[i].equals(nageurs[i].getNom())) {
                        couloir = nageurs[i].getCouloir();
                    }
                }
            }
            System.out.printf("%s╚%s╝\n", bords(tailleNomMax, " "), bords(longueur + 2, "═"));

    }

    public String bords(int taille, String caractere) {
        return String.valueOf(caractere).repeat(Math.max(0, taille));
    }

    public void resultat() {
        System.out.println("1 " + podium[0] + " couloir n°" + couloir);
        System.out.println("2 " + podium[1] + " couloir n°" + couloir);
        System.out.println("3 " + podium[2] + " couloir n°" + couloir);
    }
}
