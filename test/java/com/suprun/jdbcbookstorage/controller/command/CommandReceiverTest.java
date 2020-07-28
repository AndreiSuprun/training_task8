package com.suprun.jdbcbookstorage.controller.command;

import com.suprun.jdbcbookstorage.controller.command.impl.*;
import com.suprun.jdbcbookstorage.model.converter.BookConverter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;

public class CommandReceiverTest {

    private CommandReceiver commandReceiver;

    @BeforeClass
    public void beforeClass() {
        commandReceiver = new CommandReceiver();
    }

    @Test
    public void testReceiveFinAllCommand() {
        Map<String, String> request = new HashMap<>(){{
            put("request_type", "find_all"); }};
        Command command = commandReceiver.receiveCommand(request);
        assertTrue(command instanceof FindAllCommand);
    }

    @Test
    public void testReceiveAddBookCommand() {
        Map<String, String> request = new HashMap<>() {{
            put("request_type", "add_book");
            put("name", "Head First Design Pattern");
            put("authors", "Sierra Kathy, Bates Bert, Freeman Eric, Robson Elisabeth");
            put("publisher", "O Reilly Media");
            put("publish_year", "2004");
            put("page_quantity", "694");
        }};
        Command command = commandReceiver.receiveCommand(request);
        assertTrue(command instanceof AddBookCommand);
    }

    @Test
    public void testReceiveRemoveBookCommand() {
        Map<String, String> request = new HashMap<>() {{
            put("request_type", "remove_book");
            put("name", "Head First Design Pattern");
            put("authors", "Sierra Kathy, Bates Bert, Freeman Eric, Robson Elisabeth");
            put("publisher", "O Reilly Media");
            put("publish_year", "2004");
            put("page_quantity", "694");
        }};
        Command command = commandReceiver.receiveCommand(request);
        assertTrue(command instanceof RemoveBookCommand);
    }

    @Test
    public void testReceiveFindByTagCommand() {
        Map<String, String> request = new HashMap<>() {{
            put("request_type", "find_by_tag");
            put("tag", "id");
            put("value", "2");}};
        Command command = commandReceiver.receiveCommand(request);
        assertTrue(command instanceof FindByTagCommand);
    }

    @Test
    public void testReceiveSortByTagCommand() {
        Map<String, String> request = new HashMap<>() {{
            put("request_type", "sort_by_tag");
            put("tag", "id");
            put("value", "asc");}};
        Command command = commandReceiver.receiveCommand(request);
        assertTrue(command instanceof SortByTagCommand);
    }
}


