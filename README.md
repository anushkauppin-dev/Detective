# Detective
# The Missing Exam Paper: A Detective Investigation System

## 📌 Project Overview

**The Missing Exam Paper: A Detective Investigation System** is a console-based Java application developed as a team-based coding activity.

The project simulates an investigation in which an important examination question paper has disappeared from the department office one day before the examination. The detective can view suspects, investigate suspects, collect clues, view collected clues, and accuse a suspect.

The application demonstrates basic Java programming concepts including classes, objects, constructors, methods, arrays, control statements, and basic Git/GitHub collaboration.

---

## 🎯 Objective

The objective of this project is to develop a small Java-based Detective Investigation System while gaining hands-on experience with:

* Classes and objects
* Constructors
* Methods
* Arrays
* Control statements
* Array of objects
* Basic Git/GitHub collaboration

The application is divided into four Java files, with each team member responsible for one part of the system.

---

## 🔍 Problem Statement

An important examination question paper has disappeared from the department office one day before the examination.

Five students were present in the department during the incident. The team must develop a Detective Investigation System to investigate the suspects, examine clues, and identify the culprit.

The system allows the detective to:

1. View suspects
2. Investigate a particular suspect
3. Collect clues
4. View collected clues
5. Accuse a suspect
6. Determine whether the accusation is correct
7. Exit the investigation

The program uses predefined data and choices. User input using `Scanner` is not required.

---

## 👥 Suspects

The investigation contains five suspects:

| ID | Suspect | Location          | Alibi                    |
| -- | ------- | ----------------- | ------------------------ |
| 1  | Alex    | Computer Lab      | Working on a project     |
| 2  | Maya    | Library           | Studying                 |
| 3  | Rahul   | Staff Room        | Meeting a faculty member |
| 4  | Sara    | Canteen           | Having lunch             |
| 5  | Arjun   | Department Office | Collecting documents     |

The actual culprit is not directly displayed to the detective at the beginning of the investigation.

---

## 🕵️ Available Clues

The investigation contains five clues:

1. The office door was opened at 2:15 PM.
2. CCTV shows someone entering the office.
3. A torn piece of paper was found near the printer.
4. A suspect's ID card was found inside the office.
5. The printer was used shortly before the question paper disappeared.

The clues are stored using an array, and the program keeps track of which clues have been collected.

---

## 📂 Project Structure

```text
detective-investigation/
│
├── Suspect.java
├── ClueManager.java
├── Investigation.java
├── DetectiveGame.java
└── README.md
```

All four Java files work together as one complete application.

---

## 🧩 Team Responsibilities

### Student 1 — Suspect Management

**File:** `Suspect.java`

Responsibilities:

* Create the `Suspect` class
* Store suspect ID, name, location, and alibi
* Create a constructor
* Use the `this` keyword
* Create five `Suspect` objects
* Store the objects in an array
* Display individual suspect details
* Display all suspects

### Student 2 — Clue Management

**File:** `ClueManager.java`

Responsibilities:

* Create an array containing the five clues
* Track collected clues
* Display available clues
* Collect a clue using a predefined clue number
* Display collected clues
* Prevent the same clue from being collected more than once

### Student 3 — Investigation and Accusation

**File:** `Investigation.java`

Responsibilities:

* Search for a suspect using the suspect ID
* Display selected suspect details
* Implement accusation logic
* Compare the accused suspect with the actual culprit
* Allow a maximum of three accusation attempts
* Display appropriate success or failure messages
* Use suitable `if-else`, loops, `break`, and `return` statements

### Student 4 — Main Program and Integration

**File:** `DetectiveGame.java`

Responsibilities:

* Create the `main()` method
* Create required objects
* Display the investigation menu
* Use a `switch` statement
* Repeat the investigation using a loop
* Call methods from the other three classes
* Integrate all components
* Compile and test the complete application

---

## 📋 Main Investigation Menu

The completed application provides a menu similar to:

```text
=================================
     DETECTIVE INVESTIGATION
=================================
1. View Suspects
2. Investigate Suspect
3. Collect Clue
4. View Collected Clues
5. Accuse Suspect
6. Exit
```

The selected operation is repeatedly performed until the investigation is completed or the detective chooses to exit.

