package com.example.booking.query;

import com.example.booking.dto.BookingDto;
import com.example.booking.mediator.ICommand;
import java.util.List;

public record GetAllBookingsQuery() implements ICommand<List<BookingDto>> { }