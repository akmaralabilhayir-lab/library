package com.akmaral.library_api.service;

import com.akmaral.library_api.model.Author;
import org.springframework.stereotype.Service;
import com.akmaral.library_api.repository.AuthorRepository;

import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository repo;

    public AuthorService(AuthorRepository repo) {
        this.repo = repo;
    }

    public Author create(Author a) { a.validate(); return repo.create(a); } // C
    public Author get(int id) { return repo.get(id); }                      // R
    public List<Author> getAll() { return repo.getAll(); }                  // R
    public void update(int id, String name) { repo.update(id, name); }      // U
    public void delete(int id) { repo.delete(id); }                         // D
}
