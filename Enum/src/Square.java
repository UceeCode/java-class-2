import java.util.Scanner;

public class Square {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input a number:");

        Integer num = scanner.nextInt();

        SquareRoot.FindSquareRoot(num);
    }
}
