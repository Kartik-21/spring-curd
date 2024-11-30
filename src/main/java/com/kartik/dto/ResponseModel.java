package com.kartik.dto;

import org.springframework.http.HttpStatus;

public class ResponseModel<T> {
    private HttpStatus status;

    private T data;

    public ResponseModel(T data, HttpStatus status) {
        this.status = status;
        this.data = data;
    }

    public ResponseModel(HttpStatus status) {
        this.status = status;
    }

    public ResponseModel() {
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
