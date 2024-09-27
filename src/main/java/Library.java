package main.java;

import java.util.ArrayList;
import java.util.List;

//Represents a library that manages a collection of books.
public class Library {
    
    // List of books in the library
    private List<Book> books;


    //Initializes an empty library.

    public Library() {
        books = new ArrayList<>();
    }


    //Adds a book to the library.

    public void addBook(Book book) {
        books.add(book);
    }


    //Returns a list of available books.

    public List<Book> getAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.isAvailable()) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }


    //Borrows a book if available, otherwise throws an exception.

    public void borrowBook(Book book) {
        if (book.isAvailable()) {
            book.setBorrowed(true);
        } else {
            throw new IllegalStateException("Book is not available for borrowing.");
        }
    }


    //Returns a borrowed book to the library.

    public void returnBook(Book book) {
        book.setBorrowed(false);
    }


    //Displays all available books in the library.

    public void showAvailableBooks() {
        System.out.println("Available Books:");
        for (Book book : books) {
            if (book.isAvailable()) {
                System.out.println(book.getTitle());
            }
        }
    }


    //Displays all borrowed books in the library.

    public void showBorrowedBooks() {
        System.out.println("Borrowed Books:");
        for (Book book : books) {
            if (!book.isAvailable()) {
                System.out.println(book.getTitle());
            }
        }
    }


    //Finds a book by its title (case-insensitive).

    public Book findBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }
}
