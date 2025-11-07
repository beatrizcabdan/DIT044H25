package W46ErrorHandling;

class Book {
    String title;
    String author;
    int pages;

    public Book(String title, String author, int pages) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("No title provided!");
        }
        if (author == null || author.isEmpty()) {
            throw new IllegalArgumentException("No author provided!");
        }
        if (pages < 0) {
            throw new IllegalArgumentException("Page count cannot be negative!");
        }

        this.title = title;
        this.author = author;
        this.pages = pages;
    }
}

public class Example1 {
    public static void main(String[] args) {
        Book b1 = new Book("Java Programming", "John Smith", 3);
        Book b2 = new Book("Java Programming", "John Smith", -3); //is this a compilation or run-time error?
        Book b3 = new Book("Java Programming", "", -3); //never gets here
    }
}
