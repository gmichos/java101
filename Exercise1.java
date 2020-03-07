import java.util.Random;
import java.util.Scanner;

public class Exercise1 {

    static int min = 1;
    static int max = 100;
    static boolean win = false;
    static int tries;
    static String userResponse;

    /**
     * @param args the command line arguments
     */
    public static void main(final String[] args) {
        boolean PlayAgain = true;
        final Random random = new Random();
        try (Scanner scan = new Scanner(System.in)) {
            while (PlayAgain) {
                win = false;
                int number = random.nextInt(100) + 1;
                tries = 0;
                System.out.println("Debug -> Ο αριθμός είναι o: " + number + "!");
                do {
                    System.out.print("Δώσε έναν αριθμό μεταξύ " + min + " και " + max + " :");
                    String next = scan.next();
                    int guess = Integer.parseInt(next); 
                    if (tries < 9) {
                        if (guess < number) {
                            System.out.println(guess + " είναι χαμηλό. Ξαναπροσπάθησε!");
                            min = guess;
                            tries++;
                        } else if (guess > number) {
                            System.out.println(guess + " είναι υψηλό. Ξαναπροσπάθησε!");
                            max = guess;
                            tries++;
                        } else {
                            System.out.println("Συγχαρητήρια! Βρήκες τον αριθμό μετά από " + tries
                                    + " προσπάθειες! Σκορ: " + (10 - tries) + "!");
                            win = true;
                        }
                    } else {
                        if (guess == number) {
                            //Αν το βρεις με τη 10η φορά έχεις 9 αποτυχημένες, άρα το σκορ είναι 1.
                            System.out.println("Συγχαρητήρια! Βρήκες τον αριθμό μετά από " + tries
                                    + " προσπάθειες! Σκορ: " + (10 - tries) + "!");
                            win = true;
                        } else {
                            //Αν δεν το βρεις με τη 10η φορά έχεις 10 (++tries) αποτυχημένες, άρα το σκορ είναι 0.
                            System.out.println("Κρίμα! Δεν κατάφερες να βρεις τον αριθμό μετά από " + ++tries
                                    + " προσπάθειες! Σκορ: " + (10 - tries) + "!");
                        }
                    }
                    do{
                        System.out.println("Θα ήθελες να ξαναπαίξεις (y/n)?");
                        String userResponse = scan.next();
                        if (userResponse.compareToIgnoreCase("y") == 0) {
                            PlayAgain = true;
                            break;
                        } else if (userResponse.compareToIgnoreCase("n") == 0){
                            PlayAgain = false;
                            System.out.print("Ευχαριστούμε! Καλή συνέχεια.");
                            break;
                        } else {
                            System.out.println("Παρακαλώ διάλεξε ανάμεσα σε (y/n)!");
                            continue;
                        }
                    }while(true);
                } while (!win);

            }
        } catch (NumberFormatException exp) {
        }
    }
}