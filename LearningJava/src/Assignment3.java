import java.util.Scanner;

public class Assignment3 {

    static void findCubeRoot(){
        Scanner n = new Scanner(System.in);
        System.out.print("Enter a number: ");

        int num = n.nextInt();

        double cuberoot = Math.cbrt(num);

        System.out.println("Cube root = " + cuberoot);
    }
    public static void main(String[] args) {
        findCubeRoot();
    }
}
