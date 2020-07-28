package com.suprun.jdbcbookstorage.model.exception;

public class BookServiceException extends Exception{
    public BookServiceException() {
        super();
    }

    public BookServiceException(String message) {
        super(message);
    }

    public BookServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookServiceException(Throwable cause) {
        super(cause);
    }
}
