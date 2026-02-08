package com.akmaral.library_api.model;

import  com.akmaral.library_api.exception.InvalidInputException;

public class Author extends BaseEntity{
    public Author(int id, String name) {
        super(id,name);
    }

    public void validate() {
        if (name == null) {
            throw new InvalidInputException("Author name cannot be empty");
        }
    }

    public void printInfo() {
        System.out.println("Author: " + name);

    }
}
