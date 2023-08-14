package com.projects.exam_management.Error;

public class RecordNotFondException extends RuntimeException{

    public RecordNotFondException() {
    }

    public RecordNotFondException(String message) {
        super(message);
    }
}
