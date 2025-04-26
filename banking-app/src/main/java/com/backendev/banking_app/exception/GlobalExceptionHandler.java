package com.backendev.banking_app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    //Handle Specific Exception - Account Exception
    @ExceptionHandler(AccountException.class)
    public ResponseEntity<ErrorDetail> handleAccountException(AccountException exception,
                                                              WebRequest webRequest){
        ErrorDetail errorDetail = new ErrorDetail(
                LocalDateTime.now(),
                exception.getMessage(),
                webRequest.getDescription(false),"ACCOUNT_NOT_FOUND");
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //Handle Generic Exception
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetail> handleGenericException(Exception exception,
                                                              WebRequest webRequest){
        ErrorDetail errorDetail = new ErrorDetail(
                LocalDateTime.now(),
                exception.getMessage(),
                webRequest.getDescription(false),"INTERNAL_SERVER_ERROR");
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
