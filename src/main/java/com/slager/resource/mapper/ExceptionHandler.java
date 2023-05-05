package com.slager.resource.mapper;

import org.springframework.dao.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.*;
import org.springframework.web.servlet.mvc.method.annotation.*;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(value = {
            DataAccessException.class
    })
    protected ResponseEntity<Object> handleDataAccessException(
            RuntimeException runtimeException, WebRequest request){
        String bodyOfResponse = "Something went wrong accessing the application data. " +
                "Please try again or contact the software provider if the issue persists.";
        return handleExceptionInternal(runtimeException, bodyOfResponse, new HttpHeaders(),
                HttpStatus.INTERNAL_SERVER_ERROR, request);
    }
}
