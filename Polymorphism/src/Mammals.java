public class Mammals extends Animal{
    public void walk(){
        System.out.println("The mammals walks");
    }

    public void eating(){
        System.out.println("Mammals eat");
    }
    public static void main(String[] args) {
        Animal animal = new Animal();
        Mammals monkey = new Mammals();
        Animal secmammal = new Mammals();

        animal.move();
        monkey.move();

        secmammal.eat();
        animal.eat();
    }
}
