import java.util.LinkedList;

public class List {


    public static void main(String[] args) {
        LinkedList<String> cars = new LinkedList<String>();

        cars.add("Toyota");
        cars.add("Lexus");
        cars.add("Porshe");

        System.out.println(cars);
        cars.addFirst("Bus");
        System.out.println(cars);
        cars.addLast("Range Rover");
        System.out.println(cars);
    }
}
