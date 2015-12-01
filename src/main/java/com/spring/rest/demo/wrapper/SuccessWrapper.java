package com.spring.rest.demo.wrapper;

public class SuccessWrapper {
    private String message;

    public SuccessWrapper(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
