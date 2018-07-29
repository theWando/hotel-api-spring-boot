package com.pana.hotel.controller.util;

import com.pana.hotel.controller.model.Response;
import com.pana.hotel.controller.model.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtil {

    private ResponseUtil() {
    }

    public static <T> ResponseEntity<Response> buildOkStatusResponse(T responseData) {
        ResponseStatus responseStatus = new ResponseStatus(HttpStatus.OK);
        Response<T> response = new Response<>(responseStatus, responseData);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public static <T> ResponseEntity<Response> buildOkStatusResponseWithCustomMessage(T responseData, String customDescription) {
        ResponseStatus responseStatus = new ResponseStatus(HttpStatus.OK, HttpStatus.OK.getReasonPhrase() + " : " + customDescription);
        Response<T> response = new Response<>(responseStatus, responseData);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public static <T> ResponseEntity<Response> buildStatusResponse(Exception e, HttpStatus status, HttpStatus httpStatus) {
        ResponseStatus responseStatus = new ResponseStatus(status, e.getMessage());
        Response<T> response = new Response<>(responseStatus);
        return new ResponseEntity<>(response, httpStatus);
    }

}
