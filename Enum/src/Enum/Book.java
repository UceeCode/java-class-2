package Enum;

public enum Book {
    // Enum constants with properties
    BOOK1("Title1", "Author1"),
    BOOK2("Title2", "Author2"),
    BOOK3("Title3", "Author3");

    // Enum properties
    public final String title;
    public final String author;

    // Constructor to initialize enum constants with properties
    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public static void main(String[] args) {
        // Accessing properties of enum constants
        String titleOfBook1 = Book.BOOK1.title;
        String authorofbook1 = Book.BOOK1.author;

        // Displaying properties
        System.out.println("Title of BOOK1: " + titleOfBook1);
        System.out.println("Author of BOOK1: " + authorofbook1);
    }
}
