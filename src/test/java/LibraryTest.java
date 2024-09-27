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

    @BeforeEach
    public void setUp() {
        library = new Library();
    }

    @Test
    public void testAddBook() {
        Book book = new Book("978-3-16-148410-0", "The Great Gatsby", "F. Scott Fitzgerald", 1925);
        library.addBook(book);
        System.out.println("Book added: " + book);
        assertEquals(1, library.getAvailableBooks().size(), "Book was not added to the library.");
        System.out.println("Total available books: " + library.getAvailableBooks().size());
    }
}