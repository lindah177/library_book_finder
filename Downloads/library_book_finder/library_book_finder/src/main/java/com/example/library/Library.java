package com.example.library;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/** Stores books and provides simple ways to find and manage them. */
public class Library {
    private final List<Book> books = new ArrayList<>();

    public Library() {
        books.add(new Book("The Hobbit", "J.R.R. Tolkien", "Fantasy"));
        books.add(new Book("Pride and Prejudice", "Jane Austen", "Classic"));
        books.add(new Book("The Martian", "Andy Weir", "Science Fiction"));
        books.add(new Book("Charlotte's Web", "E. B. White", "Children's"));
        books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", "Classic"));
        books.add(new Book("A Wizard of Earthsea", "Ursula K. Le Guin", "Fantasy"));
        books.add(new Book("The Giver", "Lois Lowry", "Science Fiction"));
        books.add(new Book("Matilda", "Roald Dahl", "Children's"));
    }

    public List<Book> getBooks() {
        return new ArrayList<>(books);
    }

    public void addBook(Book book) {
        books.add(book);
    }

    /** Linear search: checks each title and author for the search text. */
    public List<Book> search(String query) {
        String searchText = query.toLowerCase().trim();
        List<Book> matches = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(searchText)
                    || book.getAuthor().toLowerCase().contains(searchText)) {
                matches.add(book);
            }
        }
        return matches;
    }

    public List<Book> getAvailableBooks() {
        List<Book> available = new ArrayList<>();
        for (Book book : books) {
            if (book.isAvailable()) available.add(book);
        }
        return available;
    }

    /** Sorts a copy, leaving the library's original order unchanged. */
    public List<Book> getBooksSortedByTitle() {
        List<Book> sorted = getBooks();
        sorted.sort(Comparator.comparing(Book::getTitle, String.CASE_INSENSITIVE_ORDER));
        return sorted;
    }

    public Book findByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title.trim())) return book;
        }
        return null;
    }
}
