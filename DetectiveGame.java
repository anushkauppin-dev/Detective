import java.util.Scanner;

public class DetectiveGame {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Get suspects from Suspect class
        Suspect[] suspects = Suspect.suspects;

        // Create objects
        ClueManager clueManager = new ClueManager();

        Investigation investigation =
                new Investigation(suspects);

        boolean investigationOpen = true;

        System.out.println("=================================");
        System.out.println("   THE MISSING EXAM PAPER");
        System.out.println("=================================");
        System.out.println();

        System.out.println(
            "A question paper is missing from the department office."
        );

        System.out.println(
            "Investigate the suspects, collect the clues, "
            + "and name the culprit."
        );

        System.out.println("You have 3 accusation attempts.");
        System.out.println();

        // Main menu loop
        do {

            displayMenu();

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            System.out.println();

            switch (choice) {

                case 1:

                    // View all suspects
                    Suspect.displayAllSuspects();

                    break;

                case 2:

                    // Investigate a suspect
                    System.out.print(
                        "Enter suspect ID to investigate: "
                    );

                    int investigateId = scanner.nextInt();

                    System.out.println();

                    investigation.investigateSuspect(
                        investigateId
                    );

                    break;

                case 3:

                    // View available clues
                    clueManager.displayAvailableClues();

                    System.out.print(
                        "Enter clue number to collect: "
                    );

                    int clueNumber = scanner.nextInt();

                    System.out.println();

                    clueManager.collectClue(clueNumber);

                    break;

                case 4:

                    // View collected clues
                    clueManager.displayCollectedClues();

                    break;

                case 5:

                    // Accuse suspect
                    System.out.print(
                        "Enter suspect ID to accuse: "
                    );

                    int accuseId = scanner.nextInt();

                    System.out.println();

                    if (investigation.accuseSuspect(accuseId)) {

                        investigationOpen = false;
                    }

                    break;

                case 6:

                    // Exit
                    System.out.println(
                        "Investigation terminated."
                    );

                    investigationOpen = false;

                    break;

                default:

                    System.out.println(
                        "Invalid option. "
                        + "Choose a number from 1 to 6."
                    );
            }

            System.out.println();

        } while (investigationOpen);

        scanner.close();
    }

    // Display menu
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
