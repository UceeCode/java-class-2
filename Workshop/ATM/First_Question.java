import java.util.Scanner;

public class First_Question {
    public static void FindSmallestNumber(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input 5 numbers: ");
        int one = scanner.nextInt();
        int two = scanner.nextInt();
        int three = scanner.nextInt();
        int four = scanner.nextInt();
        int five = scanner.nextInt();

        if (one < two && one < three && one < four && one < five){
            System.out.println("Smallest number = " + one);
        } else if (two < one && two < three && two < four && two < five){
            System.out.println("Smallest number = " + two);
        } else if (three < one && three < two && three < four && three < five){
            System.out.println("Smallest number = " + three);
        } else if (four < one && four < two && four < three && four < five) {
            System.out.println("Smallest number = " + four);
        } else if (five < one && five < two && five < three && five < four){
            System.out.println("Smallest number = " + five);
        } else {
            System.out.println("Invalid");
        }
    }
    public static void main(String[] args) {
        FindSmallestNumber();
    }
}