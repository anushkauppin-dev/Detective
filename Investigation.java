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
