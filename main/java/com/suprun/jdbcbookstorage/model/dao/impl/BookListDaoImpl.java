package com.suprun.jdbcbookstorage.model.dao.impl;

import com.suprun.jdbcbookstorage.model.connection.ConnectionPool;
import com.suprun.jdbcbookstorage.model.dao.BookListDao;
import com.suprun.jdbcbookstorage.model.entity.Book;
import com.suprun.jdbcbookstorage.model.exception.BookDaoException;
import com.suprun.jdbcbookstorage.model.parameter.BookStorageParameters;

import java.sql.*;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

public class BookListDaoImpl implements BookListDao {

    private static final String SQL_FIND_ALL = "Select id, name, authors, publisher, publish_year, page_quantity FROM bookstorage.book";
    private static final String SQL_ADD_BOOK = "INSERT INTO bookstorage.book (name, authors, publisher, publish_year, page_quantity) " +
            "VALUES (?, ?, ?, ?, ?) ON CONFLICT (name, authors) DO NOTHING";
    private static final String SQL_REMOVE_BOOK = "DELETE FROM bookstorage.book WHERE name = ? AND authors = ? AND publisher = ? AND publish_year = ? " +
            "AND page_quantity = ?";
    private static final String SQL_FIND_BY_TAG = "SELECT id, name, authors, publisher, publish_year, page_quantity FROM bookstorage.book WHERE ";
    private static final String SQL_SORT_BY_TAG = "SELECT id, name, authors, publisher, publish_year, page_quantity FROM bookstorage.book ORDER BY ";
    private static final String SQL_QUERY_PART_LIKE = "::varchar like '%";
    private static final String SQL_QUERY_PART_LIKE_END = "%'";
    private static final String SQL_QUERY_PART_EQUALS = " = ";
    private static final String SQL_QUERY_EMPTY_STRING = "";

    public List<Book> findAll() throws BookDaoException {
        List<Book> books;
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             ResultSet resultSet = connection.createStatement().executeQuery(SQL_FIND_ALL)) {
            books = receiveBooks(resultSet);
        } catch (SQLException e) {
            throw new BookDaoException(e.getMessage(), e);
        }
        return books;
    }

    @Override
    public List<Book> addBook(Book book) throws BookDaoException {
        int count = 0;
        List<Book> books;
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_ADD_BOOK)) {
            setStatementParameter(connection, statement, book);
            count = statement.executeUpdate();
            if (count == 0) {
                throw new BookDaoException("Book is already in storage");
            }
            return books = findAll();
        } catch (SQLException e) {
            throw new BookDaoException(e.getMessage(), e);
        }
    }

    @Override
    public List<Book> removeBook(Book book) throws BookDaoException {
        int count = 0;
        List<Book> books;
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_REMOVE_BOOK);) {
            setStatementParameter(connection, statement, book);
            count = statement.executeUpdate();
            if (count == 0) {
                throw new BookDaoException("Book is not in storage");
            }
            return books = findAll();
        } catch (SQLException e) {
            throw new BookDaoException(e.getMessage());
        }
    }

    @Override
    public List<Book> findByTag(String tag, String value) throws BookDaoException {
        String sqlQuery = getFindQuery(tag, value);
        return getBooks(sqlQuery);
    }

    @Override
    public List<Book> sortByTag(String tag, String sortOrder) throws BookDaoException {
        String sqlQuery = getSortQuery(tag, sortOrder);
        return getBooks(sqlQuery);
    }

    private List<Book> getBooks(String sqlQuery) throws BookDaoException {
        List<Book> books;
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             ResultSet resultSet = connection.createStatement().executeQuery(sqlQuery)) {
            books = receiveBooks(resultSet);
        } catch (SQLException e) {
            throw new BookDaoException(e.getMessage(), e);
        }
        return books;
    }

    private String getFindQuery(String tag, String value) {
        switch (BookStorageParameters.Tags.valueOf(tag.toUpperCase().trim())) {
            case NAME:
            case AUTHORS:
            case PUBLISHER: {
                return SQL_FIND_BY_TAG + tag + SQL_QUERY_PART_LIKE + value + SQL_QUERY_PART_LIKE_END;
            }
            default:
                return SQL_FIND_BY_TAG + tag + SQL_QUERY_PART_EQUALS + value;
        }
    }

    private String getSortQuery(String tag, String value) {
        return SQL_SORT_BY_TAG + tag + SQL_QUERY_EMPTY_STRING + value;
    }

    private List<Book> receiveBooks(ResultSet resultSet) throws SQLException {
        List<Book> books = new ArrayList<>();
        Book book;
        while (resultSet.next()) {
            book = new Book(resultSet.getInt(1), resultSet.getString(2), List.of((String[]) resultSet.getArray(3).getArray()),
                    resultSet.getString(4), resultSet.getInt(5), resultSet.getInt(6));
            books.add(book);
        }
        return books;
    }

    private void setStatementParameter(Connection connection, PreparedStatement statement, Book book) throws SQLException {
        statement.setString(1, book.getName());
        statement.setArray(2, connection.createArrayOf("varchar", book.getAuthors().toArray()));
        statement.setString(3, book.getPublisher());
        statement.setInt(4, book.getPublishYear());
        statement.setInt(5, book.getPageQuantity());
    }
}
