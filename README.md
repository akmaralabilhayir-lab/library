A. Project Overview

This project is a Library Management System implemented as a Spring Boot RESTful API.
The system manages Books, Authors, and Categories, and demonstrates how a real backend application is structured using:

Spring Boot

RESTful API principles

JDBC with PostgreSQL

SOLID principles

Design Patterns (Singleton, Factory, Builder)

Component Principles (REP, CCP, CRP)

The project was developed as an endterm assignment to integrate Advanced OOP, Design Patterns, and REST API architecture into one working system.

B. System Architecture

The application follows a layered architecture:

Controller → Service → Repository → Database


Each layer has a clear responsibility:

Controller — handles HTTP requests and responses

Service — contains business logic

Repository — communicates with the database using JDBC

Model / DTO — represents domain objects and data transfer objects

C. Design Patterns Section

Singleton Pattern

The DatabaseConnection class is implemented as a Singleton to ensure that only one database connection instance is used across the application.

Purpose:

Resource optimization

Centralized database access

Factory Pattern

The BookFactory is used to create different book types.

Usage:

Creates PrintedBook or EBook based on input type

Avoids conditional logic inside controllers

Example:

BookFactory.create("PRINTED");

Builder Pattern

The BookBuilder is used to construct Book objects step by step.

Purpose:

Cleaner object creation

Avoids large constructors

Improves readability

D. Component Principles Section

Each component has a single clear responsibility:

Controller – handles HTTP requests and responses

Service – contains business logic

Repository – handles database operations

DTO – transfers data between client and server

Model – represents domain entities

This separation improves maintainability and testability.

E. SOLID & OOP Summary

OOP Principles Used

Encapsulation – internal logic hidden inside services

Inheritance – PrintedBook and EBook extend Book

Polymorphism – books handled via Book reference

Abstraction – common behavior defined in base classes

SOLID Principles

S (SRP): Each class has one responsibility

O (OCP): New book types can be added without modifying existing logic

L (LSP): Subclasses can replace base class references

D (DIP): Controllers depend on services, not implementations

F. Database Schema

The database uses PostgreSQL.

Tables:

authors

categories

books

Relationships:

One Author → Many Books

One Category → Many Books

Schema is defined in:

src/main/resources/schema.sql

G. System Architecture Diagram

The UML and architecture diagram is located at:

docs/uml.png


It represents:

Layered architecture

Entity relationships

Controller → Service → Repository flow

H. Instructions to Run the Spring Boot Application
1. Configure Database

Update application.properties:

spring.datasource.url=jdbc:postgresql://localhost:5435/library_db

spring.datasource.username=postgres

spring.datasource.password=123

2. Run Application
   
mvn spring-boot:run

or run LibraryApplication from IDE.

3. Test Using Postman

Use the provided endpoints to send requests.

I. Reflection Section

Through this project, I learned:

How REST APIs are structured in Spring Boot

How layered architecture improves code organization

How to apply design patterns in real projects

How to work with PostgreSQL using JDBC

How SOLID and OOP principles improve maintainability

This project helped me better understand real backend development and prepared me for larger systems.

J. Repository Structure

library_api/

├── src/main/java/

│   ├── controller/

│   ├── service/

│   ├── repository/

│   ├── model/

│   ├── dto/

│   ├── exception/

│   ├── patterns/

│   ├── utils/

│   └── Application.java

│

├── src/main/resources/

│   ├── schema.sql

│   └── application.properties

│

├── docs/

│   ├── screenshots/

│   └── uml-diagram/

│

├── README.md

└── .gitignore


