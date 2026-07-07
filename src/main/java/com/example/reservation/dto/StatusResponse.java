package com.example.reservation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class StatusResponse {

    private CurrentUserResponse currentUser;

    private List<WaitingUserResponse> waitingQueue;
}