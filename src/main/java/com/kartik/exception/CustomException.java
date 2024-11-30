package com.kartik.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException {

    @Getter
    private final HttpStatus status;

    public CustomException(String msg) {
        super(msg);
        this.status = HttpStatus.CREATED;
    }
}