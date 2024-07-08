package Enum;

import java.util.EnumSet;

public enum Days {
    DayOne("Monday", "I wash my clothes"),
    DayTwo("Tuesday", "I go to work"),
    DayThree("Wednesday", "I have a meeting"),
    DayFour("Thursday", "I do the dishes"),
    DayFIve("Friday", "I go to parties"),
    DaySix("Saturday", "I go to the market"),
    DaySeven("Sunday", "I go to church");



    private final String week;
    private final String todo;


    Days(String week, String todo) {
        this.week = week;
        this.todo = todo;
    }

    public String getWeek() {
        return week;
    }

    public String getTodo() {
        return todo;
    }

    public static void main(String[] args) {
        System.out.println("Displaying all days : ");
        for (Days printdays : Days.values()) {
            System.out.printf("%-15s%-15s%s\n", printdays, printdays.getWeek(), printdays.getTodo());
        }

        System.out.println("\nDisplaying a range of Days : ");

        for (Days printdays : EnumSet.range(Days.DayOne, Days.DayThree)){
            System.out.printf("%-15s%-15s%s\n", printdays, printdays.getWeek(), printdays.getTodo());
        }
    }



}
