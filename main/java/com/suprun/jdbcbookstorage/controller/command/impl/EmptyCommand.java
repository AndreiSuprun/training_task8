package com.suprun.jdbcbookstorage.controller.command.impl;

import com.suprun.jdbcbookstorage.controller.command.Command;

import java.util.HashMap;
import java.util.Map;

public class EmptyCommand implements Command {

    public Map<String, Object> execute(Map<String, String> request) {
        return new HashMap<String, Object>();
    }
}
