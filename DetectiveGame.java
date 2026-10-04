import java.util.Scanner;

public class DetectiveGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Create Investigation object
        Investigation investigation = new Investigation();

        int choice;

        // Main menu loop
        while (!investigation.isInvestigationOver()) {

            System.out.println("\n================================");
            System.out.println("     DETECTIVE INVESTIGATION");
            System.out.println("================================");

            System.out.println("1. View Suspects");
            System.out.println("2. Investigate Suspect");
            System.out.println("3. Collect Clue");
            System.out.println("4. View Collected Clues");
            System.out.println("5. Accuse Suspect");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    // Display all suspects
                    Suspect.displayAllSuspects();
                    break;

                case 2:

                    System.out.print("Enter Suspect ID: ");

                    int id = sc.nextInt();

                    // Investigate selected suspect
                    investigation.investigateSuspect(Suspect.suspects, id);
                    break;

                case 3:

                    // Display available clues
                    ClueManager.displayClues();

                    System.out.print("Enter clue number to collect: ");

                    int clueNumber = sc.nextInt();

                    // Collect selected clue
                    ClueManager.collectClue(clueNumber);
                    break;

                case 4:

                    // Display collected clues
                    ClueManager.displayCollectedClues();
                    break;

                case 5:

                    // Accuse a suspect
                    investigation.accuseSuspect(sc, Suspect.suspects);
                    break;

                case 6:

                    System.out.println("Exiting Detective Investigation...");
                    sc.close();
                    return;

                default:

                    System.out.println("Invalid choice! Try again.");
            }
        }

        // Display final result
        if (investigation.isCaseSolved()) {

            System.out.println("\nThank you, Detective!");
            System.out.println("You successfully completed the investigation.");

        } else {

            System.out.println("\nGame Over!");
            System.out.println("Better luck next time, Detective.");
        }

        sc.close();
    }
}
