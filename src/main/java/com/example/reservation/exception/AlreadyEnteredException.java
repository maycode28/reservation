package com.example.reservation.exception;

public class AlreadyEnteredException extends RuntimeException {

    public AlreadyEnteredException() {
        super("현재 다른 사용자가 이용 중입니다.");
    }
}