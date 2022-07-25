package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class MovieNotFoundException extends RuntimeException {

    public MovieNotFoundException() {
        super();
    }

    public MovieNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public MovieNotFoundException(String msg) {
        super(msg);
    }

    public MovieNotFoundException(Throwable cause) {
        super(cause);
    }
}
