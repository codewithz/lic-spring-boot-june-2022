package com.lic.config;

import org.springframework.http.HttpStatus;

public class ApiSuccessPayload {

    String message;
    int status;
    String httpStatus;
    boolean success;
    boolean error;
    Object body;

    public ApiSuccessPayload() {
    }

    public ApiSuccessPayload(String message, int status, String httpStatus, boolean success, boolean error, Object body) {
        this.message = message;
        this.status = status;
        this.httpStatus = httpStatus;
        this.success = success;
        this.error = error;
        this.body = body;
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

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "ApiSuccessPayload{" +
                "message='" + message + '\'' +
                ", status=" + status +
                ", httpStatus='" + httpStatus + '\'' +
                ", success=" + success +
                ", error=" + error +
                ", body=" + body +
                '}';
    }

    public static ApiSuccessPayload build(Object body, String message, HttpStatus status){
        ApiSuccessPayload payload=new ApiSuccessPayload();

        payload.setBody(body);
        payload.setMessage(message);
        payload.setStatus(status.value());
        payload.setHttpStatus(String.valueOf(status));
        payload.setSuccess(true);
        payload.setError(false);

        return payload;
    }
}
