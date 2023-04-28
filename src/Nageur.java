import java.util.Random;

public class Nageur {
    private String nom;
    private int couloir;
    private int emplacement;

    public Nageur(String nom, int couloir) {
        this.nom            = nom;
        this.couloir        = couloir;
        this.emplacement    = 0;
    }

    public String getNom() {
        return nom;
    }

    public int getEmplacement() {
        return emplacement;
    }

    public int getCouloir(){
        return couloir;
    }

    public void setEmplacement() {
        Random rd = new Random();
        emplacement += rd.nextInt(4);
    }
}
