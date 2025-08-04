package org.example.session18;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Book {

    private String title;
    private String author;
    private Integer numPages;
    private String isbn;

    public Book(String title, String author, Integer numPages, String isbn) {
        this.title = title;
        this.author = author;
        this.numPages = numPages;
        this.isbn = isbn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(isbn, book.isbn) && Objects.equals(title, book.title)
                && Objects.equals(author, book.author) && numPages.equals(book.numPages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn, title, author, numPages);
    }

    @Override
    public String toString() {
        return "Book[" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", numPages=" + numPages +
                ", isbn='" + isbn + '\'' +
                ']';
    }
}

class Box<T> {
    private T item;

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}

class Pair<K,V>{
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}

class LibraryDemo {

    public static void main(String[] args) {
        Book b1 = new Book("Clean code", "Robert C. Marti", 464, "123456");
        Book b2 = new Book("Clean code", "Robert C. Marti", 464, "123456");
        Book b3 = new Book("Effective Java", "Joshua Bloch", 422, "987654");

        System.out.println("b1 equals b2? : " + b1.equals(b2)); // true
        System.out.println("b1 equals b3? : " + b1.equals(b3)); // false

        System.out.println("hashcode b1: " + b1.hashCode());
        System.out.println("hashcode b2: " + b2.hashCode());
        System.out.println("hashcode b3: " + b3.hashCode());

        System.out.println(b1.toString());
        System.out.println(b2.toString());
        System.out.println(b3.toString());

        System.out.println("--------------------");
        Box<Book> bookBox = new Box<>();
        bookBox.setItem(b1);
        System.out.println("Box with Book: " + bookBox.getItem());

        System.out.println("--------------------");
        Pair<String, Integer> bookScore = new Pair<>("Clean Code", 9);
        System.out.println("Book score: " + bookScore.getValue() + bookScore.getKey());

        Book b4 = new Book("Apocalipsa", "S,K" , 1000, "123123");
        Pair<String, Book> favoriteBook = new Pair<>("Fav", b4);
        System.out.println("My favorite book: " + favoriteBook);

        System.out.println("--------------------");
        Map<Book, Integer> inventory = new HashMap<>();
        inventory.put(b1, 10);
        inventory.put(b3, 4);
        inventory.put(b2, 15);
        System.out.println(inventory);


        for (Map.Entry<Book,Integer> entry : inventory.entrySet()){
            System.out.println( entry.getKey() +" cu hashcode: "+ entry.getKey().hashCode() + " are nr de carti: " + entry.getValue());
        }

    }
}
