package com.diploma.feedbackservice.exeption;

public class FeedbackNotFoundException extends RuntimeException{

    public FeedbackNotFoundException(String name){
        super(name);
    }
}
