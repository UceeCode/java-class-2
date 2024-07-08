public class Reptile extends Animal {
    public String crawl() {
        System.out.println(super.move());
        return "Reptiles Crawls";
    }

    @Override
    public String eat() {
        System.out.println(super.eat());
        return "Mammals eats too";
    }

    public static void main(String[] args) {
        Reptile lizard = new Reptile();
        Animal animal = new Animal();
        Animal secondAnimal = new Reptile();


        System.out.println(lizard.crawl());
        System.out.println(lizard.eat());
        System.out.println(animal.eat());


    }
}
