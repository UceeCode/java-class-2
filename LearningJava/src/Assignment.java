import java.util.Scanner;

public class Assignment {

    static void returnProductOfThree(){
        Scanner first = new Scanner(System.in);
        System.out.println("Enter first number");
        int firstnumber = first.nextInt();

        Scanner second = new Scanner(System.in);
        System.out.println("Enter second number");
        int secondnumber = second.nextInt();

        Scanner third = new Scanner(System.in);
        System.out.println("Enter third number");
        int thirdnumber = third.nextInt();

        int result = firstnumber * secondnumber * thirdnumber;

        System.out.println("The Product is " + result);

    }

    public static void main(String[] args) {
       returnProductOfThree();
    }
}
