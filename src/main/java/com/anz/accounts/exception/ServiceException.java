package com.anz.accounts.exception;

public class ServiceException extends Exception {

    public ServiceException(String message)
    {
        // Call constructor of parent Exception
        super(message);
    }

    public ServiceException(String message, Throwable throwable)
    {
        super(message, throwable);
    }

}
