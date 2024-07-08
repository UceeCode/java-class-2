import java.util.Scanner;

public class Classwork3 {
    public static void TrainglesFinder(){
        Scanner one = new Scanner(System.in);
        System.out.println("Enter length of one side of a triangle");
        int oneside = one.nextInt();

        Scanner two = new Scanner(System.in);
        System.out.println("Enter length of second side of a triangle");
        int secside = two.nextInt();

        Scanner three = new Scanner(System.in);
        System.out.println("Enter length of third side of a triangle");
        int thirdside = three.nextInt();

        if (oneside == secside && oneside == thirdside){
            System.out.println("Equal Sides: Equilateral Triangle");
        } else if (oneside == secside && oneside != thirdside || oneside == thirdside && oneside != secside) {
            System.out.println("Two Equal Sides: Isoceles Triangle");
        } else if (oneside != secside && oneside != thirdside) {
            System.out.println("No Equal Sides: Scalene Triangle");
        }
    }

    public static void main(String[] args) {
        TrainglesFinder();
    }
}
