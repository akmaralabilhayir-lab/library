package com.akmaral.library_api.model;

public abstract class BaseEntity {

    protected int id;
    protected String name;

    protected BaseEntity() {}

    protected BaseEntity(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void validate();
    public abstract void printInfo();

    public String getSummary() {
        return "ID: " + id + ", Name: " + name;
    }
}
