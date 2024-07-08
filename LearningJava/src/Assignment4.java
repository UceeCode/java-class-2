import java.util.Scanner;

public class Assignment4 {
    public static void calcBMI(){
        Scanner W = new Scanner(System.in);
        System.out.println("Enter your weight: ");
        double Weight = W.nextDouble();

        Scanner H = new Scanner(System.in);
        System.out.println("Enter your height: ");
        double Height = H.nextDouble();
        double hq = Height * Height;
        double BMI = Weight / hq;


        if(BMI < 18.5){
            System.out.println("Your BMI = " + BMI + ", You are Underweight. Eat More");
        } else if (BMI >= 18.5 && BMI <= 24.9) {
            System.out.println("Your BMI = " + BMI + ", You are Normal");
        } else if (BMI >= 25 && BMI <= 29.9) {
            System.out.println("Your BMI = " + BMI + ", You are Overweight. Eat Less");
        } else {
            System.out.println("Your BMI = " + BMI + ", You are Obese");
        }
    }
    public static void main(String[] args) {
        calcBMI();
    }
}
