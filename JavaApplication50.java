package javaapplication50;


public class JavaApplication50{
    public static void main(String[] args) {
        new LibraryManagementSystemGUI();
    }

}
class Book {
    private String isbn;
    private String title;
    private String author;
    private String publisher;
    private int year;

    public Book(String isbn, String title, String author, String publisher, int year) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
    }

    public String getISBN() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getYear() {
        return year;
    }
}
