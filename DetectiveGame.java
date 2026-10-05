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
