import java.util.ArrayList;
import java.util.Collections;

public class NUMLIST {
    public static void main(String[] args) {
        ArrayList<Integer> Numbers = new ArrayList<Integer>();
        Numbers.add(Integer.MAX_VALUE);
        Numbers.add(Integer.MIN_VALUE);
        Numbers.add(Integer.SIZE);
        Numbers.add(Integer.bitCount(0));
        Collections.sort(Numbers);
        System.out.println(Numbers);
    }
}
