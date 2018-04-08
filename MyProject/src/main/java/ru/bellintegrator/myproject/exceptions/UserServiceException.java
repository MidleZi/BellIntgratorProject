package ru.bellintegrator.myproject.exceptions;

public class UserServiceException extends  RuntimeException{

    public UserServiceException(String message) {
        super(message);
    }
}
