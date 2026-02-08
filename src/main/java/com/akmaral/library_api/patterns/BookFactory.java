package com.akmaral.library_api.patterns;

import com.akmaral.library_api.exception.InvalidInputException;
import com.akmaral.library_api.model.Book;
import com.akmaral.library_api.model.EBook;
import com.akmaral.library_api.model.PrintedBook;

public class BookFactory {

    public static Book create(String type) {
        return switch (type) {
            case "EBOOK" -> new EBook();
            case "PRINTED" -> new PrintedBook();
            default -> throw new InvalidInputException("Unknown book type");
        };
    }
}
