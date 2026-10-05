class ClueManager {
    private String[] clues;
    private boolean[] collected;

    public ClueManager() {
        clues = new String[5];
        clues[0] = "The office door was opened at 2:15 PM.";
        clues[1] = "CCTV shows someone entering the office.";
        clues[2] = "A torn piece of paper was found near the printer.";
        clues[3] = "A suspect's ID card was found inside the office.";
        clues[4] = "The printer was used shortly before the question paper disappeared.";

        collected = new boolean[clues.length];
    }

    public void displayAvailableClues() {
        System.out.println("----- AVAILABLE CLUES -----");
        for (int i = 0; i < clues.length; i++) {
            String status = collected[i] ? "Collected" : "Not collected";
            System.out.println((i + 1) + ". " + clues[i] + " [" + status + "]");
        }
    }

    public void collectClue(int clueNumber) {
        if (clueNumber < 1 || clueNumber > clues.length) {
            System.out.println("Invalid clue number. Choose a number from 1 to " + clues.length + ".");
            return;
        }

        int index = clueNumber - 1;
        if (collected[index]) {
            System.out.println("Clue " + clueNumber + " has already been collected.");
            System.out.println("A clue cannot be collected more than once.");
            return;
        }

        collected[index] = true;
        System.out.println("Clue collected: " + clues[index]);
    }

    public void displayCollectedClues() {
        System.out.println("----- COLLECTED CLUES -----");
        boolean anyCollected = false;

        for (int i = 0; i < clues.length; i++) {
            if (!collected[i]) {
                continue;
            }
            System.out.println((i + 1) + ". " + clues[i]);
            anyCollected = true;
        }

        if (!anyCollected) {
            System.out.println("No clues have been collected yet.");
        }
    }
}
