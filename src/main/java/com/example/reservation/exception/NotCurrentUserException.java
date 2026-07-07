package com.example.reservation.exception;

public class NotCurrentUserException extends RuntimeException {

    public NotCurrentUserException() {
        super("현재 입장 중인 사용자가 아닙니다.");
    }
}