import java.util.Scanner;

public class MaximumDeposit {
    public static double maxfinder(double x, double y, double z) {
        double maximum = x;
        if (y > maximum) {
            maximum = y;
        }
        if (z > maximum) {
            maximum = z;
        }
        return maximum;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter first deposit:");
        double deposit1 = input.nextDouble();

        System.out.println("Enter second deposit:");
        double deposit2 = input.nextDouble();

        System.out.println("Enter third deposit:");
        double deposit3 = input.nextDouble();

        double maxDeposit = MaximumDeposit.maxfinder(deposit1, deposit2, deposit3);
        System.out.println("The maximum deposit is: " + maxDeposit);
    }
}
