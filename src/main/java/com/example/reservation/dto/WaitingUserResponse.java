package com.example.reservation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class WaitingUserResponse {

    private int waitingOrder;

    private String name;
}