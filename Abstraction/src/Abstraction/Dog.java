package Abstraction;

// Another subclass that extends Abstraction
public class Dog extends Animal {
    // Implementation of the abstract method
    public void makeSound() {
        System.out.println("The Dog Barks");
    }

    public static void main(String[] args) {
        Dog Dog = new Dog(); // Create an object of AnotherDog class
        Dog.makeSound(); // Call the makeSound method
    }
}
