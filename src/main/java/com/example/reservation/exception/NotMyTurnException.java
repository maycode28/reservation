package com.example.reservation.exception;

public class NotMyTurnException extends RuntimeException {

    public NotMyTurnException() {
        super("아직 입장 순서가 아닙니다.");
    }
}