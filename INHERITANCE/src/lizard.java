public class lizard extends Reptiles{
    public static void main(String[] args) {
        Animal.name = "Lizard";
        Animal.color = "Brown";
        Animal.Habitat = "Trees or Hidden places";
        Animal.Feeding = "Ambushing";
        Animal.reproduction = "Nest digging";
        Animal.survival_Strategy = "Camouflage";

        lizard.DetailsOfAnimal();
        lizard.crawl();
    }
}
