public class ClueManager {

    String[] clues = {
        "Clue 1: A staff member saw someone near the department office.",
        "Clue 2: A torn piece of paper was found near the office.",
        "Clue 3: Security records show someone entered the office.",
        "Clue 4: A witness noticed a suspicious person carrying documents.",
        "Clue 5: The missing question paper was last seen in the department office."
    };

    boolean[] collected = new boolean[5];

    // Display available clues
    public void displayAvailableClues() {

        System.out.println("Available Clues:");

        for (int i = 0; i < clues.length; i++) {

            if (!collected[i]) {
                System.out.println((i + 1) + ". " + clues[i]);
            }
        }
    }

    // Collect a clue
    public void collectClue(int clueNumber) {

        if (clueNumber < 1 || clueNumber > clues.length) {

            System.out.println("Invalid clue number.");
            return;
        }

        int index = clueNumber - 1;

        if (collected[index]) {

            System.out.println("You have already collected this clue.");
            return;
        }

        collected[index] = true;

        System.out.println("Clue collected successfully!");
        System.out.println(clues[index]);
    }

    // Display collected clues
    public void displayCollectedClues() {

        System.out.println("Collected Clues:");

        boolean found = false;

        for (int i = 0; i < clues.length; i++) {

            if (collected[i]) {

                System.out.println((i + 1) + ". " + clues[i]);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No clues collected yet.");
        }
    }
}
