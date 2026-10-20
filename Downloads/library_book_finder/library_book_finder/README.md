# Library Book Finder

A small, beginner-friendly Java console project for practicing object-oriented programming, collections, searching, and sorting. It uses an in-memory sample collection, so there is no database or external dependency.

## Requirements

- Java 17 or newer
- Maven 3.6 or newer

## Run it

From the project folder, compile the app:

```bash
mvn compile
```

Then start the menu:

```bash
mvn exec:java -Dexec.mainClass="com.example.library.Main" -Dexec.classpathScope=compile
```

If Maven says it cannot find the `exec` goal, use the compile-and-run commands instead:

```bash
mvn package
java -cp target/classes com.example.library.Main
```

## Menu options

1. List all books
2. Search by title or author
3. List books sorted by title
4. List available books
5. Borrow a book
6. Return a book
7. Add a book (held in memory until the program exits)
0. Exit

Borrow and return operations use the book's exact title. Search is case-insensitive and matches part of a title or author name.

## What you can learn

- **Classes and objects:** `Book` represents one book; `Library` manages a collection; `Main` handles the console menu.
- **Encapsulation:** A book controls its own availability through `borrow()` and `returnBook()`.
- **Collections:** `ArrayList` stores the sample book dataset.
- **Algorithms:** Search uses a simple linear scan (O(n)); sorting uses Java's built-in list sort.

## Try extending it

- Add a search/filter by genre.
- Prevent duplicate titles.
- Add a menu option to count available books.
- Write tests for searching, borrowing, and returning.
- Save and load the collection from a CSV file.
