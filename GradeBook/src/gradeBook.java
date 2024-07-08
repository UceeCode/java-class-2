import java.util.Scanner;

public class gradeBook {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the number of students
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();

        // Create arrays to store student names and grades
        String[] studentNames = new String[numStudents];
        double[] studentGrades = new double[numStudents];

        // Input student names and grades
        for (int i = 0; i < numStudents; i++) {
            scanner.nextLine(); // Consume newline character
            System.out.print("Enter name of student " + (i + 1) + ": ");
            studentNames[i] = scanner.nextLine();
            System.out.print("Enter grade of student " + (i + 1) + ": ");
            studentGrades[i] = scanner.nextDouble();
        }

        // Display student names and grades
        System.out.println("\nStudent Grade Report:");
        for (int i = 0; i < numStudents; i++) {
            System.out.println(studentNames[i] + ": " + studentGrades[i]);
        }

        // Calculate and display average grade
        double sum = 0;
        for (int i = 0; i < numStudents; i++){
            sum += studentGrades[i];
            double Avg = sum/numStudents;
            System.out.println("\nAverage Grade: " + Avg);
        }

        // Determine and display highest grade
        double highestGrade = studentGrades[0];
        for (int i = 1; i < numStudents; i++) {
            if (studentGrades[i] > highestGrade) {
                highestGrade = studentGrades[i];
            }
        }
        System.out.println("Highest Grade: " + highestGrade);

        // Determine and display lowest grade
        double lowestGrade = studentGrades[0];
        for (int i = 1; i < numStudents; i++) {
            if (studentGrades[i] < lowestGrade) {
                lowestGrade = studentGrades[i];
            }
        }
        System.out.println("Lowest Grade: " + lowestGrade);

        scanner.close(); // Close scanner
    }
}
