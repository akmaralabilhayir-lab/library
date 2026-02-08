CREATE TABLE authors (
                         id SERIAL PRIMARY KEY,
                         name VARCHAR(100) NOT NULL
);

CREATE TABLE categories (
                            id SERIAL PRIMARY KEY,
                            name VARCHAR(100) NOT NULL
);

CREATE TABLE books (
                       id SERIAL PRIMARY KEY,
                       name VARCHAR(150) NOT NULL,
                       book_type VARCHAR(20) NOT NULL,
                       available BOOLEAN NOT NULL,
                       author_id INT NOT NULL,
                       category_id INT NOT NULL,
                       CONSTRAINT fk_author
                           FOREIGN KEY (author_id) REFERENCES authors(id),
                       CONSTRAINT fk_category
                           FOREIGN KEY (category_id) REFERENCES categories(id)
);
