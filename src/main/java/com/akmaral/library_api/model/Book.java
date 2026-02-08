package com.akmaral.library_api.model;
import  com.akmaral.library_api.exception.InvalidInputException;

public abstract class Book extends BaseEntity{
    protected Author author;
    protected Category category;
    protected boolean available;

    protected Book() {};

    protected Book(int id, String name, Author author, Category category, boolean available) {
        super(id, name);
        this.author = author;
        this.category = category;
        this.available = available;
    }

    public Author getAuthor() {
        return author;
    }
    public Category getCategory() {
        return category;
    }
    public boolean isAvailable() {
        return available;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void validate() {
        if(name == null) {
            throw new InvalidInputException("Book name cannot be empty");
        }
        if (author == null) {
            throw new InvalidInputException("Book must have an author");
        }
        if(category == null) {
            throw new InvalidInputException("Book must have a category");
        }
    }
}
