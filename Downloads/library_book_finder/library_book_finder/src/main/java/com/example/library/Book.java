package com.example.library;

/** Represents one book in the library collection. */
public class Book {
    private final String title;
    private final String author;
    private final String genre;
    private boolean available;

    public Book(String title, String author, String genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.available = true;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getGenre() { return genre; }
    public boolean isAvailable() { return available; }

    public boolean borrow() {
        if (!available) return false;
        available = false;
        return true;
    }

    public boolean returnBook() {
        if (available) return false;
        available = true;
        return true;
    }

    @Override
    public String toString() {
        return title + " — " + author + " [" + genre + "] — "
                + (available ? "Available" : "Borrowed");
    }
}
