import java.util.Random;
import java.util.Scanner;

public class Exercise1 {

    /**
     * @param args the command line arguments
     */
    // System.out.println("Hello and welcome to my number guessing game.");
    static int min = 1;
    static int max = 100;
    static boolean win = false;
    static int tries;
    // static String userResponse = "y";

    public static void main(final String[] args) {
        boolean PlayAgain = false;
        while (!PlayAgain) {

            final Random random = new Random();
            try (Scanner scan = new Scanner(System.in)) {
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
                            System.out.println("Συγχαρητήρια! Βρήκες τον αριθμό μετά από " + tries
                                    + " προσπάθειες! Σκορ: " + (10 - tries) + "!");
                            win = true;
                        } else {
                            System.out.println("Κρίμα! Δεν κατάφερες να βρεις τον αριθμό μετά από " + ++tries
                                    + " προσπάθειες! Σκορ: " + (10 - tries) + "!");
                        }
                    }
                } while (!win);

            } catch (NumberFormatException exp) {
            }
            System.out.print("Θα ήθελες να ξαναπαίξεις (ν/ο)?");
        }
    }
}