import java.util.Random;
import java.util.Scanner;

public class Exercise1 {

    static int min;
    static int max;
    static boolean win;
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
                tries = 0;
                min = 1;
                max = 100;
                int number = random.nextInt(100) + 1;
                //System.out.println("Debug -> Ο αριθμός είναι τo: " + number + "!");
                do {
                    System.out.print("Δώσε έναν αριθμό μεταξύ " + min + " και " + max + " :");
                    String next = scan.next();
                    int guess = Integer.parseInt(next);
                    if (tries < 9) {
                        if (guess >= min && guess <= max && guess < number) {
                            System.out.println(guess + " είναι χαμηλό. Ξαναπροσπάθησε!");
                            min = guess;
                            tries++;
                        } else if (guess >= min && guess <= max && guess > number) {
                            System.out.println(guess + " είναι υψηλό. Ξαναπροσπάθησε!");
                            max = guess;
                            tries++;
                        } else if (guess == number){
                            System.out.println("Συγχαρητήρια! Βρήκες τον αριθμό μετά από " + tries
                                    + " προσπάθειες! Σκορ: " + (10 - tries) + "!");
                            win = true;
                        } else {
                            System.out.println("Ο αριθμός που έδωσες είναι εκτός των ορίων " + min + " και " + max);
                            System.out.println("Παρακαλώ δώσε έναν έγκυρό αριθμό, αυτή η προσπάθεια δεν θα προσμετρηθεί");
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
                            System.out.println("Ο αριθμός που εψαχνες ήταν o: " + number + "!");
                            break;
                        }
                    }
                } while (!win);
                do{
                    System.out.println("Θα ήθελες να ξαναπαίξεις (y/n)?");
                    String userResponse = scan.next();
                    if (userResponse.compareToIgnoreCase("y") == 0) {
                        //Αν η Απάντηση είναι y ή Υ θα ξανα αρχίσει το παιχνίδι
                        PlayAgain = true;
                        break;
                    } else if (userResponse.compareToIgnoreCase("n") == 0){
                        //Αν η Απάντηση είναι n ή N θα βγει έξω από το Iteration της εκτέλεσης
                        PlayAgain = false;
                        System.out.print("Ευχαριστούμε! Καλή συνέχεια.");
                        break;
                    } else {
                        // Αν η Απάντηση δεν είναι y/Y ή n/N θα εμφανίσει το παρακάω μήνυμα.
                        System.out.println("Παρακαλώ διάλεξε ανάμεσα σε (y/n)!");
                        continue;
                    }
                }while(true);
            }
        } catch (NumberFormatException e) {
        }
    }
}