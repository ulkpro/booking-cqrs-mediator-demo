package com.example.booking.repository;

import com.example.booking.domain.Booking;
import java.util.*;

public class BookingRepository {
    private final Map<String, Booking> db = new HashMap<>();

    public boolean existsByFlightNumber(String flightNumber) {
        return db.values().stream()
                .anyMatch(b -> b.getTrip().flightNumber().equals(flightNumber));
    }

    public void save(Booking booking) {
        db.put(booking.getId(), booking);
    }

    public Booking findById(String id) {
        return db.get(id);
    }

    public Collection<Booking> findAll() {
        return db.values();
    }
}