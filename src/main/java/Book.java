package main.java;

//Represents a book in the library.

public class Book {
    // ISBN of the book
    private String isbn;

    // Title of the book (final)
    final String title;

    // Author of the book (final)
    final String author;

    // Publication year of the book (final)
    final int publicationYear;

    // Borrowed status of the book
    private boolean borrowed;

    //Constructor to initialize the book.
    public Book(String isbn, String title, String author, int publicationYear) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.borrowed = false;  // Not borrowed initially
    }

    // Returns the ISBN
    public String getIsbn() {
        return isbn;
    }

    // Returns the title
    public String getTitle() {
        return title;
    }

    // Returns the author
    public String getAuthor() {
        return author;
    }

    // Returns the publication year
    public int getPublicationYear() {
        return publicationYear;
    }

    // Checks if the book is available
    public boolean isAvailable() {
        return !borrowed;
    }

    // Sets the borrowed status
    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

    //Main method for testing.

    public static void main(String []args) {
        // Create a book object
        Book obj = new Book("true", "Chava", "Shivaji Sawant", 1980);

        // Print the author
        System.out.println(obj.getAuthor());
    }
}
