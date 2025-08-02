package com.tcs.productService.exception;

import com.tcs.productService.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductServiceCustomException.class)
    public ResponseEntity<ErrorResponse> productNotfound(ProductServiceCustomException productServiceCustomException)
    {
        ErrorResponse response = ErrorResponse.builder()
                .errorMessage(productServiceCustomException.getMessage())
                .errorCode(productServiceCustomException.status_code)
                .build();
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
