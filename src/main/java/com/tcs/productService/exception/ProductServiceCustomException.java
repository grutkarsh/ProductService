package com.tcs.productService.exception;

public class ProductServiceCustomException extends  RuntimeException{

    String status_code;
    public ProductServiceCustomException(String message, String status_code) {

        super(message);
        this.status_code=status_code;
    }
}