---

## ⚙️ Program Requirements

### Option 1 — View Suspects

Displays the details of all five suspects.

### Option 2 — Investigate Suspect

Uses a predefined suspect ID to identify and display a particular suspect.

If the ID does not match any suspect, an appropriate message is displayed.

### Option 3 — Collect Clue

Allows the detective to select a clue using a predefined clue number.

A collected clue is marked as collected and cannot be collected again.

### Option 4 — View Collected Clues

Displays all clues collected so far.

If no clues have been collected, an appropriate message is displayed.

### Option 5 — Accuse Suspect

Allows the detective to accuse a suspect using a predefined suspect ID.

A maximum of three accusation attempts is allowed.

If the correct suspect is identified:

```text
CASE SOLVED!
You identified the culprit.
The missing question paper has been recovered.
```

If all three attempts are incorrect:

```text
INVESTIGATION FAILED!
You have used all three attempts.
The culprit escaped.
```

### Option 6 — Exit

Terminates the investigation.

---

## 🧠 Java Concepts Used

The project demonstrates the following Java concepts:

* Classes
* Objects
* Reference variables
* Constructors
* `this` keyword
* Methods
* Arrays
* Array of objects
* `if-else` statements
* `switch` statement
* `for` loop
* `for-each` loop
* `while` or `do-while` loop
* `break` statement
* `continue` statement
* `return` statement
* Primitive data types
* Strings

`Scanner` and user-input handling are not required because they have not yet been covered in the class. The program therefore uses predefined values.

---

## 💻 GitHub Codespaces

The team works using GitHub Codespaces.

Each student primarily works on their assigned Java file:

```text
Student 1 → Suspect.java
Student 2 → ClueManager.java
Student 3 → Investigation.java
Student 4 → DetectiveGame.java
```

Students should communicate with their team members before making changes that affect another student's file.

---

## 🔄 Git Workflow

The suggested workflow is:

```text
Write Code
    ↓
Test Code
    ↓
Commit Changes
    ↓
Push to GitHub
    ↓
Integrate with Team
    ↓
Test Complete Program
```

Useful Git commands:

```bash
git status
git add .
git commit -m "Add suspect management"
git push
```

Each student must make at least one meaningful commit.

---

## 👥 Team Rules

1. Each student is responsible for their assigned Java file.
2. Every student must contribute code to the project.
3. Every student must make at least one meaningful Git commit.
4. Do not overwrite or delete another student's work without discussing it with the team.
5. Do not change agreed class names, method names, or parameters without informing the team.
6. Students should communicate while integrating the files.
7. All four students must understand and explain their own contribution.
8. The final program must compile successfully as one Java application.
9. The team must test the complete program before submission.

---

## 🚀 Team Workflow

The recommended development process is:

1. **Understand the Problem** — All team members read and understand the problem.
2. **Divide the Work** — Each student works on their assigned Java file.
3. **Develop Individual Components** — Write and test individual classes and methods.
4. **Commit the Work** — Each student commits their completed work to GitHub.
5. **Integrate** — Bring all four components together.
6. **Compile and Test** — Test the complete application and resolve integration errors.
7. **Demonstrate** — Demonstrate the complete Detective Investigation System.

---

## 📦 Final Deliverables

The team must submit:

1. One GitHub repository
2. `Suspect.java`
3. `ClueManager.java`
4. `Investigation.java`
5. `DetectiveGame.java`
6. `README.md`

The four Java files must work together as one complete Detective Investigation System and the program should compile and execute successfully.

---

## 🎤 Team Demonstration

During the demonstration, each student should be able to explain:

* The part of the program they developed
* The classes and methods they created
* The Java concepts used
* How their file interacts with the other files
* The Git commit they made
* How the complete application works

---

## 🎓 Learning Outcomes

By completing this project, students will be able to:

* Apply Java programming concepts to a practical problem
* Design classes and objects
* Use arrays and methods to organize a program
* Apply control statements to implement program logic
* Divide a larger problem into smaller modules
* Work collaboratively on a common programming project
* Use GitHub and Codespaces for basic collaborative development
* Integrate independently developed Java files into a single application
* Test and debug a complete Java program
