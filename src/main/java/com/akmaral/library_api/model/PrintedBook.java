package com.akmaral.library_api.model;

public class PrintedBook extends Book {
    public PrintedBook() {
        super();
    }

    public PrintedBook(int id, String name, Author author, Category category, boolean available) {
        super(id, name, author, category, available);
    }

    public void printInfo() {
        System.out.println(
                "Printed Book: " + name +
                        ", Author: " + author.name +
                        ", Category: " + category.name +
                        ", Available: " + available
        );
    }
}
