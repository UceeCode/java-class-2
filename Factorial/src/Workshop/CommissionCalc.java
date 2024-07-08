package Workshop;

import java.util.Scanner;

public class CommissionCalc {
    public static void CommissionCalculator() {
        double item1 = 239.99;
        double item2 = 129.75;
        double item3 = 99.95;
        double item4 = 350.89;

        double commissionRate = 0.09;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input items sold last week for each salesperson and each item:");

        double totalCommission = 0;

        for (int salesperson = 1; salesperson <= 4; salesperson++) {
            System.out.println("\nSalesperson " + salesperson + ":");

            System.out.print("Item 1: ");
            int soldItem1 = scanner.nextInt();

            System.out.print("Item 2: ");
            int soldItem2 = scanner.nextInt();

            System.out.print("Item 3: ");
            int soldItem3 = scanner.nextInt();

            System.out.print("Item 4: ");
            int soldItem4 = scanner.nextInt();

            double commission = (item1 * soldItem1 * commissionRate) + (item2 * soldItem2 * commissionRate) + (item3 * soldItem3 * commissionRate) + (item4 * soldItem4 * commissionRate);

            totalCommission += commission;

            System.out.println("Commission for Salesperson " + salesperson + ": £" + commission);
        }

        System.out.println("\nTotal commission earned by all salespeople: £" + totalCommission);
    }

    public static void main(String[] args) {
        CommissionCalculator();
    }
}
