package com.suprun.jdbcbookstorage.controller.command;

import com.suprun.jdbcbookstorage.controller.command.impl.EmptyCommand;

import java.util.Map;

public class CommandReceiver {

    private static final String REQUEST_TYPE = "request_type";

    public Command receiveCommand(Map<String, String> request){
        Command command;
        try {
            String requestTypeValue = request.get(REQUEST_TYPE);
            RequestType requestType = RequestType.valueOf(requestTypeValue.toUpperCase());
            command = requestType.getCommand();
        } catch (IllegalArgumentException e) {
            command = new EmptyCommand();
        }
        return command;
    }
}
