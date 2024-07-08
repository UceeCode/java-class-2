package Workshop;

import java.util.Scanner;


public class SalaryCalc {
    public static void SalaryCalculator() {
        Scanner scanner = new Scanner(System.in);

        for (int i = 1; i <= 3; i++) {
            System.out.println("\nEmployee " + i + ":");
            System.out.println("Input number of hours worked last week (1 - 40):");
            int numofhours = scanner.nextInt();

            System.out.println("Input number of excess hours worked:");
            int excessTime = scanner.nextInt();

            System.out.println("Input hourly rate:");
            double hourlyRate = scanner.nextDouble();

            double straightTimePay = numofhours * hourlyRate;

            double excessTimePay = 0;
            excessTimePay = excessTime * (hourlyRate * 1.5);

            double grossPay = straightTimePay + excessTimePay;

            System.out.println("Gross Pay = $" + grossPay);
        }

    }

    public static void main(String[] args) {
        SalaryCalculator();
    }
}
