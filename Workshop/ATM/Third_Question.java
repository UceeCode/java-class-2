public class Third_Question {
    public static void Moneysum(){
        double savingsBal = 1000;
        double interest = 0.05;

        int yearOne = 1;
        int yearTwo = 2;
        int yearThree = 3;
        int yearFour = 4;
        int yearFive = 5;
        int YearSix = 6;
        int YearSeven = 7;
        int YearEight = 8;
        int YearNine = 9;
        int YearTen = 10;

        double AmountInYearOne = savingsBal * (interest + 1) * yearOne;
        System.out.println("Amount in Year 1 = " + "$"+ AmountInYearOne);

        double AmountInYearTwo = savingsBal * (interest + 1) * yearTwo;
        System.out.println("Amount in Year 2 = " + "$"+ AmountInYearTwo);

        double AmountInYearThree = savingsBal * (interest + 1) * yearThree;
        System.out.println("Amount in Year 3 = " + "$"+ AmountInYearThree);

        double AmountInYearFour = savingsBal * (interest + 1) * yearFour;
        System.out.println("Amount in Year 4 = " + "$"+ AmountInYearFour);

        double AmountInYearFive = savingsBal * (interest + 1) * yearFive;
        System.out.println("Amount in Year 5 = " + "$"+ AmountInYearFive);

        double AmountInYearSix = savingsBal * (interest + 1) * YearSix;
        System.out.println("Amount in Year 6 = " + "$"+ AmountInYearSix);

        double AmountInYearSeven = savingsBal * (interest + 1) * YearSeven;
        System.out.println("Amount in Year 7 = " + "$"+ AmountInYearSeven);

        double AmountInYearEight = savingsBal * (interest + 1) * YearEight;
        System.out.println("Amount in Year 8 = " + "$"+ AmountInYearEight);

        double AmountInYearNine = savingsBal * (interest + 1) * YearNine;
        System.out.println("Amount in Year 9 = " + "$"+ AmountInYearNine);

        double AmountInYearTen = savingsBal * (interest + 1) * YearTen;
        System.out.println("Amount in Year 10 = " + "$"+ AmountInYearTen);

    }
    public static void main(String[] args) {
        Moneysum();
    }
}
