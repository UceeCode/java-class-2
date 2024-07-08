import java.util.Scanner;

public class Assignment5 {
    public static void testforresponse(){

        int one = 0;
        int two = 0;
        int three = 0;
        int four = 0;
        int five = 0;

        String [] response = {"Very poor", "Poor", "Fair", "Good", "Very Good"};

        for (int i = 1; i <= 10; i++){
            Scanner r = new Scanner(System.in);
            System.out.println("\nUser: " + i +" \nRate the audio call: 1 - 5");
            int rating = r.nextInt();

            if (rating == 1){
                one++;
            } else if (rating == 2) {
                two++;
            } else if (rating == 3) {
                three++;
            } else if (rating == 4) {
                four++;
            } else if (rating == 5) {
                five++;
            }


            if (rating == 1){
                System.out.println("Response = " + response[0]);
            } else if (rating == 2){
                System.out.println("Response = " + response[1]);
            } else if (rating == 3) {
                System.out.println("Response = " + response[2]);
            } else if (rating == 4) {
                System.out.println("Response = " + response[3]);
            } else if (rating == 5) {
                System.out.println("Response = " + response[4]);
            } else {
                System.out.println("\nInvalid!, rate between 1 - 5");
            }
        }

        System.out.println("\nSummary");
        System.out.println("There are " + one + " Very poor, " + two + " Poor, " + three + " Fair, " + four + " Good, " + five + " Very good. ");

    }
    public static void main(String[] args) {
        testforresponse();
    }
}
