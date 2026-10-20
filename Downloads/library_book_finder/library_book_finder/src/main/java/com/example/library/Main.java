package com.example.library;

import java.util.List;
import java.util.Scanner;

/** Console menu for trying out the library project. */
public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        try (Scanner scanner = new Scanner(System.in)) {
            boolean running = true;
            while (running) {
                printMenu();
                System.out.print("Choose an option: ");
                String choice = scanner.nextLine().trim();
                switch (choice) {
                    case "1" -> showBooks(library.getBooks());
                    case "2" -> searchBooks(scanner, library);
                    case "3" -> showBooks(library.getBooksSortedByTitle());
                    case "4" -> showBooks(library.getAvailableBooks());
                    case "5" -> changeLoanStatus(scanner, library, true);
                    case "6" -> changeLoanStatus(scanner, library, false);
                    case "7" -> addBook(scanner, library);
                    case "0" -> running = false;
                    default -> System.out.println("Please choose a number from the menu.");
                }
                System.out.println();
            }
        }
        System.out.println("Goodbye!");
    }

    private static void printMenu() {
        System.out.println("=== Library Book Finder ===");
        System.out.println("1. List all books");
        System.out.println("2. Search by title or author");
        System.out.println("3. List books sorted by title");
        System.out.println("4. List available books");
        System.out.println("5. Borrow a book");
        System.out.println("6. Return a book");
        System.out.println("7. Add a book");
        System.out.println("0. Exit");
    }

    private static void showBooks(List<Book> books) {
        if (books.isEmpty()) {
            System.out.println("No books found.");
            return;
        }
        for (Book book : books) System.out.println("- " + book);
    }

    private static void searchBooks(Scanner scanner, Library library) {
        System.out.print("Enter title or author to search for: ");
        showBooks(library.search(scanner.nextLine()));
    }

    private static void changeLoanStatus(Scanner scanner, Library library, boolean borrow) {
        System.out.print("Enter the exact book title: ");
        Book book = library.findByTitle(scanner.nextLine());
        if (book == null) {
            System.out.println("That book is not in the library.");
        } else if (borrow ? book.borrow() : book.returnBook()) {
            System.out.println(borrow ? "Book borrowed." : "Book returned.");
        } else {
            System.out.println(borrow ? "That book is already borrowed." : "That book is already available.");
        }
    }

    private static void addBook(Scanner scanner, Library library) {
        System.out.print("Title: ");
        String title = scanner.nextLine().trim();
        System.out.print("Author: ");
        String author = scanner.nextLine().trim();
        System.out.print("Genre: ");
        String genre = scanner.nextLine().trim();
        if (title.isEmpty() || author.isEmpty() || genre.isEmpty()) {
            System.out.println("Book details cannot be empty; book not added.");
            return;
        }
        library.addBook(new Book(title, author, genre));
        System.out.println("Book added.");
    }
}
