package com.ualace36.designpatternspring.exception;

public class BadRequestException extends Exception {
    public BadRequestException(String msg) {
        super(msg);
    }
}
