package com.apirestful.Locar.model;

public class NotificationResponse {
    String message;

    public NotificationResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
