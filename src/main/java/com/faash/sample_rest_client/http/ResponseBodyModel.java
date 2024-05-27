package com.faash.sample_rest_client.http;

import java.util.List;
import java.util.UUID;

public class ResponseBodyModel<T> {
    private Boolean success;

    private T result;

    private String message;

    private String responseCode;

    private UUID trackingCode;
    private List<Error> errors;
    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public T getResult() {
        return result;
    }

    public void setResult( T result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public UUID getTrackingCode() {
        return trackingCode;
    }

    public void setTrackingCode(UUID trackingCode) {
        this.trackingCode = trackingCode;
    }

    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }
}
