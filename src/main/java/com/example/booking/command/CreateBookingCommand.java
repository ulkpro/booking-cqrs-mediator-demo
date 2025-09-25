package com.example.booking.command;

import com.example.booking.dto.BookingDto;
import com.example.booking.mediator.ICommand;
import java.time.LocalDateTime;

public record CreateBookingCommand(
        String passengerName,
        String passengerEmail,
        String flightNumber,
        String departureAirport,
        String arrivalAirport,
        LocalDateTime flightDate
) implements ICommand<BookingDto> { }