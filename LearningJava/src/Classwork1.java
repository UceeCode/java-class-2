import java.util.Scanner;

public class Classwork1 {

    public static void Averageoffive(){
        Scanner one = new Scanner(System.in);
        System.out.println("Enter first number");
        int first = one.nextInt();

        Scanner two = new Scanner(System.in);
        System.out.println("Enter second number");
        int sec = two.nextInt();

        Scanner three = new Scanner(System.in);
        System.out.println("Enter third number");
        int third = three.nextInt();

        Scanner four = new Scanner(System.in);
        System.out.println("Enter fourth number");
        int fourth = four.nextInt();

        Scanner five = new Scanner(System.in);
        System.out.println("Enter fifth number");
        int fifth = five.nextInt();

        int sum = first + sec + third + fourth + fifth;

        int average = sum / 5;

        System.out.println("Average is = " + average);
    }

    public static void main(String[] args) {
        Classwork1.Averageoffive();
    }
}
