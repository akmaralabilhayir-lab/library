package com.akmaral.library_api.controller;

import com.akmaral.library_api.dto.AuthorCreateDTO;
import com.akmaral.library_api.dto.AuthorResponseDTO;
import com.akmaral.library_api.model.Author;
import org.springframework.web.bind.annotation.*;
import com.akmaral.library_api.service.AuthorService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorService service;
    public AuthorController(AuthorService service) {
        this.service = service;
    }
    @PostMapping
    public AuthorResponseDTO create(@RequestBody AuthorCreateDTO dto) {
        Author a = service.create(new Author(0, dto.name));
        return new AuthorResponseDTO(a.getId(), a.getName());
    }
    @GetMapping("/{id}")
    public AuthorResponseDTO get(@PathVariable int id) {
        Author a = service.get(id);
        return new AuthorResponseDTO(a.getId(), a.getName());
    }
    @GetMapping
    public List<AuthorResponseDTO> getAll() {
        return service.getAll().stream()
                .map(a -> new AuthorResponseDTO(a.getId(), a.getName()))
                .collect(Collectors.toList());
    }
    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody AuthorCreateDTO dto) {
        service.update(id, dto.name);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}
