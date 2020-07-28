package com.suprun.jdbcbookstorage.model.converter;

import com.suprun.jdbcbookstorage.model.entity.Book;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.*;

public class BookConverterTest {

    private BookConverter bookConverter;

    @BeforeClass
    public void beforeClass() {
        bookConverter = new BookConverter();
    }

    @Test
    public void testReceiveBook() {
        Map<String, String> request = new HashMap<>() {{
            put("request_type", "add_book");
            put("name", "Head First Design Pattern");
            put("authors", "Sierra Kathy, Bates Bert, Freeman Eric, Robson Elisabeth");
            put("publisher", "O Reilly Media");
            put("publish_year", "2004");
            put("page_quantity", "694");
        }};
        Book actual = bookConverter.receiveBook(request);
        Book expectedBook = new Book("Head First Design Patterns", new ArrayList<String>(Arrays.asList("Sierra Kathy", "Bates Bert", "Freeman Eric", "Robson Elisabeth")),
                "O Reilly Media", 2004, 694);
    }
}