package com.EBI.springproject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
public class GeneralResponse<T> {
    private String code;
    private String message;
    private T Data;


}
