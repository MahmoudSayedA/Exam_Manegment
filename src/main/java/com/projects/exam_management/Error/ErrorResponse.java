package com.projects.exam_management.Error;

import java.time.LocalDateTime;
import java.util.List;

public class ErrorResponse {
    private String message;
    private Boolean success;
    private LocalDateTime time;
    private List<String> details;
    public ErrorResponse() {
        super();
    }

    public ErrorResponse(String message, List<String> details) {
        super();
        this.message = message;
        this.details = details;
        this.time = LocalDateTime.now();
        this.success = false;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public List<String> getDetails() {
        return details;
    }

    public void setDetails(List<String> details) {
        this.details = details;
    }
}
