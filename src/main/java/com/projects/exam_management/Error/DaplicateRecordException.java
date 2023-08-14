package com.projects.exam_management.Error;

public class DaplicateRecordException extends RuntimeException {

    public DaplicateRecordException() {
        super();
    }

    public DaplicateRecordException(String message) {
        super(message);
    }
}
