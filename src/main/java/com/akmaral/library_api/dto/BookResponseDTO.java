package com.akmaral.library_api.dto;

public class BookResponseDTO {
    private int id;
    private String name;
    private boolean available;

    public BookResponseDTO() {
    }

    public BookResponseDTO(int id, String name, boolean available) {
        this.id = id;
        this.name = name;
        this.available = available;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isAvailable() {
        return available;
    }
}
