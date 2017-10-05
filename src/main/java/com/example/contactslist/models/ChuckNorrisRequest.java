package com.example.contactslist.models;

public class ChuckNorrisRequest {
    private String status;
    private ChuckNorrisJoke value;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ChuckNorrisJoke getValue() {
        return value;
    }

    public void setValue(ChuckNorrisJoke value) {
        this.value = value;
    }
}
