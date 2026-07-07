package com.example.reservation.repository;

import com.example.reservation.domain.Reservation;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

@Repository
public class ReservationRepository {

    private final ConcurrentHashMap<String, Reservation> reservationMap = new ConcurrentHashMap<>();

    private final LinkedBlockingQueue<Reservation> waitingQueue = new LinkedBlockingQueue<>();

    private final LinkedBlockingQueue<String> availablePins = new LinkedBlockingQueue<>();


    private final AtomicReference<Reservation> currentReservation = new AtomicReference<>();

    private final AtomicLong sequence = new AtomicLong(1);

    public ReservationRepository() {
        initializePins();
    }

    private void initializePins() {
        List<String> pins = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {

            pins.add(String.format("%04d", i));

        }

        Collections.shuffle(pins);

        availablePins.addAll(pins);
    }

    public String issuePin() {
        return availablePins.poll();
    }


    public void returnPin(String pin) {
        if (pin != null) {
            availablePins.offer(pin);
        }
    }


    public Reservation saveReservation(Reservation reservation) {
        reservation.setId(sequence.getAndIncrement());
        reservationMap.put(reservation.getPin(), reservation);
        return reservation;
    }


    public Reservation findReservationByPin(String pin) {
        return reservationMap.get(pin);
    }


    public void enqueue(Reservation reservation) {
        waitingQueue.offer(reservation);
    }


    public Reservation peekWaitingReservation() {
        return waitingQueue.peek();
    }


    public Reservation pollWaitingReservation() {
        return waitingQueue.poll();
    }


    public Reservation getCurrentReservation() {
        return currentReservation.get();
    }


    public void setCurrentReservation(Reservation reservation) {
        currentReservation.set(reservation);
    }


    public void clearCurrentReservation() {
        currentReservation.set(null);
    }


    public List<Reservation> getWaitingQueue() {
        return new ArrayList<>(waitingQueue);
    }


    public int getWaitingOrder(String pin) {

        int order = 1;

        for (Reservation reservation : waitingQueue) {

            if (reservation.getPin().equals(pin)) {

                return order;

            }

            order++;

        }

        return 0;
    }


    public int availablePinCount() {
        return availablePins.size();
    }


    public int waitingCount() {
        return waitingQueue.size();
    }

}