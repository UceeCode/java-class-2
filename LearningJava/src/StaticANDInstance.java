import java.util.Scanner;

public class StaticANDInstance {

    private static String accountName;

    public static void setaccountName(String accountname) {
        StaticANDInstance.accountName = accountname;
    }

    public static String getaccountName() {
        return accountName;
    }

    public static String display() {
        System.out.println("The account name is " + getaccountName());
        return getaccountName();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the name of your account");
        String accountname = input.next();
        StaticANDInstance.setaccountName(accountname);
        StaticANDInstance.display();
    }
}
