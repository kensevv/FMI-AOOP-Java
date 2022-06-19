package com.company;

public enum Face {

    HEAD("HEAD")
    , TAIL("TAIL");

    private final String value;


    private Face(String value){
        this.value = value == null ? "HEAD": value;
    }


    @Override
    public String toString() {
        return String.format("Face %s", value);
    }
};