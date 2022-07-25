package com.example.demo.exception;


public class MovieNotFoundException extends RuntimeException {
    private final String msg;

    public MovieNotFoundException() {
        this.msg = "No item with such id!";
    }

    @Override
    public String getLocalizedMessage() {
        return msg;
    }
}
