package anz.com.org.accounts.exception;

public class BadRequestException extends Exception {

    public BadRequestException(String message)
    {
        // Call constructor of parent Exception
        super(message);
    }

    public BadRequestException(String message, Throwable throwable)
    {
        super(message, throwable);
    }
}
