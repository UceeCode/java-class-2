public class FactorialCalculator {

    public long factorial(long number){
        if (number <= 1){
            return 1;
        } else {
            return number * factorial(number - 1);
        }
    }

    public static void main(String[] args) {
        FactorialCalculator calculator = new FactorialCalculator();

        for (int counter = 0; counter <= 21; counter++){
            System.out.printf("Factorial of %d is %d\n", counter, calculator.factorial(counter));
        }
    }
}
