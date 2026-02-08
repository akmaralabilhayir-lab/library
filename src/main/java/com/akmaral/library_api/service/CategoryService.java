package com.akmaral.library_api.service;

import com.akmaral.library_api.model.Category;
import org.springframework.stereotype.Service;
import com.akmaral.library_api.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository repo;

    public CategoryService(CategoryRepository repo) {
        this.repo = repo;
    }

    public Category create(Category c) {
        c.validate();
        return repo.create(c);
    }

    public Category get(int id) {
        return repo.get(id);
    }

    public List<Category> getAll() {
        return repo.getAll();
    }

    public void update(int id, String name) {
        repo.update(id, name);
    }

    public void delete(int id) {
        repo.delete(id);
    }
}
