package com.jcjrta.client.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends CustomError{

    private List<FieldMessage> fieldMessageList = new ArrayList<>();

    public ValidationError(Instant timesTemp, Integer status, String error, String path) {
        super(timesTemp, status, error, path);
    }

    public List<FieldMessage> getFieldMessageList() {
        return fieldMessageList;
    }

    public void addErrors(String name, String message){
        fieldMessageList.add(new FieldMessage(name, message));
    }
}
