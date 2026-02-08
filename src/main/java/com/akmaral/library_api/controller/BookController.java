package com.akmaral.library_api.controller;

import com.akmaral.library_api.dto.BookCreateDTO;
import com.akmaral.library_api.dto.BookResponseDTO;
import com.akmaral.library_api.model.Book;
import com.akmaral.library_api.patterns.BookBuilder;
import com.akmaral.library_api.service.BookService;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @PostMapping
    public BookResponseDTO create(@RequestBody BookCreateDTO dto) {

        Book book = BookBuilder.builder(dto.type)
                .name(dto.name)
                .available(true)
                .build();

        Book saved = service.create(
                book,
                dto.type,
                dto.authorId,
                dto.categoryId
        );

        return new BookResponseDTO(
                saved.getId(),
                saved.getName(),
                saved.isAvailable()
        );
    }

    @GetMapping
    public List<BookResponseDTO> getAll() {
        return service.getAll().stream()
                .map(b -> new BookResponseDTO(
                        b.getId(),
                        b.getName(),
                        b.isAvailable()
                ))
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id,
                       @RequestParam boolean available) {
        service.updateAvailability(id, available);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}
