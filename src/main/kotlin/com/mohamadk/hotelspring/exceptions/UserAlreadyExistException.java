package com.mohamadk.hotelspring.exceptions;

public class UserAlreadyExistException extends RuntimeException {
    public UserAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }
}
