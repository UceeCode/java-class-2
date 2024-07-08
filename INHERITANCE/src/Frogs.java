public class Frogs extends Amphibians{
    public static void main(String[] args) {
        Animal.name = "Frog";
        Animal.color = "green";
        Animal.Habitat = "Water and Land";
        Animal.Feeding = "Insects or worms";
        Animal.reproduction = "Laying eggs";
        Animal.survival_Strategy = "Burrowing";

        Frogs.DetailsOfAnimal();
        Frogs.jump();
    }
}
