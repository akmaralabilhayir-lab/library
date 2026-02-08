package com.akmaral.library_api.dto;

public class CategoryResponseDTO {
    private int id;
    private String name;

    public CategoryResponseDTO() {
    }

    public CategoryResponseDTO(int id, String name) {
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
