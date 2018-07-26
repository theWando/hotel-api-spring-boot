package com.pana.hotel.controller.model;

import org.springframework.http.HttpStatus;

public class Response<T> {

    private T result;

    private ResponseStatus status;

    public Response() {
        this.status = new ResponseStatus(HttpStatus.OK, "");
    }

    public Response(ResponseStatus status) {
        this.status = status;
    }

    public Response(ResponseStatus status, T result) {
        this.result = result;
        this.status = status;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }
}
