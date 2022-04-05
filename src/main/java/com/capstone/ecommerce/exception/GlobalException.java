package com.capstone.ecommerce.exception;

import com.capstone.ecommerce.exception.types.InvalidInputException;
import com.capstone.ecommerce.model.MarsResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(value= InvalidInputException.class)
    public ResponseEntity<MarsResponse> inputInvalid(InvalidInputException exception){
        MarsResponse marsResponse = new MarsResponse(exception.getMessage(), HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST);
                return new ResponseEntity<MarsResponse>(marsResponse, HttpStatus.BAD_REQUEST);
    }

}
