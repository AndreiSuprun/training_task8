package com.suprun.jdbcbookstorage.model.validator;

import com.suprun.jdbcbookstorage.controller.command.impl.SortByTagCommand;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BookValidatorTest {

    private BookValidator bookValidator;

    @BeforeClass
    public void beforeClass() {
        bookValidator = new BookValidator();
    }

    @Test
    public void testValidateSortOrderTrue() {
        String input = "asc";
        boolean isValid = bookValidator.validateSortOrder(input);
        assertTrue(isValid);
    }

    @Test
    public void testValidateSortOrderFalse() {
        String input = "wert";
        boolean isValid = bookValidator.validateSortOrder(input);
        assertFalse(isValid);
    }

    @Test
    public void testValidateTagTrue() {
        String input = "name";
        boolean isValid = bookValidator.validateSortOrder(input);
        assertTrue(isValid);
    }

    @Test
    public void testValidateTagFalse() {
        String input = "kind";
        boolean isValid = bookValidator.validateSortOrder(input);
        assertFalse(isValid);
    }

    @Test
    public void testValidateString() {
        String input = "Alice";
        String expectedInput = "Alice";
        String validatedInput = bookValidator.validateString(input);
        assertEquals(validatedInput, expectedInput);
    }

    @Test
    public void testValidateStringNull() {
        String input = null;
        String expectedInput = "";
        String validatedInput = bookValidator.validateString(input);
        assertEquals(validatedInput, expectedInput);
    }

    @Test
    public void testValidateInt() {
        String input = "100";
        int expectedInput = 100;
        int validatedInput = bookValidator.validateInt(input);
        assertEquals(validatedInput, expectedInput);
    }

    @Test
    public void testValidateIntParse() {
        String input = "abc";
        int expectedInput = 0;
        int validatedInput = bookValidator.validateInt(input);
        assertEquals(validatedInput, expectedInput);
    }
}