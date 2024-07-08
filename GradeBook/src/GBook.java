import java.util.Scanner;

public class GBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of students ");
        int numberOfStudents = scanner.nextInt();

       String[] studentNames = new String[numberOfStudents];
       double[] studentGrades = new double[numberOfStudents];

       for (int i = 0; i < numberOfStudents; i++){
           scanner.nextLine();
           System.out.println("Enter student name " + (i + 1) + ":");
           studentNames[i] = scanner.nextLine();
           System.out.println("Enter student Grade " + (i + 1) + ":");
           studentGrades[i] = scanner.nextDouble();
       }

       for (int i = 0; i < numberOfStudents; i++){
           System.out.println("Name: " + studentNames[i] + " " + " " + "Grade: " + studentGrades[i]);
       }

       double sum = 0;
       for (int i = 0; i < numberOfStudents; i++){
           sum += studentGrades[i];
           double Avg = sum/numberOfStudents;
           System.out.println("\nAverage Grade: " + Avg);
       }


       double highestGrade = studentGrades[0];
       for (int i = 0; i < numberOfStudents; i++){
           if (studentGrades[i] > highestGrade){
               highestGrade = studentGrades[i];
           }
       }
       System.out.println("Highest Grade = " + highestGrade);

       double Lowestgrade = studentGrades[0];
       for (int i = 0; i < numberOfStudents; i++){
           if (studentGrades[i] < Lowestgrade){
               Lowestgrade = studentGrades[i];
           }
       }
        System.out.println("Lowest Grade " + Lowestgrade);
    }
}


// Prompt the user to enter the number of students
// Create arrays to store student names and grades
// Input student names and grades
// Display student names and grades
// Calculate and display average grade
// Determine and display highest grade
// Determine and display lowest grade