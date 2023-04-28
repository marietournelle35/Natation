import java.util.Objects;
import java.util.Scanner;

public class Competition {
    public static void main(String[] args) {
        Nageur[] nageur = {
                new Nageur("Bousquet", 1),
                new Nageur("Le veau", 2),
                new Nageur("Dubosc", 3)
        };

        Course course = new Course(nageur, 25, 2);

        course.afficher();

        Scanner scan = new Scanner(System.in);
        while (scan.nextLine().isEmpty()) {
            for (Nageur n : nageur) {
                n.setEmplacement();
            }
            course.afficher();
        }
    }
}
