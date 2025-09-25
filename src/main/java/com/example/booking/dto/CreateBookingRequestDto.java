package com.example.booking.dto;

import java.time.LocalDateTime;

public record CreateBookingRequestDto(
        String passengerName,
        String passengerEmail,
        String flightNumber,
        String departureAirport,
        String arrivalAirport,
        LocalDateTime flightDate
) { }
