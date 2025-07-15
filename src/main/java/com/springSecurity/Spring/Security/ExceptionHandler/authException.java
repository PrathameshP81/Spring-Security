package com.springSecurity.Spring.Security.ExceptionHandler;

public class authException extends RuntimeException {
    public authException(String message) {
        super(message);
    }
}
