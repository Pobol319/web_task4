package com.epam.task.exception;

public class InvalidExpressionParserException extends Exception {
    public InvalidExpressionParserException() {
        super();
    }

    public InvalidExpressionParserException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidExpressionParserException(String message) {
        super(message);
    }

    public InvalidExpressionParserException(Throwable cause) {
        super(cause);
    }
}
