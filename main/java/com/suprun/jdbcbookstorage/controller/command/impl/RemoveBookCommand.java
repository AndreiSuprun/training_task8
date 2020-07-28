package com.suprun.jdbcbookstorage.controller.command.impl;

import com.suprun.jdbcbookstorage.controller.command.Command;
import com.suprun.jdbcbookstorage.model.exception.BookServiceException;
import com.suprun.jdbcbookstorage.model.service.BookStorageService;

import java.util.HashMap;
import java.util.Map;

public class RemoveBookCommand implements Command {

    BookStorageService bookStorageService = new BookStorageService();

    public Map<String, Object> execute(Map<String, String> request){
        Map<String, Object> response = new HashMap<>();
        try{
            response = bookStorageService.removeBook(request);
        } catch (BookServiceException e) {
            response.put(Command.EXCEPTION_ATTRIBUTE, e.getMessage());
        }
        return response;
    }
}
