package com.epam.task.exception;

public class ComponentException extends Exception {
    public ComponentException() {
        super();
    }

    public ComponentException(String message, Throwable cause) {
        super(message, cause);
    }

    public ComponentException(String message) {
        super(message);
    }

    public ComponentException(Throwable cause) {
        super(cause);
    }
}
