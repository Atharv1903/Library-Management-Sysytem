package test.java;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import main.java.Book;
import main.java.Library;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class LibraryTest {
    
    private Library library;

    // Initializes a new library before each test
    @BeforeEach
    public void setUp() {
        library = new Library();
    }

    // Tests adding a book to the library
    @Test
    public void testAddBook() {
        Book book = new Book("978-3-16-148410-0", "The Great Gatsby", "F. Scott Fitzgerald", 1925);
        library.addBook(book);
        assertEquals(1, library.getAvailableBooks().size(), "Book was not added to the library.");
    }

    // Tests borrowing an available book
    @Test
    public void testBorrowAvailableBook() {
        Book book = new Book("978-3-16-148410-0", "The Great Gatsby", "F. Scott Fitzgerald", 1925);
        library.addBook(book);
        library.borrowBook(book);
        assertFalse(book.isAvailable(), "Book should not be available after being borrowed.");
    }

    // Tests borrowing an unavailable book, expecting an exception
    @Test
    public void testBorrowUnavailableBook() {
        Book book = new Book("978-3-16-148410-0", "The Great Gatsby", "F. Scott Fitzgerald", 1925);
        library.addBook(book);
        library.borrowBook(book); // First borrow
        assertThrows(IllegalStateException.class, () -> library.borrowBook(book), "Borrowing an unavailable book should throw an exception.");
    }

    // Tests returning a borrowed book to the library
    @Test
    public void testReturnBook() {
        Book book = new Book("978-3-16-148410-0", "The Great Gatsby", "F. Scott Fitzgerald", 1925);
        library.addBook(book);
        library.borrowBook(book);
        library.returnBook(book);
        assertTrue(book.isAvailable(), "Book should be available after being returned.");
    }

    // Tests displaying available books and capturing console output
    @Test
    public void testShowAvailableBooks() {
        // Capture console output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out; // Save original System.out
        System.setOut(new PrintStream(outputStream)); // Redirect System.out to outputStream

        // Add books to the library
        Book book1 = new Book("978-3-16-148410-0", "The Great Gatsby", "F. Scott Fitzgerald", 1925);
        Book book2 = new Book("978-1-56619-909-4", "To Kill a Mockingbird", "Harper Lee", 1960);
        Book book3 = new Book("978-0-7432-7356-5", "1984", "George Orwell", 1949);

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        // Borrow a book to make it unavailable
        library.borrowBook(book1);

        // Display available books
        library.showAvailableBooks();

        // Reset System.out to original
        System.setOut(originalOut);

        // Capture output as a string
        String output = outputStream.toString();

        // Check if the correct books are shown as available
        assertTrue(output.contains("To Kill a Mockingbird"), "'To Kill a Mockingbird' should be in available books.");
        assertTrue(output.contains("1984"), "'1984' should be in available books.");
        assertFalse(output.contains("The Great Gatsby"), "'The Great Gatsby' should not be available.");
    }
}
