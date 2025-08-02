import java.util.Scanner;

public class GradeMarks {
    private static int n; // # of students
    private static double[][] marks; // marks[studentID][subjectID]

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of students (n): ");
        n = sc.nextInt();
        marks = new double[n + 1][3 + 1]; // For bound length

        int choice;
        do { // do-while loop for choices
            displayMenu(); 
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // Get newline

            switch (choice) {
                case 1:
                    addStudentMarks(sc);
                    break;
                case 2:
                    getStudentAverage(sc);
                    break;
                case 3:
                    getSubjectAverage(sc);
                    break;
                case 4:
                    getTotalMarksOfStudent(sc);
                    break;
                case 5:
                    displayMarksTable();
                    break;
                case 6:
                    displayGradesTable(); // Display grades
                    break;
				case 7:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 7);

        sc.close();
    }

    private static void displayMenu() {
        System.out.println("\n--- Menu ---");
        System.out.println("1. Add student marks");
        System.out.println("2. Average mark of relevant student");
        System.out.println("3. Average mark for relevant subject");
        System.out.println("4. Total marks of a student");
		System.out.println("5. Display marks table");
		System.out.println("6. Display grades table"); // Grade display option
        System.out.println("7. Exit");
    }

    private static void addStudentMarks(Scanner sc) {
        System.out.print("Enter student ID (1 to " + n + "): ");
        int studentId = sc.nextInt();
        if (studentId < 1 || studentId > n) {
            System.out.println("Invalid student ID.");
            return;
        }

        System.out.print("Enter marks for Mathematics (Subject 1): ");
        marks[studentId][1] = sc.nextDouble();
        System.out.print("Enter marks for Chemistry (Subject 2): ");
        marks[studentId][2] = sc.nextDouble();
        System.out.print("Enter marks for Physics (Subject 3): ");
        marks[studentId][3] = sc.nextDouble();
        System.out.println("Marks added for student " + studentId + ".");
    }

    private static void getStudentAverage(Scanner sc) {
        System.out.print("Enter student ID (1 to " + n + "): ");
        int studentId = sc.nextInt();
        if (studentId < 1 || studentId > n) {
            System.out.println("Invalid student ID.");
            return;
        }

        double total = marks[studentId][1] + marks[studentId][2] + marks[studentId][3];
        System.out.printf("Average mark for student %d is: %.2f\n", studentId, total / 3);
    }

    private static void getSubjectAverage(Scanner sc) {
        System.out.print("Enter subject ID (1=Math, 2=Chem, 3=Physics): ");
        int subjectId = sc.nextInt();
        if (subjectId < 1 || subjectId > 3) {
            System.out.println("Invalid subject ID.");
            return;
        }

        double total = 0;
        int count = 0;
        for (int i = 1; i <= n; i++) { 
            if (marks[i][subjectId] > 0) { // Check Mark availability
                total += marks[i][subjectId];
                count++;
            }
        }
        if (count > 0) {
            System.out.printf("Average mark for subject %d is: %.2f\n", subjectId, total / count);
        } else {
            System.out.println("Marks not entered.");
        }
    }

    private static void getTotalMarksOfStudent(Scanner sc) {
        System.out.print("Enter student ID (1 to " + n + "): ");
        int studentId = sc.nextInt();
        if (studentId < 1 || studentId > n) {
            System.out.println("Invalid student ID.");
            return;
        }

        double total = marks[studentId][1] + marks[studentId][2] + marks[studentId][3];
        System.out.printf("Total marks for student %d is: %.2f\n", studentId, total);
    }

    private static void displayMarksTable() {
        System.out.println("\n------------------ Student Marks Table ------------------");
        System.out.println("---------------------------------------------------------");
        System.out.printf("%-10s | %-15s | %-15s | %-15s\n", "StudentID", "Math", "Chemistry", "Physics");
        System.out.println("---------------------------------------------------------");

        for (int i = 1; i <= n; i++) {
            System.out.printf("%-10d | %-15.2f | %-15.2f | %-15.2f\n", i, marks[i][1], marks[i][2], marks[i][3]);
        }
        System.out.println("---------------------------------------------------------");
    }
	private static String getGrade(double score) { // Grade marks
        if (score >= 90) {
            return "A";
        } else if (score >= 80) {
            return "B";
        } else if (score >= 70) {
            return "C";
        } else if (score >= 60) {
            return "D";
        } else {
            return "Fail";
        }
    }

    private static void displayGradesTable() {
        System.out.println("\n------------------ Student Grades Table ------------------");
        System.out.println("---------------------------------------------------------");
        System.out.printf("%-10s | %-15s | %-15s | %-15s\n", "StudentID", "Math", "Chemistry", "Physics");
        System.out.println("---------------------------------------------------------");

        for (int i = 1; i <= n; i++) {
            String mathGrade = getGrade(marks[i][1]);
            String chemGrade = getGrade(marks[i][2]);
            String physicsGrade = getGrade(marks[i][3]);
            System.out.printf("%-10d | %-15s | %-15s | %-15s\n", i, mathGrade, chemGrade, physicsGrade);
        }
        System.out.println("---------------------------------------------------------");
    }
}