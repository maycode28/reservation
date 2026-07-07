package com.example.reservation.repository;

import com.example.reservation.domain.Reservation;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ReservationRepository {

    private final ConcurrentHashMap<String, Reservation> reservationMap = new ConcurrentHashMap<>();

    private final LinkedBlockingQueue<Reservation> waitingQueue = new LinkedBlockingQueue<>();

    private final LinkedBlockingQueue<String> availablePins = new LinkedBlockingQueue<>();

    private final AtomicLong sequence = new AtomicLong(1);

    public ReservationRepository() {
        initializePins();
    }

    private void initializePins() {
        for (int i = 0; i < 10000; i++) {
            availablePins.offer(String.format("%04d", i));
        }
    }
}