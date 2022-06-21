package com.lic.config;

import java.time.LocalDateTime;

public class ApiExceptionPayload {

    String message;
    int status;
    String httpStatus;
    boolean success;
    boolean error;
    LocalDateTime timestamp;
    String path;

    public ApiExceptionPayload(String message) {
        this.message = message;
    }

    public ApiExceptionPayload(String message, int status, String httpStatus, boolean success, boolean error, LocalDateTime timestamp, String path) {
        this.message = message;
        this.status = status;
        this.httpStatus = httpStatus;
        this.success = success;
        this.error = error;
        this.timestamp = timestamp;
        this.path = path;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(String httpStatus) {
        this.httpStatus = httpStatus;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean getError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "ApiExceptionPayload{" +
                "message='" + message + '\'' +
                ", status=" + status +
                ", httpStatus='" + httpStatus + '\'' +
                ", success=" + success +
                ", error=" + error +
                ", timestamp=" + timestamp +
                ", path='" + path + '\'' +
                '}';
    }
}
