public class reverse {

    public static void main(String[] args) {
        double[] arr = {1.1, 2.2, 3.3, 4.4, 5.5};
        double[] reversedArr = reverseArray(arr);

        for (double num : reversedArr) {
            System.out.print(num + " ");
        }

        System.out.println(); 
    }

    public static double[] reverseArray(double[] arr) {
        double[] reversed = new double[arr.length];

        for (int i = arr.length - 1, j = 0; i >= 0; i--, j++) {
            reversed[j] = arr[i];
        }

        return reversed;
    }
}
