package org.example.Exceptions;

public class InvalidRowsOrColumnsException extends RuntimeException {
    public InvalidRowsOrColumnsException(String message) {
        super(message);
    }
}
