package com.example.demo.exception;

public class IdNotFoundException extends Exception{

    @Override
    public String getMessage() {
        return "Id not exists.";
    }
}
