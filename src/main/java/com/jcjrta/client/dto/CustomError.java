package com.jcjrta.client.dto;

import java.time.Instant;

public class CustomError {
    private Instant timesTemp;
    private Integer status;
    private String error;
    private String path;

    public CustomError(Instant timesTemp, Integer status, String error, String path) {
        this.timesTemp = timesTemp;
        this.status = status;
        this.error = error;
        this.path = path;
    }

    public Instant getTimesTemp() {
        return timesTemp;
    }

    public Integer getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getPath() {
        return path;
    }
}
