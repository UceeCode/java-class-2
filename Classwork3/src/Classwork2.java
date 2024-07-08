import java.util.Scanner;

public class Classwork2 {
    public static void AverageFinder(){
        int A = 0;
        int B = 0;
        int C = 0;
        int D = 0;
        int F = 0;

        Scanner f = new Scanner(System.in);
        System.out.println("Enter mark for first subject");
        int first = f.nextInt();

        Scanner s = new Scanner(System.in);
        System.out.println("Enter mark for second subject");
        int second = s.nextInt();

        Scanner t = new Scanner(System.in);
        System.out.println("Enter mark for third subject");
        int third = t.nextInt();

        Scanner fo = new Scanner(System.in);
        System.out.println("Enter mark for fourth subject");
        int fourth = fo.nextInt();

        Scanner fi = new Scanner(System.in);
        System.out.println("Enter mark for fifth subject");
        int fifth = fi.nextInt();

        Scanner si = new Scanner(System.in);
        System.out.println("Enter mark for sixth subject");
        int sixth = si.nextInt();

        Scanner se = new Scanner(System.in);
        System.out.println("Enter mark for seventh subject");
        int seven = se.nextInt();

        Scanner ei = new Scanner(System.in);
        System.out.println("Enter mark for eighth subject");
        int eight = ei.nextInt();

        Scanner ni = new Scanner(System.in);
        System.out.println("Enter mark for ninth subject");
        int ninth = ni.nextInt();

        Scanner te = new Scanner(System.in);
        System.out.println("Enter mark for tenth subject");
        int ten = te.nextInt();

        if (first >= 85 && first <= 100){
            A++;
        } else if (first >= 65 && first <= 84) {
            B++;
        } else if (first >= 50 && first <= 59) {
            B++;
        } else if (first >= 40 && first <= 49) {
            C++;
        } else if (first >= 35 && first <= 39) {
            D++;
        } else if (first <= 34) {
            F++;
        }

        if (second >= 85 && second <= 100){
            A++;
        } else if (second >= 65 && second <= 84) {
            B++;
        } else if (second >= 50 && second <= 59) {
            B++;
        } else if (second >= 40 && second <= 49) {
            C++;
        } else if (second >= 35 && second <= 39) {
            D++;
        } else if (second <= 34) {
            F++;
        }

        if (third >= 85 && third <= 100){
            A++;
        } else if (third >= 65 && third <= 84) {
            B++;
        } else if (third >= 50 && third <= 59) {
            B++;
        } else if (third >= 40 && third <= 49) {
            C++;
        } else if (third >= 35 && third <= 39) {
            D++;
        } else if (third <= 34) {
            F++;
        }

        if (fourth >= 85 && fourth <= 100){
            A++;
        } else if (fourth >= 65 && fourth <= 84) {
            B++;
        } else if (fourth >= 50 && fourth <= 59) {
            B++;
        } else if (fourth >= 40 && fourth <= 49) {
            C++;
        } else if (fourth >= 35 && fourth <= 39) {
            D++;
        } else if (fourth <= 34) {
            F++;
        }

        if (fifth >= 85 && fifth <= 100){
            A++;
        } else if (fifth >= 65 && fifth <= 84) {
            B++;
        } else if (fifth >= 50 && fifth <= 59) {
            B++;
        } else if (fifth >= 40 && fifth <= 49) {
            C++;
        } else if (fifth >= 35 && fifth <= 39) {
            D++;
        } else if (fifth <= 34) {
            F++;
        }

        if (sixth >= 85 && sixth <= 100){
            A++;
        } else if (sixth >= 65 && sixth <= 84) {
            B++;
        } else if (sixth >= 50 && sixth <= 59) {
            B++;
        } else if (sixth >= 40 && sixth <= 49) {
            C++;
        } else if (sixth >= 35 && sixth <= 39) {
            D++;
        } else if (sixth <= 34) {
            F++;
        }

        if (seven >= 85 && seven <= 100){
            A++;
        } else if (seven >= 65 && seven <= 84) {
            B++;
        } else if (seven >= 50 && seven <= 59) {
            B++;
        } else if (seven >= 40 && seven <= 49) {
            C++;
        } else if (seven >= 35 && seven <= 39) {
            D++;
        } else if (seven <= 34) {
            F++;
        }

        if (eight >= 85 && eight <= 100){
            A++;
        } else if (eight >= 65 && eight <= 84) {
            B++;
        } else if (eight >= 50 && eight <= 59) {
            B++;
        } else if (eight >= 40 && eight <= 49) {
            C++;
        } else if (eight >= 35 && eight <= 39) {
            D++;
        } else if (eight <= 34) {
            F++;
        }

        if (ninth >= 85 && ninth <= 100){
            A++;
        } else if (ninth >= 65 && ninth <= 84) {
            B++;
        } else if (ninth >= 50 && ninth <= 59) {
            B++;
        } else if (ninth >= 40 && ninth <= 49) {
            C++;
        } else if (ninth >= 35 && ninth <= 39) {
            D++;
        } else if (ninth <= 34) {
            F++;
        }

        if (ten >= 85 && ten <= 100){
            A++;
        } else if (ten >= 65 && ten <= 84) {
            B++;
        } else if (ten >= 50 && ten <= 59) {
            B++;
        } else if (ten >= 40 && ten <= 49) {
            C++;
        } else if (ten >= 35 && ten <= 39) {
            D++;
        } else if (ten <= 34) {
            F++;
        }

        int sumOfmarks = first + second + third + fourth + fifth + sixth + seven + eight + ninth + ten;

        double Avg = sumOfmarks / 10;

        System.out.println("Result = " + sumOfmarks);


        if (Avg >= 85 && Avg <= 100){
            System.out.println("Average = " + Avg + " Distinction." + " You got " + A + "A's, " + B + "B's, " + C + "C's, " +  D + "D's, " +  F + "F's");
        } else if (Avg >= 65 && Avg <= 84) {
            System.out.println("Average = " + Avg + " Very Good."  + " You got " + A + "A's, " + B + "B's, " + C + "C's, " +  D + "D's, " +  F + "F's");
        } else if (Avg >= 50 && Avg <= 59) {
            System.out.println("Average = " + Avg + " Good." + " You got " + A + "A's, " + B + "B's, " + C + "C's, " +  D + "D's, " +  F + "F's");
        } else if (Avg >= 40 && Avg <= 49) {
            System.out.println("Average = " + Avg + " Credit." + " You got " + A + "A's, " + B + "B's, " + C + "C's, " +  D + "D's, " +  F + "F's");
        } else if (Avg >= 35 && Avg <= 39) {
            System.out.println("Average = " + Avg + " Fair."  + " You got " + A + "A's, " + B + "B's, " + C + "C's, " +  D + "D's, " +  F + "F's");
        } else if (Avg <= 34) {
            System.out.println("Average = " + Avg + " Failed."  + " You got " + A + "A's, " + B + "B's, " + C + "C's, " +  D + "D's, " +  F + "F's");
        } else {
            System.out.println("Not valid");
        }


    }
    public static void main(String[] args) {
        AverageFinder();
    }
}
