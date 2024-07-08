import java.util.Scanner;

public class Shape {
    public static double PI = 3.142;

    public static double AreaOfCircle(){
        Scanner r = new Scanner(System.in);
        System.out.println("Enter the radius: ");
        int radius = r.nextInt();
        double radiussq = radius * radius;
        double area = PI * radiussq;
        return area;
    }

    public static double AreaofRectangle(){
        Scanner l = new Scanner(System.in);
        System.out.println("Enter length of the rectangle");
        int length = l.nextInt();
        Scanner b = new Scanner(System.in);
        System.out.println("Enter breath of the rectangle");
        int breath = b.nextInt();
        double area = length * breath;
        return area;
    }

    public static double AreaofSquare(){
        Scanner le = new Scanner(System.in);
        System.out.println("Enter length of the square");
        int lengths = le.nextInt();
        double area = lengths * lengths;
        return area;
    }
    public static void main(String[] args) {
        System.out.println("Area of a cicle is " + AreaOfCircle());
        System.out.println("Area of a rectangle is " + AreaofRectangle());
        System.out.println("Area of a square is " + AreaofSquare());
    }
}
