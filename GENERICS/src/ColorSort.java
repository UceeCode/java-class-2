import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ColorSort {
    public static void main(String[] args) {
//        String [] color = {"MAGENTA", "RED", "WHITE", "BLUE", "CYAN"};
//        List <String> list = Arrays.asList(color);
//        Collections.sort(list);
//        System.out.println(list);

        String[] colors = {"MAGENTA", "RED", "WHITE", "BLUE", "CYAN"};
        List<String> list = new ArrayList<String>();

        // Add colors to the list
        for(String color : colors) {
            list.add(color);
        }

        // Create a list of colors to remove
        String[] removeColors = {"RED", "WHITE", "BLUE"};
        List<String> removeList = Arrays.asList(removeColors);

        // Remove elements from the list
        list.removeAll(removeList);

        // Print the modified list
        System.out.println("List after removing colors: " + list);

    }
}
