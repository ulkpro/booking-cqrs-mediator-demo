package com.example.booking.query;

import com.example.booking.dto.BookingDto;
import com.example.booking.mediator.ICommand;

public record GetBookingByIdQuery(String bookingId) implements ICommand<BookingDto> { }
