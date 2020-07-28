package com.suprun.jdbcbookstorage.controller.command.impl;

import com.suprun.jdbcbookstorage.model.entity.Book;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;

public class SortByTagCommandTest {

    private SortByTagCommand sortByTagCommand;

    @BeforeClass
    public void beforeClass() {
        sortByTagCommand = new SortByTagCommand();
    }

    @DataProvider
    public static Object[][] executeSortByTag() {
        return new Object[][]{{new HashMap<String, String>() {{
            put("request_type", "sort_by_tag");
            put("tag", "id");
            put("value", "asc");
        }}, new HashMap<String, Object>() {{
            put("books", new ArrayList<>() {{
                add(new Book(1, "Head First Java", new ArrayList<String>(Arrays.asList("Sierra Kathy", "Bates Bert")),
                        "O Reilly Media", 2005, 688));
                add(new Book(2, "Java Concurrency in Practice", new ArrayList<String>(Arrays.asList("Goetz Brian")),
                        "Addison-Wesley Professional", 2006, 424));
                add(new Book(3, "Effective Java", new ArrayList<String>(Arrays.asList("Bloch Joshua")),
                        "Addison-Wesley Professional", 2017, 412));
                add(new Book(4, "Java: The Complete Reference", new ArrayList<String>(Arrays.asList("Schildt Herbert")),
                        "McGraw-Hill Education", 2018, 1248));
                add(new Book(5, "Clean Code: A Handbook of Agile Software Craftsmanship",
                        new ArrayList<String>(Arrays.asList("Martin Robert C.")), "Pearson", 2008, 464));
                add(new Book(6, "Java Generics and Collections",
                        new ArrayList<String>(Arrays.asList("Naftalin Maurice", "Wadler Philip")), "O Reilly Media",
                        2006, 273));
                add(new Book(7, "Design Patterns: Elements of Reusable Object-Oriented Software",
                        new ArrayList<String>(Arrays.asList("Gamma Erich", "Helm Richard", "Johnson Ralph", "Vlissides John")), "O Reilly Media",
                        1994, 416));
                add(new Book(8, "Mastering Lambdas: Java Programming in a Multicore World",
                        new ArrayList<String>(Arrays.asList("Naftalin Maurice")), "Pearson", 2014, 208));
                add(new Book(9, "Grokking Algorithms: An illustrated guide for programmers and other curious people",
                        new ArrayList<String>(Arrays.asList("Bhargava Aditya")), "Manning Publications", 2016, 256));
                add(new Book(10, "Soft Skills: The software developers life manual",
                        new ArrayList<String>(Arrays.asList("Sonmez John")), "Manning Publications", 2015, 504));
            }});
        }}}, {new HashMap<String, String>() {{
            put("request_type", "sort_by_tag");
            put("tag", "name");
            put("value", "asc");
        }}, new HashMap<String, Object>() {{
            put("books", new ArrayList<>() {{
                add(new Book(5, "Clean Code: A Handbook of Agile Software Craftsmanship",
                        new ArrayList<String>(Arrays.asList("Martin Robert C.")), "Pearson", 2008, 464));
                add(new Book(7, "Design Patterns: Elements of Reusable Object-Oriented Software",
                        new ArrayList<String>(Arrays.asList("Gamma Erich", "Helm Richard", "Johnson Ralph", "Vlissides John")), "O Reilly Media",
                        1994, 416));
                add(new Book(3, "Effective Java", new ArrayList<String>(Arrays.asList("Bloch Joshua")),
                        "Addison-Wesley Professional", 2017, 412));
                add(new Book(9, "Grokking Algorithms: An illustrated guide for programmers and other curious people",
                        new ArrayList<String>(Arrays.asList("Bhargava Aditya")), "Manning Publications", 2016, 256));
                add(new Book(1, "Head First Java", new ArrayList<String>(Arrays.asList("Sierra Kathy", "Bates Bert")),
                        "O Reilly Media", 2005, 688));
                add(new Book(2, "Java Concurrency in Practice", new ArrayList<String>(Arrays.asList("Goetz Brian")),
                        "Addison-Wesley Professional", 2006, 424));
                add(new Book(6, "Java Generics and Collections",
                        new ArrayList<String>(Arrays.asList("Naftalin Maurice", "Wadler Philip")), "O Reilly Media",
                        2006, 273));
                add(new Book(4, "Java: The Complete Reference", new ArrayList<String>(Arrays.asList("Schildt Herbert")),
                        "McGraw-Hill Education", 2018, 1248));
                add(new Book(8, "Mastering Lambdas: Java Programming in a Multicore World",
                        new ArrayList<String>(Arrays.asList("Naftalin Maurice")), "Pearson", 2014, 208));
                add(new Book(10, "Soft Skills: The software developers life manual",
                        new ArrayList<String>(Arrays.asList("Sonmez John")), "Manning Publications", 2015, 504));
            }});
        }}}};
    }

    @Test(dataProvider = "executeSortByTag")
    public void testExecuteSortByTag(Map<String, String> request, Map<String, Object> expectedResult) {
        Map<String, Object> actual = sortByTagCommand.execute(request);
        assertEquals(actual, expectedResult);
    }
}