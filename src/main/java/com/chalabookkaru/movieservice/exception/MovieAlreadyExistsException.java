package com.chalabookkaru.movieservice.exception;

import org.springframework.http.HttpStatus;

public class MovieAlreadyExistsException extends RuntimeException {

    private HttpStatus httpStatus;

    public MovieAlreadyExistsException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;

    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
