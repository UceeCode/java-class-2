import java.sql.SQLOutput;
import java.util.Scanner;

public class Assignment2 {

    static void returnNUMSQUARECUBE(){
        Scanner n = new Scanner(System.in);
        System.out.print("Enter a number: ");

        int num = n.nextInt();

        System.out.println("Number = " + num);
        System.out.println("Square of number = " + num * num);
        System.out.println("Cube of number = " + num * num * num);
    }


    public static void main(String[] args) {
        returnNUMSQUARECUBE();
    }
}
