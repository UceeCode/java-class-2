import java.util.Arrays;
import java.util.TreeSet;

public class SortTest {
    public static void main(String[] args) {
        // Array of colors
        String[] colors = {"red", "blue", "green", "yellow", "orange", "purple"};

        // Create a TreeSet from the array
        TreeSet<String> sortedColors = new TreeSet<>(Arrays.asList(colors));

        // Display the sorted colors
        System.out.println("Sorted colors:");
        for (String color : sortedColors) {
            System.out.println(color);
        }

        // Get the headSet of "orange" (exclusive)
        TreeSet<String> headSet = (TreeSet<String>) sortedColors.headSet("orange");
        System.out.println("\nHeadSet before 'orange': " + headSet);

        // Get the tailSet of "green" (inclusive)
        TreeSet<String> tailSet = (TreeSet<String>) sortedColors.tailSet("green", true);
        System.out.println("\nTailSet after 'green': " + tailSet);
    }
}
