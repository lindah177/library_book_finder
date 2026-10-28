package com.example.library;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
    @Test
    void sampleLibraryContainsBooks(){
        Library library = new Library();
        assertFalse(library.getBooks().isEmpty());
    }
    @Test
    void searchFindsByTitleRegardlessOfCase(){
        Library library = new Library();
        var results = library.search("the hobbit");
        assertEquals(1, results.size());
        assertEquals("The Hobbit", results.get(0).getTitle());
    }
    @Test
    void searchFindsBookByAuthor() {
        Library library = new Library();

        var results = library.search("Jane Austen");

        assertEquals(1, results.size());
        assertEquals("Pride and Prejudice", results.get(0).getTitle());
    }

    @Test
    void borrowMakesAvailableBookUnavailable() {
        Book book = new Book("The Hobbit", "J.R.R. Tolkien", "Fantasy");

        assertTrue(book.borrow());
        assertFalse(book.isAvailable());
    }

    @Test
    void cannotBorrowBookTwice() {
        Book book = new Book("The Hobbit", "J.R.R. Tolkien", "Fantasy");

        assertTrue(book.borrow());
        assertFalse(book.borrow());
    }

    @Test
    void returnMakesBorrowedBookAvailableAgain() {
        Book book = new Book("The Hobbit", "J.R.R. Tolkien", "Fantasy");
        book.borrow();

        assertTrue(book.returnBook());
        assertTrue(book.isAvailable());
    }

    @Test
    void cannotReturnBookThatWasNotBorrowed() {
        Book book = new Book("The Hobbit", "J.R.R. Tolkien", "Fantasy");

        assertFalse(book.returnBook());
        assertTrue(book.isAvailable());
    }

    @Test
    void addingBookMakesItSearchable() {
        Library library = new Library();
        library.addBook(new Book("Dune", "Frank Herbert", "Science Fiction"));

        var results = library.search("Dune");

        assertEquals(1, results.size());
        assertEquals("Frank Herbert", results.get(0).getAuthor());
    }

}
