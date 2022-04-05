package com.capstone.ecommerce.exception.types;

public class InvalidInputException extends RuntimeException{
    private String message;

    public InvalidInputException(String message){
        super(message);
        this.message=message;
    }
}
