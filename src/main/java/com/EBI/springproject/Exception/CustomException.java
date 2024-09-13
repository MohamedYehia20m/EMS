package com.EBI.springproject.Exception;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor


public class CustomException extends RuntimeException {
    private String errorCode;
    private String message;
    private String codeDetails;
}
