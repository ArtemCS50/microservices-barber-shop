package com.diploma.scheduleservice.exeption;

public class ScheduleNotFoundException extends RuntimeException{
    public ScheduleNotFoundException (String name){
        super(name);
    }
}
