package com.springSecurity.Spring.Security.ExceptionHandler;

public class jwtException extends RuntimeException {
    public jwtException(String message) {
        super(message);
    }
}
