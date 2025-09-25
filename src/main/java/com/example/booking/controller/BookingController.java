package com.example.booking.controller;

import com.example.booking.command.CreateBookingCommand;
import com.example.booking.dto.BookingDto;
import com.example.booking.dto.CreateBookingRequestDto;
import com.example.booking.mediator.IMediator;
import com.example.booking.query.GetAllBookingsQuery;
import com.example.booking.query.GetBookingByIdQuery;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bookings")
public class BookingController {
    private final IMediator mediator;

    public BookingController(IMediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping
    public ResponseEntity<BookingDto> create(@RequestBody CreateBookingRequestDto dto) {
        var result = mediator.send(
                new CreateBookingCommand(
                        dto.passengerName(),
                        dto.passengerEmail(),
                        dto.flightNumber(),
                        dto.departureAirport(),
                        dto.arrivalAirport(),
                        dto.flightDate()
                )
        );
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingDto> getById(@PathVariable String id) {
        var result = mediator.send(new GetBookingByIdQuery(id));
        return ResponseEntity.ok(result);
    }

    @GetMapping
    public ResponseEntity<List<BookingDto>> getAll() {
        var result = mediator.send(new GetAllBookingsQuery());
        return ResponseEntity.ok(result);
    }
}