public class Animal {
    static String name;
    static String color;
    static String Habitat;
    static String Feeding;
    static String reproduction;
    static String survival_Strategy;

    public static void DetailsOfAnimal(){
        System.out.println("\nName = " + name + "\nColor = " + color + "\nHabitat = " + Habitat + "\nHow they feed = " + Feeding + "\nReproduction = " + reproduction + "\nSurvival Strategy = " + survival_Strategy);
    }
    public static void main(String[] args) {
        DetailsOfAnimal();
    }
}