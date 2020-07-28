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

public class EmptyCommandTest {

    EmptyCommand emptyCommand;

    @BeforeClass
    public void beforeClass() {
        emptyCommand = new EmptyCommand();
    }

    @DataProvider
    public static Object[][] executeEmpty() {
        return new Object[][]{{new HashMap<String, String>() {{
            put("request_type", "werqeqweq");
        }}, new HashMap<String, Object>()}};
    }

    @Test(dataProvider = "executeEmpty")
    public void testExecuteEmpty(Map<String, String> request, Map<String, Object> expectedResult) {
        Map<String, Object> actual = emptyCommand.execute(request);
        assertEquals(actual, expectedResult);
    }
}