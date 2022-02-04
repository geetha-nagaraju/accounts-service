package com.anz.accounts.exception;

public class BadRequestException extends RuntimeException {

    public BadRequestException(String message) {
        // Call constructor of parent Exception
        super(message);
    }

    public BadRequestException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
