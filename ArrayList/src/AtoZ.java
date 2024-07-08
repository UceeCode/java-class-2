public class AtoZ {
    public static void main(String[] args) {
        char[] AtoZ = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

        for (int i = AtoZ.length - 1; i >= 0; i--){
            System.out.println(AtoZ[i]);
        }
    }
}
