package com.example.reservation.exception;

public class PinExhaustedException extends RuntimeException {

    public PinExhaustedException() {
        super("현재 예약 가능한 PIN이 모두 소진되었습니다.");
    }
}