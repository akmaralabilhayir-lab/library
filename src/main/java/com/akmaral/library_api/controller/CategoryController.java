package com.akmaral.library_api.controller;

import com.akmaral.library_api.dto.CategoryCreateDTO;
import com.akmaral.library_api.dto.CategoryResponseDTO;
import com.akmaral.library_api.model.Category;
import org.springframework.web.bind.annotation.*;
import com.akmaral.library_api.service.CategoryService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService service;
    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @PostMapping
    public CategoryResponseDTO create(@RequestBody CategoryCreateDTO dto) {
        Category c = service.create(new Category(0, dto.name));
        return new CategoryResponseDTO(c.getId(), c.getName());
    }

    @GetMapping("/{id}")
    public CategoryResponseDTO get(@PathVariable int id) {
        Category c = service.get(id);
        return new CategoryResponseDTO(c.getId(), c.getName());
    }

    @GetMapping
    public List<CategoryResponseDTO> getAll() {
        return service.getAll()
                .stream()
                .map(c -> new CategoryResponseDTO(c.getId(), c.getName()))
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody CategoryCreateDTO dto) {
        service.update(id, dto.name);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}
