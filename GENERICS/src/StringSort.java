import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class StringSort {
    static String[] suits = {"Diamonds", "Spade", "Clubs", "Hearts"};
    static List<String> Unsortedlist = Arrays.asList(suits);

    public static void main(String[] args) {
        System.out.printf("Unsorted list of elements: %s\n", Unsortedlist);

        List<String> sortedList = Arrays.asList(suits);
        Collections.sort(sortedList);

        System.out.printf("Sorted list of elements: %s\n", sortedList);
    }

}
