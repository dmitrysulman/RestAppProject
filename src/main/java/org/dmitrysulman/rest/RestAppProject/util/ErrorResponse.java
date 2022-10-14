package org.dmitrysulman.rest.RestAppProject.util;

import java.time.Instant;

public class ErrorResponse {
    private String message;
    private Instant timestamp;

    private int status;

    public ErrorResponse() {
    }

    public ErrorResponse(String message, Instant timestamp, int status) {
        this.message = message;
        this.timestamp = timestamp;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
