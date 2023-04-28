public class Course {
    private int nbParticipant;
    private int nbTrajet;
    private Piscine piscine;


    public Course(Nageur[] nageurs, int taillePiscine, int nbTrajet) {
        this.nbParticipant = nageurs.length;
        this.nbTrajet = nbTrajet;
        this.piscine = new Piscine(taillePiscine, nbParticipant, nageurs, this);
    }

    public int getNbTrajet() {
        return nbTrajet;
    }

    public void afficher () {
        piscine.afficher();
    }
}
