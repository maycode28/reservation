package com.example.reservation.exception;

public class InvalidPinException extends RuntimeException {

    public InvalidPinException() {
        super("유효하지 않은 PIN입니다.");
    }
}