package com.EBI.springproject.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Setter
@Getter
@AllArgsConstructor
@ControllerAdvice
public class GlobalException {

    @ExceptionHandler
    ResponseEntity<?> NotFound (CustomException customException) {
        ErrorResponse response= new ErrorResponse(customException.getErrorCode(),customException.getMessage(),customException.getCodeDetails());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
