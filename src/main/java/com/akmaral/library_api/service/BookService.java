package com.akmaral.library_api.service;
import com.akmaral.library_api.exception.DuplicateResourceException;
import com.akmaral.library_api.exception.*;
import com.akmaral.library_api.model.Book;
import org.springframework.stereotype.Service;
import com.akmaral.library_api.repository.BookRepository;

import java.util.List;

@Service
public class BookService {
    private final BookRepository repo;
    public BookService(BookRepository repo) {
        this.repo = repo;
    }

    public Book create(Book book, String type, int aId, int cId) {
        validateBook(book);
        if (repo.existsByName(book.getName()))   {
            throw new DuplicateResourceException("Book already exists");
        }
        return repo.create(book,type,aId,cId); }
    private void validateBook(Book book) {

        if (book.getName() == null || book.getName().trim().length() < 3) {
            throw new InvalidInputException("Book name must be at least 3 characters long");
        }
    }

    public List<Book> getAll() { return repo.getAll(); }
    public void updateAvailability(int id, boolean av) { repo.updateAvailability(id,av); }
    public void delete(int id) { repo.delete(id); }
}
