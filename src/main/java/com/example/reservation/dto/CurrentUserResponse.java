package com.example.reservation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CurrentUserResponse {

    private String name;

    private String pin;

    private LocalDateTime reservationTime;
}