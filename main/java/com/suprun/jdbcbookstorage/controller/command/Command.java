package com.suprun.jdbcbookstorage.controller.command;

import java.util.Map;

public interface Command {

    String EXCEPTION_ATTRIBUTE = "exception";

    Map<String, Object> execute(Map<String, String> request);
}
