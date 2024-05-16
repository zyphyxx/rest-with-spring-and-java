package com.example.restwithspring.exceptions.handler;

import lombok.Getter;

import java.io.Serializable;
import java.util.Date;

@Getter
public class ExceptionsResponse implements Serializable {

    public Date timestamp;
    public String details;
    public String message;

    public ExceptionsResponse(Date timestamp, String details, String message) {
        this.timestamp = timestamp;
        this.details = details;
        this.message = message;
    }
}
