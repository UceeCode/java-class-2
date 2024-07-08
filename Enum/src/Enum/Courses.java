package Enum;

public enum Courses {
    JVPRL("Java Programming Language", "2022"),
    CHIP("C# Programming Language", "2023"),
    IWDSC("Intro Web Design Concepts", "2024"),
    ANRESP("Angular for responsive web", "2012"),
    PYFAI("Python for artificial intelligence", "2019"),
    REFUIUX("React for UI/UX design", "2023");

    // Enum properties
    private final String title;
    private final String year;

    // Constructor to initialize enum constants with properties
    Courses(String title, String year) {
        this.title = title;
        this.year = year;
    }

    // Getter methods to access enum properties
    public String getTitle() {
        return title;
    }
    public String getYear() {
        return year;
    }

    public static void main(String[] args) {
//        String TitleJvprl = Courses.JVPRL.title;
//        String yearjvprl = Courses.JVPRL.year;
//        System.out.println(TitleJvprl);
//        System.out.println(yearjvprl);

        // Iterate over all enum constants
        for (Courses course : Courses.values()) {
            // Print title and year for each course
            System.out.println("Course: " + course.getTitle() + ", Year: " + course.getYear());
        }
    }
}

