package com.example.booking.dto;

import java.time.LocalDateTime;

public record BookingDto(
        String id,
        String passengerName,
        String passengerEmail,
        String flightNumber,
        String departureAirport,
        String arrivalAirport,
        LocalDateTime flightDate
) { }