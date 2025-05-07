package com.company.mycollections;

import java.util.ArrayList;

public class Student {
    private final String name;
    private final ArrayList<Book> books;

    public Student(String name, ArrayList<Book> books) {
        this.name = name;
        this.books = books;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public Book getBook(int index) {
        if (index >= 0 && index < books.size()) {
            return books.get(index);
        }
        System.out.println("Index out of range!");
        return null;
    }

    public void setBook(Book book) {
        books.add(book);
    }

    @Override
    public String toString() {
        return this.name + " (" + books.size() + " книг )";
    }
}
