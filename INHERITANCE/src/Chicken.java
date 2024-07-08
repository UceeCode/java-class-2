public class Chicken extends Birds{
    public static void main(String[] args) {
        Animal.name = "Chicken";
        Animal.color = "White";
        Animal.Habitat = "Land";
        Animal.Feeding = "Seeking food OR Foraging";
        Animal.reproduction = "Courtship";
        Animal.survival_Strategy = "Migration";

        Chicken.DetailsOfAnimal();
        Chicken.fly();
        Chicken.feed();
        Chicken.habits();
    }

}
