//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void Greetme(){
        System.out.println("Good morning");
    }
    public static void main(String[] args) {
        String name = "Uchenna";
        System.out.println("Hello " + name);

        int f = 10;
        int s = 20;
        int result = f + s;
        System.out.println(result);

        double myd = 7.876;
        int myi = (int) myd;

        System.out.println(myd);
        System.out.println(myi);

        int time = 20;

        String r = (time < 18) ? "Goodday" : "Goodnight";
        System.out.println(r);

        Greetme();
    }
}