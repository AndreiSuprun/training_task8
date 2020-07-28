package com.suprun.jdbcbookstorage.model.service;

import com.suprun.jdbcbookstorage.model.converter.BookConverter;
import com.suprun.jdbcbookstorage.model.dao.BookListDao;
import com.suprun.jdbcbookstorage.model.dao.impl.BookListDaoImpl;
import com.suprun.jdbcbookstorage.model.entity.Book;
import com.suprun.jdbcbookstorage.model.exception.BookDaoException;
import com.suprun.jdbcbookstorage.model.exception.BookServiceException;
import com.suprun.jdbcbookstorage.model.parameter.BookStorageParameters;
import com.suprun.jdbcbookstorage.model.validator.BookValidator;

import java.util.*;

public class BookStorageService {

    private BookListDao bookListDao = new BookListDaoImpl();
    private BookConverter converter = new BookConverter();
    private BookValidator validator = new BookValidator();

    public Map<String, Object> findAll() throws BookServiceException {
        List<Book> books;
        try {
            books = bookListDao.findAll();
        } catch (BookDaoException e) {
            throw new BookServiceException(e.getMessage());
        }
        Map<String, Object> response = new HashMap<String, Object>();
        response.put(BookStorageParameters.BOOKS, books);
        return response;
    }

    public Map<String, Object> addBook(Map<String, String> request) throws BookServiceException {
        Book book = converter.receiveBook(request);
        List<Book> books;
        try {
            books = bookListDao.addBook(book);
        } catch (BookDaoException e) {
            throw new BookServiceException(e.getMessage());
        }
        Map<String, Object> response = new HashMap<String, Object>();
        response.put(BookStorageParameters.BOOKS, books);
        return response;
    }

    public Map<String, Object> removeBook(Map<String, String> request) throws BookServiceException {
        Book book = converter.receiveBook(request);
        List<Book> books;
        try{
            books = bookListDao.removeBook(book);
        } catch (BookDaoException e) {
            throw new BookServiceException(e.getMessage());
        }
        Map<String, Object> response = new HashMap<String, Object>();
        response.put(BookStorageParameters.BOOKS, books);
        return response;
    }

    public Map<String, Object> findByTag(Map<String, String> params) throws BookServiceException {
        String tag = params.get(BookStorageParameters.TAG);
        String value = params.get(BookStorageParameters.VALUE);
        if (!validator.validateTag(tag) || value == null || value.trim().isEmpty()){
            throw new BookServiceException("Invalid input parameters");
        }
        List<Book> books;
        try {
            books = bookListDao.findByTag(tag, value);
        } catch (BookDaoException e) {
            throw new BookServiceException(e.getMessage());
        }
        Map<String, Object> response = new HashMap<String, Object>();
        response.put(BookStorageParameters.BOOKS, books);
        return response;
    }

    public Map<String, Object> sortByTag(Map<String, String> params) throws BookServiceException {
        String tag = params.get(BookStorageParameters.TAG);
        String sortOrder = params.get(BookStorageParameters.VALUE);
        if (!validator.validateTag(tag) || !validator.validateSortOrder(sortOrder) ){
            throw new BookServiceException("Invalid input parameters");
        }
        List<Book> books;
        try {
            books = bookListDao.sortByTag(tag, sortOrder);
        } catch (BookDaoException e) {
            throw new BookServiceException(e.getMessage());
        }
        Map<String, Object> response = new HashMap<String, Object>();
        response.put(BookStorageParameters.BOOKS, books);
        return response;
    }
}
