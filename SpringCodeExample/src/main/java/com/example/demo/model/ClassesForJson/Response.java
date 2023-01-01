package com.example.demo.model.ClassesForJson;

public class Response <T>{
    private boolean status;
    private String message;
    public T object;

    public boolean isStatus(boolean b) {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
