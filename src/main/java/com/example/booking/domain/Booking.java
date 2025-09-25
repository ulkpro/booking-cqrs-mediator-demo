package com.example.booking.domain;

import java.util.UUID;

public class Booking {
    private final String id;
    private final PassengerInfo passengerInfo;
    private final Trip trip;

    public Booking(PassengerInfo passengerInfo, Trip trip) {
        this.id = UUID.randomUUID().toString();
        this.passengerInfo = passengerInfo;
        this.trip = trip;
    }

    public String getId() { return id; }
    public PassengerInfo getPassengerInfo() { return passengerInfo; }
    public Trip getTrip() { return trip; }
}
