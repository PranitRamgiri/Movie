package com.chalabookkaru.movieservice.exception;

import org.springframework.http.HttpStatus;

public class MovieNotFoundException extends RuntimeException {

    private HttpStatus httpStatus;

    public MovieNotFoundException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;

    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
