package com.dxtracoded.EmployeeInformationSystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@Controller
public class UserNotFoundAdvise {

    @ResponseBody
    @ExceptionHandler(USernotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String,String>exceptionHandler(USernotFoundException exception){

        Map<String,String> errorMaps= new HashMap<>();

        errorMaps.put("error message",exception.getMessage());

        return errorMaps;
    }
}
