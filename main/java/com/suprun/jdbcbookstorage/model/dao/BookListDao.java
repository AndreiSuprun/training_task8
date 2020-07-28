package com.suprun.jdbcbookstorage.model.dao;

import com.suprun.jdbcbookstorage.model.entity.Book;
import com.suprun.jdbcbookstorage.model.exception.BookDaoException;

import java.sql.SQLException;
import java.util.List;

public interface BookListDao {

    List<Book> findAll() throws BookDaoException;

    List<Book> addBook(Book book) throws BookDaoException;

    List<Book> removeBook(Book book) throws BookDaoException;

    List<Book> findByTag(String tag, String value) throws BookDaoException;

    List<Book> sortByTag(String tag, String sortOrder) throws BookDaoException;
}

