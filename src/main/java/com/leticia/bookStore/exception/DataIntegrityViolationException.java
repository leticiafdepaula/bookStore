package com.leticia.bookStore.exception;

public class DataIntegrityViolationException extends RuntimeException {
    private static long serialversionUID = 1L;

    public DataIntegrityViolationException(String message, Throwable cause) {

    }

    public DataIntegrityViolationException(String message) {
        super ();
    }
}
