package com.diploma.catalogservice.exception;

public class MasterNotFoundException extends  RuntimeException{

    public MasterNotFoundException(String name){
        super(name);
    }

}
