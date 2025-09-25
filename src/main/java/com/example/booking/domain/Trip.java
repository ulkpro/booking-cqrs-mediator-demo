package com.example.booking.domain;

import java.time.LocalDateTime;

public record Trip(
        String flightNumber,
        String departureAirport,
        String arrivalAirport,
        LocalDateTime flightDate
) { }
