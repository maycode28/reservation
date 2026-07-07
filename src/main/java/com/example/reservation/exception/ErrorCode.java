package com.example.reservation.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {

    INVALID_PIN(HttpStatus.NOT_FOUND, "INVALID_PIN", "유효하지 않은 PIN입니다."),

    PIN_EXHAUSTED(HttpStatus.CONFLICT, "PIN_EXHAUSTED", "예약 가능한 PIN이 모두 소진되었습니다."),

    ALREADY_ENTERED(HttpStatus.CONFLICT, "ALREADY_ENTERED", "현재 다른 사용자가 이용 중입니다."),

    NOT_MY_TURN(HttpStatus.CONFLICT, "NOT_MY_TURN", "아직 입장 순서가 아닙니다."),

    NOT_CURRENT_USER(HttpStatus.CONFLICT, "NOT_CURRENT_USER", "현재 입장 중인 사용자가 아닙니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;

    ErrorCode(HttpStatus status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}