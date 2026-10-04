import java.util.Scanner;

public class Investigation {

    private int attempts = 0;
    private boolean caseSolved = false;
    private boolean investigationOver = false;

    private int actualCulprit = 5;

    public void investigateSuspect(Suspect[] suspects, int id) {

        for (Suspect suspect : suspects) {

            if (suspect.suspectId == id) {
                suspect.displaySuspect();
                return;
            }
        }

        System.out.println("Suspect not found.");
    }

    public void accuseSuspect(Scanner sc, Suspect[] suspects) {

        if (investigationOver) {
            System.out.println("Investigation is already over.");
            return;
        }

        if (attempts >= 3) {
            System.out.println("You have used all three attempts.");
            investigationOver = true;
            return;
        }

        System.out.print("Enter suspect ID to accuse: ");
        int accusedId = sc.nextInt();

        attempts++;

        if (accusedId == actualCulprit) {

            caseSolved = true;
            investigationOver = true;

            System.out.println("\nCASE SOLVED!");
            System.out.println("You identified the culprit.");
            System.out.println("The missing question paper has been recovered.");

        } else {

            System.out.println("Incorrect accusation.");

            if (attempts < 3) {
                System.out.println(
                    "You have " + (3 - attempts) + " attempt(s) remaining."
                );
            } else {

                investigationOver = true;

                System.out.println("\nINVESTIGATION FAILED!");
                System.out.println("You have used all three attempts.");
                System.out.println("The culprit escaped.");
            }
        }
    }

    public boolean isCaseSolved() {
        return caseSolved;
    }

    public boolean isInvestigationOver() {
        return investigationOver;
    }
}
