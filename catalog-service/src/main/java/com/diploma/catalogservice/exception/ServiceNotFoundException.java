package com.diploma.catalogservice.exception;

public class ServiceNotFoundException extends RuntimeException {

    public ServiceNotFoundException(String message) {
        super(message);
    }
}
