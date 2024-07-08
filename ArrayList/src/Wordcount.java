import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Wordcount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> wordCountMap = new HashMap<>();

        System.out.println("Enter words (type 'exit' to end):");

        // Continue taking input until the user types 'exit'
        while (true) {
            String word = scanner.next();

            // Check if the user wants to exit
            if (word.equals("exit")) {
                break;
            }

            // Update the word count
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }

        // Display the word count
        System.out.println("\nWord Counts:");
        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        scanner.close();
    }
}
