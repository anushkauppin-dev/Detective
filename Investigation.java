public class Investigation {

    private Suspect[] suspects;

    private int accusationAttempts = 0;

    // Maximum number of attempts
    private final int MAX_ATTEMPTS = 3;

    // Actual culprit
    private final int actualCulprit = 5;

    // Constructor
    public Investigation(Suspect[] suspects) {
        this.suspects = suspects;
    }

    // Investigate a suspect
    public void investigateSuspect(int id) {

        for (Suspect suspect : suspects) {

            if (suspect.suspectId == id) {

                System.out.println("Suspect Found!");
                System.out.println("----------------");

                suspect.displaySuspect();

                return;
            }
        }

        System.out.println("Suspect not found.");
    }

    // Accuse a suspect
    public boolean accuseSuspect(int id) {

        // Check whether all attempts are already used
        if (accusationAttempts >= MAX_ATTEMPTS) {

            System.out.println("INVESTIGATION FAILED!");
            System.out.println("You have used all three attempts.");

            return true;
        }

        accusationAttempts++;

        // Check accusation
        if (id == actualCulprit) {

            System.out.println("CASE SOLVED!");
            System.out.println("You identified the culprit.");
            System.out.println("The missing question paper has been recovered.");

            return true;
        }

        // Wrong accusation
        System.out.println("Incorrect accusation.");

        // Check if this was the third attempt
        if (accusationAttempts == MAX_ATTEMPTS) {

            System.out.println("INVESTIGATION FAILED!");
            System.out.println("You have used all three attempts.");
            System.out.println("The culprit escaped.");

            return true;
        }

        System.out.println(
            "You have " + (MAX_ATTEMPTS - accusationAttempts)
            + " attempt(s) remaining."
        );

        return false;
    }
}
