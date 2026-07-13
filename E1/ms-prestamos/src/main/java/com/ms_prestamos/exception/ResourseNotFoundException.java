package com.ms_prestamos.exception;

public class ResourseNotFoundException extends RuntimeException {
    public ResourseNotFoundException(String message) {
        super(message);
    }
}
