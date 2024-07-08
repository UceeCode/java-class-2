public class Fibbonacci {

   public static void fiboCalcculator(int num){
       int firstTerm = 0;
       int secTerm = 1;

       for (int i = 0; i < num; i++){
           System.out.println(firstTerm);

           int nextTerm = firstTerm + secTerm;
           firstTerm = secTerm;
           secTerm = nextTerm;

       }

   }

    public static void main(String[] args) {
        fiboCalcculator(10000);
    }
}
