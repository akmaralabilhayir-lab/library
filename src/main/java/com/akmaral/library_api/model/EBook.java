package com.akmaral.library_api.model;

public class EBook extends Book{
    public EBook(int id, String name, Author author, Category category, boolean available) {
        super(id, name, author, category, available);
    }

    public EBook() {
        super();
    }

    public void printInfo() {
        System.out.println("EBook: " + name + ", Author: " + author.name + ", Category: "
                + category.name + ", Available: " + available);
    }
}
