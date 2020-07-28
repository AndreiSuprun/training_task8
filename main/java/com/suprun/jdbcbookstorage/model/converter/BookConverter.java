package com.suprun.jdbcbookstorage.model.converter;

import com.suprun.jdbcbookstorage.model.entity.Book;
import com.suprun.jdbcbookstorage.model.parameter.BookStorageParameters;
import com.suprun.jdbcbookstorage.model.validator.BookValidator;

import java.util.List;
import java.util.Map;

public class BookConverter {

    private static final String DELIMITER_SELECTOR = ",\\s+";

    public Book receiveBook(Map<String, String> request) {
        BookValidator validator = new BookValidator();
        String name = validator.validateString(request.get(BookStorageParameters.Tags.NAME.getTag()));
        List<String> authors = List.of(request.get(BookStorageParameters.Tags.AUTHORS.getTag()).split(DELIMITER_SELECTOR));
        String publisher = validator.validateString(request.get(BookStorageParameters.Tags.PUBLISHER.getTag()));
        int publishYear = validator.validateInt(request.get(BookStorageParameters.Tags.PUBLISH_YEAR.getTag()));
        int pageQuantity = validator.validateInt(request.get(BookStorageParameters.Tags.PAGE_QUANTITY.getTag()));
        Book book = new Book(name, authors, publisher, publishYear, pageQuantity);
        return book;
    }
}
