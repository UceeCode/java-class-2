import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NumberSort {

    public static void RemoveDuplicates(Integer numbers[], int n) {
        int j = 0;
        for (int i = 1; i < n; i++) {
            if (numbers[i] != numbers[i - 1]) {
                numbers[j++] = numbers[i - 1];
            }
        }
        numbers[j++] = numbers[n - 1];
        for (int i = 0; i < j; i++) {
            System.out.print(numbers[i] + " ");
        }
    }

    public static void main(String[] args) {

        Integer[] numbers = {6, 24, 34, 14, 58, 5, 5, 34, 12, 14, 58, 6, 24, 22};
        int n = numbers.length;

        List<Integer> sortedNumbers = Arrays.asList(numbers);

        Collections.sort(sortedNumbers);

        RemoveDuplicates(numbers, n);
    }
}