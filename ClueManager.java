public class ClueManager {

    static String[] clues = {
        "The office door was opened at 2:15 PM.",
        "CCTV shows someone entering the office.",
        "A torn piece of paper was found near the printer.",
        "A suspect's ID card was found inside the office.",
        "The printer was used shortly before the question paper disappeared."
    };

    static boolean[] found = new boolean[clues.length];

    public static void displayClues() {
        System.out.println("Available Clues:");
        for (int i = 0; i < clues.length; i++) {
            System.out.println((i + 1) + ". " + clues[i]);
        }
    }

    public static boolean collectClue(int clueNumber) {
        if (clueNumber < 1 || clueNumber > clues.length) {
            System.out.println("Clue " + clueNumber + " does not exist.");
            return false;
        }
        int index = clueNumber - 1;
        if (found[index]) {
            System.out.println("Clue " + clueNumber + " is already collected.");
            return false;
        }
        found[index] = true;
        System.out.println("Clue collected: " + clues[index]);
        return true;
    }

    public static int countCollected() {
        int count = 0;
        for (boolean status : found) {
            if (status) {
                count++;
            }
        }
        return count;
    }

    public static void displayCollectedClues() {
        if (countCollected() == 0) {
            System.out.println("No clues collected yet.");
            return;
        }
        System.out.println("Collected Clues:");
        int number = 1;
        for (int i = 0; i < clues.length; i++) {
            if (!found[i]) {
                continue;
            }
            System.out.println(number + ". " + clues[i]);
            number++;
        }
    }
}
