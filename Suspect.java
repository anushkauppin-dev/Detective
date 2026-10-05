public class Suspect {

    int suspectId;
    String name;
    String location;
    String alibi;

    // Constructor
    public Suspect(int suspectId, String name, String location, String alibi) {
        this.suspectId = suspectId;
        this.name = name;
        this.location = location;
        this.alibi = alibi;
    }

    // Array of suspects
    static Suspect[] suspects = {
        new Suspect(1, "Alex", "Computer Lab", "Working on a project"),
        new Suspect(2, "Maya", "Library", "Studying"),
        new Suspect(3, "Rahul", "Staff Room", "Meeting a faculty member"),
        new Suspect(4, "Sara", "Canteen", "Having lunch"),
        new Suspect(5, "Arjun", "Department Office", "Collecting documents")
    };

    // Display one suspect
    public void displaySuspect() {
        System.out.println("ID: " + suspectId);
        System.out.println("Name: " + name);
        System.out.println("Location: " + location);
        System.out.println("Alibi: " + alibi);
    }

    // Display all suspects
    public static void displayAllSuspects() {

        for (Suspect suspect : suspects) {
            suspect.displaySuspect();
            System.out.println();
        }
    }
}
