import java.util.Scanner;

public class DetectiveGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Suspect[] suspects = Suspect.createSuspectList();
        ClueManager clueManager = new ClueManager();
        Investigation investigation = new Investigation(suspects);
        boolean investigationOpen = true;

        System.out.println("A question paper is missing from the department office.");
        System.out.println("Investigate the suspects, collect the clues, and name the culprit.");
        System.out.println("You have 3 accusation attempts.");
        System.out.println();

        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            System.out.println();

            switch (choice) {
                case 1:
                    Suspect.displayAllSuspects(suspects);
                    break;
                case 2:
                    System.out.print("Enter suspect ID to investigate: ");
                    int investigateId = scanner.nextInt();
                    System.out.println();
                    investigation.investigateSuspect(investigateId);
                    break;
                case 3:
                    clueManager.displayAvailableClues();
                    System.out.print("Enter clue number to collect: ");
                    int clueNumber = scanner.nextInt();
                    System.out.println();
                    clueManager.collectClue(clueNumber);
                    break;
                case 4:
                    clueManager.displayCollectedClues();
                    break;
                case 5:
                    System.out.print("Enter suspect ID to accuse: ");
                    int accuseId = scanner.nextInt();
                    System.out.println();
                    if (investigation.accuseSuspect(accuseId)) {
                        investigationOpen = false;
                    }
                    break;
                case 6:
                    System.out.println("Investigation terminated.");
                    investigationOpen = false;
                    break;
                default:
                    System.out.println("Invalid option. Choose a number from 1 to 6.");
                    continue;
            }

            System.out.println();
        } while (investigationOpen);

        scanner.close();
    }

    public static void displayMenu() {
        System.out.println("=================================");
        System.out.println("     DETECTIVE INVESTIGATION");
        System.out.println("=================================");
        System.out.println("1. View Suspects");
        System.out.println("2. Investigate Suspect");
        System.out.println("3. Collect Clue");
        System.out.println("4. View Collected Clues");
        System.out.println("5. Accuse Suspect");
        System.out.println("6. Exit");
        System.out.println("=================================");
    }
}

class Suspect {
    private int suspectId;
    private String name;
    private String location;
    private String alibi;

    public Suspect(int suspectId, String name, String location, String alibi) {
        this.suspectId = suspectId;
        this.name = name;
        this.location = location;
        this.alibi = alibi;
    }

    public int getSuspectId() {
        return suspectId;
    }

    public String getName() {
        return name;
    }

    public void displayDetails() {
        System.out.println("ID       : " + suspectId);
        System.out.println("Name     : " + name);
        System.out.println("Location : " + location);
        System.out.println("Alibi    : " + alibi);
        System.out.println("-----------------------------");
    }

    public static Suspect[] createSuspectList() {
        Suspect[] suspects = new Suspect[5];

        suspects[0] = new Suspect(1, "Alex", "Computer Lab", "Working on a project");
        suspects[1] = new Suspect(2, "Maya", "Library", "Studying");
        suspects[2] = new Suspect(3, "Rahul", "Staff Room", "Meeting a faculty member");
        suspects[3] = new Suspect(4, "Sara", "Canteen", "Having lunch");
        suspects[4] = new Suspect(5, "Arjun", "Department Office", "Collecting documents");

        return suspects;
    }

    public static void displayAllSuspects(Suspect[] suspects) {
        System.out.println("----- SUSPECT LIST -----");
        for (Suspect suspect : suspects) {
            suspect.displayDetails();
        }
    }
}

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

class Investigation {
    private Suspect[] suspects;
    private int culpritId;
    private int attemptsUsed;

    public Investigation(Suspect[] suspects) {
        this.suspects = suspects;
        this.culpritId = 5;
        this.attemptsUsed = 0;
    }

    public Suspect searchById(int suspectId) {
        Suspect found = null;

        for (int i = 0; i < suspects.length; i++) {
            if (suspects[i].getSuspectId() == suspectId) {
                found = suspects[i];
                break;
            }
        }

        return found;
    }

    public void investigateSuspect(int suspectId) {
        Suspect suspect = searchById(suspectId);

        if (suspect == null) {
            System.out.println("No suspect found with ID " + suspectId + ".");
            return;
        }

        System.out.println("----- INVESTIGATION REPORT -----");
        suspect.displayDetails();
    }

    public boolean accuseSuspect(int suspectId) {
        if (attemptsUsed >= 3) {
            System.out.println("INVESTIGATION FAILED!");
            System.out.println("You have used all three attempts.");
            System.out.println("The culprit escaped.");
            return true;
        }

        Suspect accused = searchById(suspectId);
        if (accused == null) {
            System.out.println("No suspect found with ID " + suspectId + ".");
            System.out.println("This accusation was not counted.");
            return false;
        }

        if (accused.getSuspectId() == culpritId) {
            System.out.println("CASE SOLVED!");
            System.out.println("You identified the culprit.");
            System.out.println("The missing question paper has been recovered.");
            System.out.println("Culprit: " + accused.getName());
            return true;
        }

        attemptsUsed++;
        System.out.println(accused.getName() + " is not the culprit.");
        System.out.println("Attempts used: " + attemptsUsed + " of 3.");

        if (attemptsUsed == 3) {
            System.out.println("INVESTIGATION FAILED!");
            System.out.println("You have used all three attempts.");
            System.out.println("The culprit escaped.");
            return true;
        }

        return false;
    }
}
