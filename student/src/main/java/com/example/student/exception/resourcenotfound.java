package com.example.student.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class resourcenotfound extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public resourcenotfound(String message) {
        super(message);
    }

    public resourcenotfound(String message, Throwable throwable) {
        super(message, throwable);
    }

    public resourcenotfound(Long id) {

    }
}