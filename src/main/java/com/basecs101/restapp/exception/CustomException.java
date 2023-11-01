package com.basecs101.restapp.exception;

public class CustomException extends RuntimeException{
    public CustomException(String msg){
        super(msg);
    }
}
