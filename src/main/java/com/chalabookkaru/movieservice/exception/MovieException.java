package com.chalabookkaru.movieservice.exception;

import org.springframework.http.HttpStatus;

public class MovieException extends RuntimeException {

    private HttpStatus httpStatus;

    public MovieException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;

    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
