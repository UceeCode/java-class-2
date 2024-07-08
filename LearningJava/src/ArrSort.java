import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrSort {
    public static void main(String[] args) {
//      String [] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
//        List <String> list = Arrays.asList(suits);
//        System.out.println("Unsorted list is : \n" + list);
//
//        //sorting the list in alphabetical order
//
//        Collections.sort(list);
//        System.out.println("Sorted list is : \n" + list);

//        int [] array = {32, 27, 64, 28, 95, 14, 90, 37};
        final int ARRAY_LENGTH = 10;
        int [] array = new int [ARRAY_LENGTH];

        for (int i = 0; i < array.length; i++){
            array[i] =2+2*i;
            System.out.printf("%2d %6d\n", i, array[i]);
        }
    }
}
