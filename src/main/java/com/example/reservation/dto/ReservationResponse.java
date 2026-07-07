package com.example.reservation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ReservationResponse {

    private String pin;

    private int waitingOrder;
}