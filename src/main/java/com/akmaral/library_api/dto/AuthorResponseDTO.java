package com.akmaral.library_api.dto;

public class AuthorResponseDTO {
    private int id;
    private String name;

    public AuthorResponseDTO() {
    }
    public AuthorResponseDTO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
