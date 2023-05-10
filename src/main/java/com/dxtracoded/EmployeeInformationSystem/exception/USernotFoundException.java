package com.dxtracoded.EmployeeInformationSystem.exception;

public class USernotFoundException extends RuntimeException{
    public USernotFoundException(Integer id) {

        super("Could not found the user with id "+id);
    }
}
