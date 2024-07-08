public class Car extends Vehicle {
    int noOfTyres = 4;

    String color = "white";

    int noOfDoors = 4;

    public static void runInCar(){
        System.out.println("Run in car subclass");
    }


    public static void main(String[] args) {
        Car toyota = new Car();
        toyota.runInCar();
    }

    public class miniCar extends Car{
        public static void move(){
            System.out.println("Move in subclass");
        }

        public static void main(String[] args) {

        }
    }
}
