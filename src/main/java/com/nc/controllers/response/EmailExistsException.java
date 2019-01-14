package com.nc.controllers.response;

public class EmailExistsException extends Exception {

    public EmailExistsException(String message)
    {
        super(message);
    }
}