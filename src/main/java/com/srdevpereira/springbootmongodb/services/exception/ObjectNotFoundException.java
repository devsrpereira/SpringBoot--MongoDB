package com.srdevpereira.springbootmongodb.services.exception;

public class ObjectNotFoundException extends RuntimeException{


    public ObjectNotFoundException(String message) {
        super(message);
    }
}
