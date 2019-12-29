package com.epam.task.exception;

public class InvalidExpressionTextException extends Exception {
    public InvalidExpressionTextException() {
        super();
    }

    public InvalidExpressionTextException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidExpressionTextException(String message) {
        super(message);
    }

    public InvalidExpressionTextException(Throwable cause) {
        super(cause);
    }
}
