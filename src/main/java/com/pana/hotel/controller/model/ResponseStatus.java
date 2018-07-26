package com.pana.hotel.controller.model;

import org.springframework.http.HttpStatus;

public class ResponseStatus {

    private int code;

    private String description;

    public ResponseStatus() {
    }

    public ResponseStatus(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public ResponseStatus(HttpStatus status, String description) {
        this.code = status.value();
        this.description = description;
    }

    public ResponseStatus(HttpStatus status) {
        this.code = status.value();
        this.description = status.getReasonPhrase();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
