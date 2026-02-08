package com.akmaral.library_api.service;

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

    public Book create(Book b, String type, int aId, int cId) {  return repo.create(b,type,aId,cId); } // C
    public List<Book> getAll() { return repo.getAll(); }                                                             // R
    public void updateAvailability(int id, boolean av) { repo.updateAvailability(id,av); }                          // U
    public void delete(int id) { repo.delete(id); }                                                                  // D
}
