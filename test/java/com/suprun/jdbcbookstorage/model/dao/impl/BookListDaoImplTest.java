package com.suprun.jdbcbookstorage.model.dao.impl;

import com.suprun.jdbcbookstorage.model.entity.Book;
import com.suprun.jdbcbookstorage.model.exception.BookDaoException;
import com.suprun.jdbcbookstorage.model.exception.BookServiceException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;

import static org.testng.Assert.assertEquals;

public class BookListDaoImplTest {

    BookListDaoImpl bookListDao;

    @BeforeClass
    public void beforeClass() {
        bookListDao = new BookListDaoImpl();
    }

    @DataProvider
    public static Object[][] findAll() {
        return new Object[][]{{new ArrayList<Book>() {{
                add(new Book(1, "Head First Java", new ArrayList<>(Arrays.asList("Sierra Kathy", "Bates Bert")),
                        "O Reilly Media", 2005, 688));
                add(new Book(2, "Java Concurrency in Practice", new ArrayList<>(Arrays.asList("Goetz Brian")),
                        "Addison-Wesley Professional", 2006, 424));
                add(new Book(3, "Effective Java", new ArrayList<>(Arrays.asList("Bloch Joshua")),
                        "Addison-Wesley Professional", 2017, 412));
                add(new Book(4, "Java: The Complete Reference", new ArrayList<>(Arrays.asList("Schildt Herbert")),
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
                add(new Book(11, "Head First Design Patterns",
                        new ArrayList<String>(Arrays.asList("Sierra Kathy", "Bates Bert", "Freeman Eric", "Robson Elisabeth")),
                        "O Reilly Media", 2004, 694));
        }}}};
    }

    @Test(dataProvider = "findAll")
    public void testFindAll(List<Book> expectedResult)
            throws BookDaoException {
        List<Book> actual = bookListDao.findAll();
        assertEquals(actual, expectedResult);
    }

    @DataProvider
    public static Object[][] addBookNotContain() {
        return new Object[][]{{new Book("Head First Design Patterns",
                new ArrayList<>(Arrays.asList("Sierra Kathy", "Bates Bert", "Freeman Eric", "Robson Elisabeth")),
                "O Reilly Media", 2004, 694),
                new ArrayList<>() {{
                    add(new Book(1, "Head First Java", new ArrayList<>(Arrays.asList("Sierra Kathy", "Bates Bert")),
                            "O Reilly Media", 2005, 688));
                    add(new Book(2, "Java Concurrency in Practice", new ArrayList<>(Arrays.asList("Goetz Brian")),
                            "Addison-Wesley Professional", 2006, 424));
                    add(new Book(3, "Effective Java", new ArrayList<>(Arrays.asList("Bloch Joshua")),
                            "Addison-Wesley Professional", 2017, 412));
                    add(new Book(4, "Java: The Complete Reference", new ArrayList<>(Arrays.asList("Schildt Herbert")),
                            "McGraw-Hill Education", 2018, 1248));
                    add(new Book(5, "Clean Code: A Handbook of Agile Software Craftsmanship",
                            new ArrayList<>(Arrays.asList("Martin Robert C.")), "Pearson", 2008, 464));
                    add(new Book(6, "Java Generics and Collections",
                            new ArrayList<>(Arrays.asList("Naftalin Maurice", "Wadler Philip")), "O Reilly Media",
                            2006, 273));
                    add(new Book(7, "Design Patterns: Elements of Reusable Object-Oriented Software",
                            new ArrayList<>(Arrays.asList("Gamma Erich", "Helm Richard", "Johnson Ralph", "Vlissides John")), "O Reilly Media",
                            1994, 416));
                    add(new Book(8, "Mastering Lambdas: Java Programming in a Multicore World",
                            new ArrayList<>(Arrays.asList("Naftalin Maurice")), "Pearson", 2014, 208));
                    add(new Book(9, "Grokking Algorithms: An illustrated guide for programmers and other curious people",
                            new ArrayList<>(Arrays.asList("Bhargava Aditya")), "Manning Publications", 2016, 256));
                    add(new Book(10, "Soft Skills: The software developer's life manual",
                            new ArrayList<>(Arrays.asList("Sonmez John")), "Manning Publications", 2015, 504));
                    add(new Book(11, "Head First Design Patterns",
                            new ArrayList<>(Arrays.asList("Sierra Kathy", "Bates Bert", "Freeman Eric", "Robson Elisabeth")),
                            "O Reilly Media", 2004, 694));
                }}}};
    }

    @Test(dataProvider = "addBookNotContain")
    public void testAddBookNotContain(Book book, List<Book> expectedResult) throws BookDaoException {
        List<Book> actual = bookListDao.addBook(book);
        assertEquals(actual, expectedResult);
    }

    @Test(expectedExceptions = BookDaoException.class)
    public void testAddBookContain() throws BookDaoException {
        Book book = new Book("Head First Java", new ArrayList<String>(Arrays.asList("Sierra Kathy", "Bates Bert")),
                "O Reilly Media", 2005, 688);
        List<Book> actual = bookListDao.addBook(book);
    }

    @DataProvider
    public static Object[][] removeBookContain() {
        return new Object[][]{{new Book("Head First Java", new ArrayList<String>(Arrays.asList("Sierra Kathy", "Bates Bert")),
                "O Reilly Media", 2005, 688),
        new ArrayList<>() {{
            add(new Book(1, "Head First Java", new ArrayList<>(Arrays.asList("Sierra Kathy", "Bates Bert")),
                    "O Reilly Media", 2005, 688));
            add(new Book(2, "Java Concurrency in Practice", new ArrayList<>(Arrays.asList("Goetz Brian")),
                    "Addison-Wesley Professional", 2006, 424));
            add(new Book(3, "Effective Java", new ArrayList<>(Arrays.asList("Bloch Joshua")),
                    "Addison-Wesley Professional", 2017, 412));
            add(new Book(4, "Java: The Complete Reference", new ArrayList<>(Arrays.asList("Schildt Herbert")),
                    "McGraw-Hill Education", 2018, 1248));
            add(new Book(5, "Clean Code: A Handbook of Agile Software Craftsmanship",
                    new ArrayList<>(Arrays.asList("Martin Robert C.")), "Pearson", 2008, 464));
            add(new Book(6, "Java Generics and Collections",
                    new ArrayList<>(Arrays.asList("Naftalin Maurice", "Wadler Philip")), "O Reilly Media",
                    2006, 273));
            add(new Book(7, "Design Patterns: Elements of Reusable Object-Oriented Software",
                    new ArrayList<>(Arrays.asList("Gamma Erich", "Helm Richard", "Johnson Ralph", "Vlissides John")), "O Reilly Media",
                    1994, 416));
            add(new Book(8, "Mastering Lambdas: Java Programming in a Multicore World",
                    new ArrayList<>(Arrays.asList("Naftalin Maurice")), "Pearson", 2014, 208));
            add(new Book(9, "Grokking Algorithms: An illustrated guide for programmers and other curious people",
                    new ArrayList<>(Arrays.asList("Bhargava Aditya")), "Manning Publications", 2016, 256));
            add(new Book(10, "Soft Skills: The software developer's life manual",
                    new ArrayList<>(Arrays.asList("Sonmez John")), "Manning Publications", 2015, 504));
            add(new Book(11, "Head First Design Patterns",
                    new ArrayList<>(Arrays.asList("Sierra Kathy", "Bates Bert", "Freeman Eric", "Robson Elisabeth")),
                    "O Reilly Media", 2004, 694));
        }}}};
    }

    @Test(dataProvider = "removeBookContain")
    public void testRemoveBookContain(Book book, List<Book> expectedResult) throws BookDaoException {
        List<Book> actual = bookListDao.removeBook(book);
        assertEquals(actual, expectedResult);
    }

    @Test(expectedExceptions = BookDaoException.class)
    public void testRemoveBookNotContain() throws BookDaoException {
        Book book = new Book("Head First Design Patterns",
                new ArrayList<String>(Arrays.asList("Sierra Kathy", "Bates Bert", "Freeman Eric", "Robson Elisabeth")),
                "O Reilly Media", 2004, 694);
        List<Book> actual = bookListDao.removeBook(book);
    }

    @DataProvider
    public static Object[][] testFindByTag() {
        return new Object[][]{{"name", "Concurrency", new ArrayList<Book>() {{ add(new Book(2,
                        "Java Concurrency in Practice", new ArrayList<String>(Arrays.asList("Goetz Brian")),
                        "Addison-Wesley Professional", 2006, 424));
            }}}};
    }

    @Test(dataProvider = "testFindByTag")
    public void testFindByTag(String tag, String value, List<Book> expectedResult) throws BookDaoException {
        List<Book> actual = bookListDao.findByTag(tag, value);
        assertEquals(actual, expectedResult);
    }

    @DataProvider
    public static Object[][] testSortByTag() {
        return new Object[][]{{"id", "asc", new ArrayList<Book>() {{
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
            }}}, {"name", "asc", new ArrayList<Book>() {{
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
           }}}};
        }

    @Test(dataProvider = ("testSortByTag"))
    public void testSortByTag(String tag, String sortOrder, List<Book> expectedResult)
            throws BookDaoException {
        List<Book> actual = bookListDao.sortByTag(tag, sortOrder);
        assertEquals(actual, expectedResult);
    }
}