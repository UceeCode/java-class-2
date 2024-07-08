import java.util.ArrayList;
import java.util.Collections;

public class MyList {
    public static void main(String[] args) {
        ArrayList<String> cars = new ArrayList<String>();
        cars.add("Toyota");
        cars.add("Bmw");
        cars.add("Lexus");
        cars.add("Ferrari");
        cars.add("Lamborghini");
        cars.add("Range Rover");
        cars.set(1, "Volvo");
        for (int i = 0; i < cars.size(); i++){
            System.out.println(cars.get(i));
        }
        Collections.sort(cars); //to sort the list
        System.out.println(cars);
//        System.out.println(cars.get(1));
//        System.out.println(cars.size());
//        System.out.println(cars.getFirst());
    }
}