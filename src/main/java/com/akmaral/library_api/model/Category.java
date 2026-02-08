package com.akmaral.library_api.model;
import  com.akmaral.library_api.exception.InvalidInputException;

public class Category extends BaseEntity {
    public Category(int id, String name) {
        super(id, name);
    }

    public void validate() {
        if(name == null) {
            throw new InvalidInputException("Category name cannot be empty");
        }
    }

    public void printInfo() {
        System.out.println("Category: " + name);
    }
}
