import java.util.Scanner;

public class Classwork1 {

    public static void age(){
        Scanner a = new Scanner(System.in);
        System.out.println("Enter Your Age: ");
        int Age = a.nextInt();

        if(Age >= 18){
            System.out.println("You are eligible to vote");
        } else if (Age < 18) {
            System.out.println("You are not eligible to vote");
        } else{
            System.out.println("Invalid Age");
        }

    }

    public static void main(String[] args) {
        age();
    }
}