import java.util.Scanner;

public class Fibo {

    public static void fiboCalc(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number");
        int num = scanner.nextInt();

        int firstnum = 0;
        int lastnum = 1;

        for (int i = 0; i < num; i++){
            System.out.println(firstnum);
            int nextTerm = firstnum + lastnum;
            firstnum = lastnum;
            lastnum = nextTerm;
        }
    }

    public static void main(String[] args) {
        fiboCalc();
    }
}
