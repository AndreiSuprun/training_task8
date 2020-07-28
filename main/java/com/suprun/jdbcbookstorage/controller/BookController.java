package com.suprun.jdbcbookstorage.controller;

import com.suprun.jdbcbookstorage.controller.command.Command;
import com.suprun.jdbcbookstorage.controller.command.CommandReceiver;


import java.util.Map;

public class BookController {

    private static BookController instance;

    private BookController(){};

    public static BookController getInstance(){
        if (instance == null){
            instance = new BookController();
        }
        return instance;
    }

     public Map<String, Object> processRequest(Map<String, String> request){
         CommandReceiver commandReceiver = new CommandReceiver();
         Command command = commandReceiver.receiveCommand(request);
         Map<String, Object> response = command.execute(request);
         return response;
    }
}
