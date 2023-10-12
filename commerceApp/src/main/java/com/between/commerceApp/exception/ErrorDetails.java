package com.between.commerceApp.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Builder
@Data
public class ErrorDetails {

    private HttpStatus errorCode;
    private String details;
    private String message;

}