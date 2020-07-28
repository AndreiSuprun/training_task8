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

public class FindByTagCommandTest {

    private FindByTagCommand findByTagCommand;

    @BeforeClass
    public void beforeClass() {
        findByTagCommand = new FindByTagCommand();
    }

    @DataProvider
    public static Object[][] executeFindByTag() {
        return new Object[][]{{new HashMap<String, String>() {{
            put("request_type", "find_by_tag");
            put("tag", "id");
            put("value", "2");
        }}, new HashMap<String, Object>() {{
            put("books", new ArrayList<>() {{
                add(new Book(2,
                        "Java Concurrency in Practice", new ArrayList<String>(Arrays.asList("Goetz Brian")),
                        "Addison-Wesley Professional", 2006, 424));
            }});
        }}}};
    }

    @Test(dataProvider = "executeFindByTag")
    public void testExecuteFindByTag(Map<String, String> request, Map<String, Object> expectedResult) {
        Map<String, Object> actual = findByTagCommand.execute(request);
        assertEquals(actual, expectedResult);
    }
}