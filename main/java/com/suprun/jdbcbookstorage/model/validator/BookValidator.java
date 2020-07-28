package com.suprun.jdbcbookstorage.model.validator;

import com.suprun.jdbcbookstorage.model.parameter.BookStorageParameters;

public class BookValidator {

    private static  final String EMPTY_STRING = "";

    public boolean validateSortOrder(String input) {
        if (input == null || input.trim().isEmpty()){
            return false;
        }
        return input.equalsIgnoreCase(BookStorageParameters.SORT_ORDER_ASCENDING) ||
                input.equalsIgnoreCase(BookStorageParameters.SORT_ORDER_DESCENDING);
    }

    public boolean validateTag(String input) {
        if (input == null || input.trim().isEmpty()){
            return false;
        }
        for (BookStorageParameters.Tags tag : BookStorageParameters.Tags.values()){
            if (tag.getTag().equalsIgnoreCase(input)){
                return true;
            }
        }
        return false;
    }

    public String validateString(String input) {
        if (input == null || input.trim().isEmpty()){
            return EMPTY_STRING;
        }
        return input;
    }

    public int validateInt(String input) {
        if (input == null){
            return 0;
        }
        int value;
        try {
            value = Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            value = 0;
        }
        return value;
    }
}