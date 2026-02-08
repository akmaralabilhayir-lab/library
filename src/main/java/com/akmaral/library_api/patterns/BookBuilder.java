package com.akmaral.library_api.patterns;

import com.akmaral.library_api.model.Author;
import com.akmaral.library_api.model.Book;
import com.akmaral.library_api.model.Category;

public class BookBuilder {

    private final Book book;

    private BookBuilder(Book book) {
        this.book = book;
    }

    public static BookBuilder builder(String type) {
        return new BookBuilder(BookFactory.create(type));
    }

    public BookBuilder name(String name) {
        book.setName(name);
        return this;
    }

    public BookBuilder author(Author author) {
        book.setAuthor(author);
        return this;
    }

    public BookBuilder category(Category category) {
        book.setCategory(category);
        return this;
    }

    public BookBuilder available(boolean available) {
        book.setAvailable(available);
        return this;
    }

    public Book build() {
        return book;
    }
}
