package com.suprun.jdbcbookstorage.controller.command;

import com.suprun.jdbcbookstorage.controller.command.impl.*;

public enum RequestType {
    ADD_BOOK(new AddBookCommand()), REMOVE_BOOK(new RemoveBookCommand()), FIND_BY_TAG(new FindByTagCommand()),
    SORT_BY_TAG(new SortByTagCommand()), FIND_ALL(new FindAllCommand());
    private final Command request;
    RequestType(Command request) {
        this.request = request;
    }
    public Command getCommand(){
        return  request;
    }
}
