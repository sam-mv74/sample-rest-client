package com.faash.sample_rest_client.model;

import java.util.UUID;

public class ResponseBodyModel {
    private Boolean success;

    private Object result;

    private String message;

    private String responseCode;

    private UUID trackingCode;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Object getResult() {
        return result;
    }

    public void setResult( Object result) {
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
}
