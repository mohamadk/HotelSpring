package com.mohamadk.hotelspring.controller;

public class UserAlreadyExistException extends RuntimeException {
    public UserAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }
}
