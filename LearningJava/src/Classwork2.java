import java.util.Scanner;

public class Classwork2 {
    public static void Bank(){
        double InitialBalance = -1000.0;

        System.out.println("CURRENT ACCOUNT");
        Scanner CM = new Scanner(System.in);
        System.out.println("Morning\nEnter amount to deposit:");
        double CurrentMorning = CM.nextDouble();

        Scanner CA = new Scanner(System.in);
        System.out.println("Afternoon\nEnter amount to deposit:");
        double CurrentAfternoon = CA.nextDouble();

        Scanner CE = new Scanner(System.in);
        System.out.println("Evening\nEnter amount to depsoit:");
        double CurrentEvening = CE.nextDouble();

        double CurrentBal = CurrentMorning + CurrentAfternoon + CurrentEvening;

        System.out.println("\nSAVINGS ACCOUNT");
        Scanner SM = new Scanner(System.in);
        System.out.println("Morning\nEnter amount to deposit");
        double SavingsMorning = SM.nextDouble();

        Scanner SA = new Scanner(System.in);
        System.out.println("Afternoon\nEnter amount to deposit");
        double SavingsAfternoon = SA.nextDouble();

        Scanner SE = new Scanner(System.in);
        System.out.println("Evening\nEnter amount to deposit");
        double SavingsEvening = SE.nextDouble();

        double SavingsBal = SavingsMorning + SavingsAfternoon + SavingsEvening;

        double TotalBal = CurrentBal + SavingsBal;

        if (InitialBalance < 0) {
            TotalBal -= Math.abs(InitialBalance);
            System.out.println("Balance = " + TotalBal);
        } else{
            InitialBalance += TotalBal;
            System.out.println("Balance = " + InitialBalance);
        }

    }
    public static void main(String[] args) {
        Bank();
    }
}
